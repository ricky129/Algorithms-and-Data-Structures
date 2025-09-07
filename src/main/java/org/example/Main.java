package org.example;

import Algorithms.Algorithms;
import Basic_Data_Structures.Lists.Node;
import Basic_Data_Structures.Trees.Tree;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

//        System.out.println("\n----- ARRAYS -----");
//        int[] A1 = new int[]{2, 5, 3, 1, 10, 1};
//        int[] A2 = new int[]{3, 1};
//        ComplementList<Integer> E1 = new ComplementList<>();
//        int[] arr = E1.removeA1fromA2(A1, A2);
//        ComplementList.printArray(arr, "A1 complemented with A2");
//        System.out.println();
//
//        System.out.println("\n----- NODES -----");
//
//        System.out.println("Create L1: 1 -> 3 -> 5");
//        LinkedList<Integer> L1 = new LinkedList<>();
//        L1.append(1, 1);
//        L1.append(2, 2);
//        L1.append(3, 3);
//
//        System.out.println("Create L2: 2 -> 3 -> 4");
//        LinkedList<Integer> L2 = new LinkedList<>();
//        L2.append(2, 2);
//        L2.append(3, 3);
//        L2.append(4, 4);
//
//        E1.sortedComplementInit(L1, L2);
//        System.out.println();
//
//        System.out.println("\n----- DICTIONARY -----");
//        Dictionary<Integer, String> myDictionary = new Dictionary<>();
//        Integer[] keys = {10, 20, 5, 15, 25};
//        String[] values = {"ten", "twenty", "five", "fifteen", "twenty-five"};
//        myDictionary.fillDictionary(keys, values);
//        myDictionary.printDictionary();
//
//        System.out.println("Adding 6 to Dictionary.");
//        myDictionary.insert(6, "six");
//        myDictionary.printDictionary();
//
//        System.out.println("Adding 4 to Dictionary.");
//        myDictionary.insert(4, "four");
//        myDictionary.printDictionary();
//
//        System.out.println("Key '6' contains data: " + myDictionary.search(6));
//
//        System.out.println("Deleting key 6.");
//        myDictionary.delete(6);
//        myDictionary.printDictionary();
//
//        System.out.println("\n----- STATIC STACK -----");
//        StaticStack S1 = new StaticStack(10);
//        S1.fillStack();
//        S1.printStack();
//        System.out.println("Running static pop: " + S1.pop());
//        S1.printStack();
//
//        System.out.println("Running static push, adding 7.");
//        S1.push(7);
//        S1.printStack();
//
//        System.out.println("Trying to push the element 8 beyond the static stack's limit:");
//        S1.push(8);
//        S1.printStack();
//
//        System.out.println("\n----- DYNAMIC STACK -----");
//        DynamicStack D1 = new DynamicStack(10);
//        D1.fillStack();
//        D1.printStack();
//        System.out.println("Running dynamic pop: " + D1.pop());
//        D1.printStack();
//        System.out.println("Running dynamic push, adding 7.");
//        D1.push(7);
//        D1.printStack();
//
//        System.out.println("Trying to push the element 8 beyond the dynamic stack's limit:");
//        D1.push(8);
//        D1.printStack();
//
//        System.out.println("\n----- QUEUE -----");
//        myQueue<Integer> Q1 = new myQueue<>(10);
//        Integer[] elements = {1, 2, 3, 4, 5};
//        Q1.fillQueue(elements);
//        Q1.printQueue();
//        System.out.println("Running the first dequeue(): " + Q1.dequeue());
//        Q1.printQueue();
//        System.out.println("Enqueueing the element 7.");
//        Q1.enqueue(7);
//        Q1.printQueue();
//
//        System.out.println("\n----- TREES -----");
//        Node<Integer> N1 = new Node<>(1, 1);
//        Tree<Integer> T1 = new Tree<>();
//        T1.fillTree(N1);
//        System.out.println("The number of nodes is: " + T1.countnodes(N1));
//
//        BinarySearchTree<Integer> BST1 = new BinarySearchTree<>();
//        BST1.fillTree();
//        System.out.println("Printing BST in-order:");
//        BST1.printTree();
//
//        System.out.println("Searching for key 4:");
//        Node<Integer> found = BST1.search(4);
//        System.out.println(found != null ? "Found node: " + found.getData() : "Key not found");
//
//        System.out.println("\nInserting key 7:");
//        BST1.bstInsert(7, 7);
//        BST1.printTree();
//
//        Node<Integer> N3 = new Node<>(1, 1);
//        AVLTree<Integer> AVLT1 = new AVLTree<>();
//        AVLT1.createAVLTree(N3);
//        System.out.println("Printing AVL tree in-order:");
//        AVLT1.printTree();
//
//        System.out.println("----- HEAP -----");
//        BinaryHeap<Integer> heap = new BinaryHeap<>(10);
//        int[] A = new int[]{0, 3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
//        System.out.println("Unsorted array:");
//        System.out.println(Arrays.toString(A));
//        heap.heapsort(A);
//        System.out.println("Sorted array:");
//        System.out.println(Arrays.toString(A));
//
//        // reset A to unsorted state and heapify to test remove
//        heap.setS(A);
//        heap.setHeapsize(A.length-1);
//        heap.heapify(A, A.length-1, 1);
//        System.out.println("After heapify (max-heap):");
//        System.out.println(Arrays.toString(A));
//
//        System.out.println("Removing element 5.");
//        heap.remove(A, heap.getHeapsize(), 5);
//        System.out.println("Array after removing 5:");
//        System.out.println(Arrays.toString(A));

//        // verify heap property by sorting again
//        heap.heapsort(A);
//        System.out.println("Sorted array after remove:");
//        System.out.println(Arrays.toString(A));

//        System.out.println("\n----- HANOI -----");
//        StaticStack source = new StaticStack(10);
//        StaticStack auxiliary = new StaticStack(10);
//        StaticStack destination = new StaticStack(10);
//
//        Integer[] disks = {3, 2, 1};
//        source.fillStack(disks);
//
//        // Print initial state
//        System.out.println("Initial State:");
//        System.out.print("Source Peg: ");
//        source.printStack();
//        System.out.print("Auxiliary Peg: ");
//        auxiliary.printStack();
//        System.out.print("Destination Peg: ");
//        destination.printStack();
//        System.out.println();
//
//        // Create Hanoi object and solve
//        Algorithms hanoi = new Algorithms();
//        hanoi.Hanoi(source, auxiliary, destination, disks.length);
//
//        // Print final state
//        System.out.println("Final State:");
//        System.out.print("Source Peg: ");
//        source.printStack();
//        System.out.print("Auxiliary Peg: ");
//        auxiliary.printStack();
//        System.out.print("Destination Peg: ");
//        destination.printStack();
//
//        System.out.println("\n----- MAX SUB-VECTOR -----");
//        System.out.println("Max sub-vector finder 1st method O(n^3):");
//        Algorithms subvector = new Algorithms();
//        double[] v = new double[]{1, 2.8, 5.3, 7.09, 4, 78, 9, 4.1};
//        System.out.println(subvector.sumMax1(v));
//        System.out.println("Max-subvector finder 2nd method O(n^3):");
//        System.out.println(subvector.sumMax2(v));
//        System.out.println("Max-subvector finder 3rd method O(n log n):");
//        System.out.println(subvector.sumMaxDI(v, 0, v.length - 1) + "\n");

//        System.out.println("\n----- GREEDY CHANGE -----");
//        Algorithms greedyChange = new Algorithms();
//
//        // Test Case 1: Change is possible with standard denominations
//        int R1 = 18;
//        Integer[] T1 = {1, 5, 10};
//        System.out.println("Test Case 1: Amount = " + R1 + ", Denominations = " + java.util.Arrays.toString(T1));
//        int result1 = greedyChange.greedyChange(R1, T1);
//        System.out.println("Minimum number of coins: " + result1);
//        System.out.println();
//
//        // Test Case 2: Change is possible with different denominations
//        int R2 = 30;
//        Integer[] T2 = {1, 2, 5, 10, 25};
//        System.out.println("Test Case 2: Amount = " + R2 + ", Denominations = " + java.util.Arrays.toString(T2));
//        int result2 = greedyChange.greedyChange(R2, T2);
//        System.out.println("Minimum number of coins: " + result2);
//        System.out.println();
//
//        // Test Case 3: Change is not possible
//        int R3 = 7;
//        Integer[] T3 = {2, 4};
//        System.out.println("Test Case 3: Amount = " + R3 + ", Denominations = " + java.util.Arrays.toString(T3));
//        int result3 = greedyChange.greedyChange(R3, T3);
//        System.out.println("Minimum number of coins: " + result3);
//        System.out.println();
//
//        // Test Case 4: Zero amount
//        int R4 = 0;
//        Integer[] T4 = {1, 5, 10};
//        System.out.println("Test Case 4: Amount = " + R4 + ", Denominations = " + java.util.Arrays.toString(T4));
//        int result4 = greedyChange.greedyChange(R4, T4);
//        System.out.println("Minimum number of coins: " + result4);
//        System.out.println();
//
//        // Test Case 5: Single denomination
//        int R5 = 15;
//        Integer[] T5 = {5};
//        System.out.println("Test Case 5: Amount = " + R5 + ", Denominations = " + java.util.Arrays.toString(T5));
//        int result5 = greedyChange.greedyChange(R5, T5);
//        System.out.println("Minimum number of coins: " + result5);

        System.out.println("\n----- HUFFMAN -----");
        Algorithms huffmanAlgorithm = new Algorithms();
        try {
            System.out.println("Building Huffman tree from input.txt...");
            Tree<Node<Integer>> huffmanTree = huffmanAlgorithm.huffman();

            // 3. Print the resulting tree to the console
            System.out.println("\n--- Generated Huffman Tree Structure ---");
            if (huffmanTree != null && huffmanTree.getRoot() != null)
                huffmanTree.printASCIITree();
             else
                System.out.println("The generated tree is empty or null.");
            System.out.println("------------------------------------");
        } catch (Exception e) {
            System.err.println("An error occurred during Huffman tree generation:");
            e.printStackTrace();
        }
    }
}