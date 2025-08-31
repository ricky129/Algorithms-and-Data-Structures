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
    public void BFS(Tree T) {
        if (T.root == null)
            return;

        myQueue<Node> Q = new myQueue<>(10);
        Q.enqueue(T.root);
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
    public int countnodes(Node T) {
        if (T == null)
            return 0;
        else
            return 1 + countnodes(T.left) + countnodes(T.right);
    }

    public void fillTree(Node T) {
        root = T;
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        preorder(root);
    }
}
