package Basic_Data_Structures.Trees;

import Basic_Data_Structures.Lists.Node;
import Basic_Data_Structures.Queue.myQueue;

import java.util.ArrayList;

public class Tree<T> {
    public Node<T> root;

    public Tree() {
        this.root = null;
    }

    public Tree(Node<T> root) {
        this.root = root;
    }

    public void visit(Node<T> T) {
        if (T != null)
            System.out.println("Key: " + T.getKey() + ", data: " + T.getData());
    }

    public void visitASCII(Node<T> T) {
        if (T != null && T.getData() != null)
            System.out.println("Key: " + T.getKey() + ", data: " + (char) (int) T.getData());
    }

    public void generateCodes(ArrayList<Character> f, Tree<Node> T) {
        Node x = T.root;
        while (x.getData() != null) {
            if (x == null)
                return;
            visit(x); // Pre-order: visit node first
            dfsVisit(x.getLeft());
            dfsVisit(x.getRight());
        }
    }

    // Θ(n)
    public void preOrder(Node<T> T) {
        if (T != null) {
            visit(T);
            preOrder(T.getLeft());
            preOrder(T.getRight());
        }
    }

    // Θ(n)
    public void inOrder(Node<T> T) {
        if (T != null) {
            inOrder(T.getLeft());
            visit(T);
            inOrder(T.getRight());
        }
    }

    public void inorderASCII(Node<T> T) {
        if (T != null) {
            inorderASCII(T.getLeft());
            visitASCII(T);
            inorderASCII(T.getRight());
        }
    }

    public void dfs() {
        dfsVisit(root);
    }

    private void dfsVisit(Node<T> node) {
        if (node == null)
            return;
        visit(node); // Pre-order: visit node first
        dfsVisit(node.getLeft());
        dfsVisit(node.getRight());
    }

    // Optional: DFS with ASCII output for Huffman tree
    public void dfsASCII() {
        dfsVisitASCII(root);
    }

    private void dfsVisitASCII(Node<T> node) {
        if (node == null) {
            return;
        }
        visitASCII(node); // Pre-order: visit node first
        dfsVisitASCII(node.getLeft());
        dfsVisitASCII(node.getRight());
    }

    // Θ(n)
    public void BFS() {
        if (this.root == null)
            return;

        myQueue<Node<T>> Q = new myQueue<>(10);
        Q.enqueue(this.root);
        while (Q.getSize() != 0) {
            Node<T> x = Q.dequeue();
            visit(x);
            if (x.getLeft() != null)
                Q.enqueue(x.getLeft());
            if (x.getRight() != null)
                Q.enqueue(x.getRight());
        }
    }

    // Θ(n)
    public int countnodes(Node<T> T) {
        if (T == null)
            return 0;
        else
            return 1 + countnodes(T.getLeft()) + countnodes(T.getRight());
    }

    public void updateheight(Node<T> T) {
        if (T == null)
            return;

        int leftHeight = (T.getLeft() == null) ? -1 : T.getLeft().getHeight();
        int rightHeight = (T.getRight() == null) ? -1 : T.getRight().getHeight();
        T.setHeight(1 + Math.max(leftHeight, rightHeight));
    }

    public void fillTree(Node<T> T) {
        System.out.println();
        this.root = T;
        root.setLeft(new Node(2, 2));
        root.setRight(new Node(3, 3));
        root.getLeft().setLeft(new Node(4, 4));
        root.getLeft().setRight(new Node(5, 5));
        root.getRight().setRight(new Node(6, 6));
        preOrder(root);
        System.out.println();
    }

    public void insertAtFirstNullLeaf(Node<T> newNode) {
        if (newNode == null)
            return;

        if (this.root == null) {
            this.root = newNode;
            return;
        }

        myQueue<Node<T>> Q = new myQueue<>(10);
        Q.enqueue(this.root);

        while (Q.getSize() != 0) {
            Node<T> current = Q.dequeue();

            if (current.getLeft() == null) {
                current.setLeft(newNode);
                newNode.setParent(current);
                updateheight(newNode);
                updateheight(current);
                return;
            } else
                Q.enqueue(current.getLeft());

            if (current.getRight() == null) {
                current.setRight(newNode);
                newNode.setParent(current);
                updateheight(newNode);
                updateheight(current);
                return;
            } else
                Q.enqueue(current.getRight());
        }
    }

    public int height(Node<T> node) {
        if (node == null)
            return -1;
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    public void printTree(Node<T> root) {
        System.out.println();
        inOrder(root);
        System.out.println();
    }

    public void printTree() {
        System.out.println();
        inOrder(this.root);
        System.out.println();
    }

    public void printASCIITree() {
        System.out.println();
        inorderASCII(this.root);
        System.out.println();
    }

    public Node<T> getRoot() {
        return root;
    }
}
