package Algorithms;

import Basic_Data_Structures.Heap.PriorityQueue;
import Basic_Data_Structures.Lists.Node;
import Basic_Data_Structures.Trees.Tree;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Huffman<T> extends Tree {
    Map<Character, String> huffmanMap;

    // O(n log n)
    private void buildHuffman(String inputFilePath) {
        ArrayList<Character> f = new ArrayList<>();
        ArrayList<Integer> c = new ArrayList<>();
        huffmanHelper(f, c, inputFilePath);

        if (f.size() != c.size() || f.isEmpty())
            throw new IllegalArgumentException("Invalid input: frequency and character lists must be non-empty and of equal size");

        int n = f.size();
        PriorityQueue<Integer> Q = new PriorityQueue<>(n + 1, 2);

        for (int i = 0; i < n; i++) {
            Node<Integer> z = new Node<>((int) f.get(i), c.get(i), i + 1, false);
            Q.insert(z);
        }

        for (int i = 0; i < n - 1; i++) {
            Node<Integer> z1 = Q.findMin();
            Q.deleteMin();
            Node<Integer> z2 = Q.findMin();
            Q.deleteMin();

            Node<Integer> z = new Node<>(null, z1.getKey() + z2.getKey(), i + n + 1, false);
            z.setLeft(z1);
            z.setRight(z2);
            z1.setParent(z);
            z2.setParent(z);

            Q.insert(z);
        }

        this.root = Q.findMin(); // Set the root of this Huffman instance
    }

    private void huffmanHelper(ArrayList<Character> f, ArrayList<Integer> c, String inputFilePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            int charCode;
            while ((charCode = reader.read()) != -1) {
                char currentChar = (char) charCode;
                int index = f.indexOf(currentChar);
                if (index == -1) {
                    f.add(currentChar);
                    c.add(1);
                } else
                    c.set(index, c.get(index) + 1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void assignHuffmanCodes() {
        if (this.root != null)
            assignCodesHelper(this.root, "");
    }

    private void assignCodesHelper(Node<T> node, String code) {
        if (node == null)
            return;

        if (node.getData() != null)
            node.setCode(code.isEmpty() ? "0" : code);

        assignCodesHelper(node.getLeft(), code + "0");
        assignCodesHelper(node.getRight(), code + "1");
    }

    private void writeHuffmanMap() {
        Map<Character, String> huffmanMap = new HashMap<>();
        collectCodesHelper(this.root, "", huffmanMap);
        this.huffmanMap = huffmanMap;
    }

    private void collectCodesHelper(Node<T> node, String code, Map<Character, String> huffmanMap) {
        if (node == null)
            return;

        if (node.getData() != null)
            huffmanMap.put((char) (int) node.getData(), code.isEmpty() ? "0" : code);

        collectCodesHelper(node.getLeft(), code + "0", huffmanMap);
        collectCodesHelper(node.getRight(), code + "1", huffmanMap);
    }

    public void compressFile(String inputFilePath, String outputFilePath, String codeTablePath) {
        buildHuffman(inputFilePath);
        assignHuffmanCodes();
        writeHuffmanMap();

        // save the code table for decompression later
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(codeTablePath))) {
            for (Map.Entry<Character, String> entry : huffmanMap.entrySet())
                writer.write((entry.getKey() + ":" + entry.getValue() + "\n"));
        } catch (IOException e) {
            throw new RuntimeException("Error writing code table: " + e.getMessage());
        }

        // read input file and encode it
        StringBuilder encodedData = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            int charCode;
            while ((charCode = reader.read()) != -1) {
                char currentChar = (char) charCode;
                String code = huffmanMap.get(currentChar);
                if (code == null)
                    throw new RuntimeException("Character not found in the Huffman Map: " + currentChar);
                encodedData.append(code);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading input file: " + e.getMessage());
        }

        // write encoded data to output file
        try (FileOutputStream fos = new FileOutputStream(outputFilePath)) {
            StringBuilder binaryString = new StringBuilder(encodedData.toString());
            // write the length of the binary string (in bits) for decompression
            int bitLength = binaryString.length();
            // write a 4-byte header with the exact number of encoded bits
            fos.write(bitLength >> 24);
            fos.write(bitLength >> 16);
            fos.write(bitLength >> 8);
            fos.write(bitLength);
            while (binaryString.length() % 8 != 0)
                binaryString.append("0");
            // convert the padded binary string into bytes and write them to the output file.
            for (int i = 0; i < binaryString.length(); i += 8) {
                // makes sure the padding worked
                String byteString = binaryString.substring(i, Math.min(i + 8, binaryString.length()));
                int byteValue = Integer.parseInt(byteString, 2);
                fos.write(byteValue);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing compressed file: " + e.getMessage());
        }

    }

    public void decompressFile(String compressedFilePath, String codeTablePath, String outputFilePath) {
        Map<String, Character> reverseHuffmanCodes = getStringCharacterMap(codeTablePath);

        StringBuilder binaryString = new StringBuilder();
        int bitLength;
        try (FileInputStream fis = new FileInputStream(compressedFilePath)) {
            bitLength = (fis.read() << 24 | (fis.read() << 16) | (fis.read() << 8) | fis.read());
            byte[] bytes = fis.readAllBytes();
            for (byte b : bytes) {
                String binary = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
                binaryString.append(binary);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading compressed file: " + e.getMessage());
        }

        StringBuilder decodedText = new StringBuilder();
        String currentCode = "";
        for (int i = 0; i < bitLength; i++) {
            currentCode += binaryString.charAt(i);
            Character decodedChar = reverseHuffmanCodes.get(currentCode);
            if (decodedChar != null) {
                decodedText.append(decodedChar);
                currentCode = "";
            }
        }

        try (FileWriter writer = new FileWriter(outputFilePath)) {
            writer.write(decodedText.toString());
        } catch (IOException e) {
            throw new RuntimeException("Error writing decompressed file: " + e.getMessage());
        }
    }

    private static Map<String, Character> getStringCharacterMap(String codeTablePath) {
        Map<String, Character> reverseHuffmanCodes = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(codeTablePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    char character = parts[0].charAt(0);
                    String code = parts[1];
                    reverseHuffmanCodes.put(code, character);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading code table: " + e.getMessage());
        }
        return reverseHuffmanCodes;
    }

    public void readFile(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException("Error reading code table: " + e.getMessage());
        }

    }
}
