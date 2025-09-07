package Algorithms;

import Basic_Data_Structures.Heap.PriorityQueue;
import Basic_Data_Structures.Lists.Node;
import Basic_Data_Structures.Stack.StaticStack;
import Basic_Data_Structures.Trees.Tree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Algorithms {

    // O(2^n)
    public void Hanoi(StaticStack p1, StaticStack p2, StaticStack p3, int n) {
        if (n == 1)
            p3.push(p1.pop());
        else {
            Hanoi(p1, p3, p2, n - 1);
            p3.push(p1.pop());
            Hanoi(p2, p1, p3, n - 1);
        }
    }

    // O(n^3)
    public double sumMax1(double[] v) {
        double smax = v[0];
        int n = v.length;

        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++) {
                double s = 0;
                for (int k = i; k <= j; k++)
                    s += v[k];
                if (s > smax)
                    smax = s;
            }
        return smax;
    }

    //O(n^3)
    public double sumMax2(double[] v) {
        int n = v.length;
        double smax = v[1];
        for (int i = 0; i < n; i++) {
            double s = 0;
            for (int j = i; j < n; j++) {
                s += v[j];
                if (s > smax)
                    smax = s;
            }
        }
        return smax;
    }

    // O(n log n)
    public double sumMaxDI(double[] v, int i, int j) {
        if (i > j)
            return 0;
        else if (i == j)
            return v[i];
        else {
            int m = (int) Math.floor((double) (i + j) / 2);
            double l = sumMaxDI(v, i, m - 1);
            double r = sumMaxDI(v, m + 1, j);
            double sa = 0, sb = 0, s = 0;
            int k;
            for (k = m - 1; k >= i; k--) {
                s += v[k];
                if (s > sa)
                    sa = s;
            }
            s = 0;
            for (k = m + 1; k <= j; k++) {
                s += v[k];
                if (s > sb)
                    sb = s;
            }
            return Math.max(l, Math.max(r, v[m] + sa + sb));
        }
    }

    // O(n)
    public int greedyChange(int R, Integer[] T) {
        Arrays.sort(T, Collections.reverseOrder());
        int nm = 0;
        int i = 0;
        while (R > 0 && i < T.length) {
            if (R >= T[i]) {
                R -= T[i];
                nm++;
            } else
                i++;
        }
        if (R > 0) {
            System.out.println("Error: change not payable.");
            return -1;
        } else
            return nm;
    }

    public void huffmanHelper(String filePath, ArrayList<Character> f, ArrayList<Integer> c) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
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

    // O(n log n)
    public Tree<Node<Integer>> huffman() {
        ArrayList<Character> f = new ArrayList<>();
        ArrayList<Integer> c = new ArrayList<>();
        huffmanHelper("input.txt", f, c);

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

        Node<Integer> root = Q.findMin();
        if (root == null)
            return new Tree<>();
        return new Tree(root);
    }
}
