package org.example;

import Basic_Data_Structures.Dictionary.Dictionary;
import Basic_Data_Structures.Lists.ComplementList;
import Basic_Data_Structures.Lists.LinkedList;
import Basic_Data_Structures.Lists.Node;
import Basic_Data_Structures.Queue.myQueue;
import Basic_Data_Structures.Stack.DynamicStack;
import Basic_Data_Structures.Stack.StaticStack;
import Basic_Data_Structures.Trees.AVLTree;
import Basic_Data_Structures.Trees.BinarySearchTree;
import Basic_Data_Structures.Trees.Tree;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        // ----- ARRAYS -----
//        int[] A1 = new int[]{2, 5, 3, 1, 10, 1};
//        int[] A2 = new int[]{3, 1};
//        ComplementList E1 = new ComplementList();
//        int arr[] = E1.removeA1fromA2(A1, A2);
//        E1.printArray(arr, "A1 complemented with A2");
//        System.out.println();
//
//        // ----- NODES -----
//
//        // Create L1: 1 -> 3 -> 5
//        LinkedList L1 = new LinkedList();
//        L1.append(1);
//        L1.append(2);
//        L1.append(3);
//
//        // Create L2: 2 -> 3 -> 4
//        LinkedList L2 = new LinkedList();
//        L2.append(2);
//        L2.append(3);
//        L2.append(4);
//
//        E1.sortedComplementInit(L1, L2);
//        System.out.println();
//
//        // ----- DICTIONARY -----
//        Dictionary<Integer, String> myDictionary = new Dictionary<>();
//        Integer[] keys = {10, 20, 5, 15, 25};
//        String[] values = {"ten", "twenty", "five", "fifteen", "twenty-five"};
//        myDictionary.fillDictionary(keys, values);
//        myDictionary.printDictionary();
//
//        myDictionary.insert(6, "six");
//        myDictionary.printDictionary();
//
//        myDictionary.insert(4, "four");
//        myDictionary.printDictionary();
//
//        System.out.println("Key '6' contains data: " + myDictionary.search(6));
//
//        System.out.println("Deleting key 6.");
//        myDictionary.delete(6);
//        myDictionary.printDictionary();
//
//        // ----- STATIC STACK -----
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
//        // ----- DYNAMIC STACK -----
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
//        // ----- QUEUE -----
//        myQueue<Integer> Q1 = new myQueue<>(10);
//        Integer elements[] = {1, 2, 3, 4, 5};
//        Q1.fillQueue(elements);
//        Q1.printQueue();
//        System.out.println("Running the first dequeue(): " + Q1.dequeue());
//        Q1.printQueue();
//        System.out.println("Enqueueing the element 7.");
//        Q1.enqueue(7);
//        Q1.printQueue();
//
//        // ----- TREES -----
//        Node N1 = new Node(1);
//        Tree T1 = new Tree();
//        T1.fillTree();
//        System.out.println("The number of nodes is: " + T1.countnodes(N1));
//
//        BinarySearchTree BST1 = new BinarySearchTree();
//        BST1.fillTree();
//        System.out.println("Printing BST in-order:");
//        BST1.printTree();
//
//        System.out.println("\nSearching for key 4:");
//        Node found = BST1.search(4);
//        System.out.println(found != null ? "Found node: " + found.data : "Key not found");
//
//        System.out.println("\nInserting key 7:");
//        BST1.bstInsert(7);
//        BST1.printTree();

        Node N3 = new Node(1, 1);
        AVLTree AVLT1 = new AVLTree();
        AVLT1.createAVLTree(N3);
        System.out.println("Printing AVL tree in-order:");
        AVLT1.printTree();
    }
}