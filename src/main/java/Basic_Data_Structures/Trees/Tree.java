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
            System.out.println("Visited node: " + T.data);
    }

    // Θ(n)
    public void preorder(Node T) {
        if (T != null) {
            visit(T);
            preorder(T.left);
            preorder(T.right);
        }
    }

    // Θ(n)
    public void inorder(Node T) {
        if (T != null) {
            inorder(T.left);
            visit(T);
            inorder(T.right);
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
                if (x.left != null)
                    Q.enqueue(x.left);
                else if (x.right != null)
                    Q.enqueue(x.right);
        }
    }

    // Θ(n)
    public static int countnodes(Node T) {
        if (T == null)
            return 0;
        else
            return 1 + countnodes(T.left) + countnodes(T.right);
    }

    public void updateheight(Node T) {
        if (T == null)
            return;

        int leftHeight = (T.left == null) ? -1 : T.left.height;
        int rightHeight = (T.right == null) ? -1 : T.right.height;
        T.height = 1 + Math.max(leftHeight, rightHeight);
    }

    public void fillTree() {
        this.root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
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

            if (current.left == null) {
                current.left = newNode;
                newNode.parent = current;
                updateheight(newNode);
                updateheight(current);
                return;
            } else
                Q.enqueue(current.left);

            if (current.right == null) {
                current.right = newNode;
                newNode.parent = current;
                updateheight(newNode);
                updateheight(current);
                return;
            } else
                Q.enqueue(current.right);
        }
    }

    public int height(Node node) {
        if (node == null)
            return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
