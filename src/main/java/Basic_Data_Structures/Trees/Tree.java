package Basic_Data_Structures.Trees;

import Basic_Data_Structures.Lists.Node;
import Basic_Data_Structures.Queue.myQueue;

public class Tree {
    Node root;

    public Tree() {
        this.root = null;
    }

    public void visit(Node T) {
        if (T != null)
            System.out.println("Visited node: " + T.getData());
    }

    // Θ(n)
    public void preorder(Node T) {
        if (T != null) {
            visit(T);
            preorder(T.getLeft());
            preorder(T.getRight());
        }
    }

    // Θ(n)
    public void inorder(Node T) {
        if (T != null) {
            inorder(T.getLeft());
            visit(T);
            inorder(T.getRight());
        }
    }

    // Θ(n)
    public void BFS() {
        if (this.root == null)
            return;

        myQueue<Node> Q = new myQueue<>(10);
        Q.enqueue(this.root);
            while (Q.getSize() != 0) {
                Node x = Q.dequeue();
                visit(x);
                if (x.getLeft() != null)
                    Q.enqueue(x.getLeft());
                if (x.getRight() != null)
                    Q.enqueue(x.getRight());
        }
    }

    // Θ(n)
    public static int countnodes(Node T) {
        if (T == null)
            return 0;
        else
            return 1 + countnodes(T.getLeft()) + countnodes(T.getRight());
    }

    public void updateheight(Node T) {
        if (T == null)
            return;

        int leftHeight = (T.getLeft() == null) ? -1 : T.getLeft().getHeight();
        int rightHeight = (T.getRight() == null) ? -1 : T.getRight().getHeight();
        T.setHeight(1 + Math.max(leftHeight, rightHeight));
    }

    public void fillTree() {
        this.root = new Node(1, 1);
        root.setLeft(new Node(2, 2));
        root.setRight(new Node(3, 3));
        root.getLeft().setLeft(new Node(4, 4));
        root.getLeft().setRight(new Node(5, 5));
        root.getRight().setRight(new Node(6, 6));
        preorder(root);
    }

    public void insertAtFirstNullLeaf(Node newNode) {
        if (newNode == null)
            return;

        if (this.root == null) {
            this.root = newNode;
            return;
        }

        myQueue<Node> Q = new myQueue<>(10);
        Q.enqueue(this.root);

        while(Q.getSize() != 0) {
            Node current = Q.dequeue();

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

    public int height(Node node) {
        if (node == null)
            return -1;
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    public void printTree() {
        inorder(root);
    }
}
