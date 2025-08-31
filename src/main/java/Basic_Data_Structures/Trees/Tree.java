package Basic_Data_Structures.Trees;

import Basic_Data_Structures.Lists.Node;
import Basic_Data_Structures.Queue.Queue;

public class Trees {
    Node root;

    public Trees() {
        this.root = null;
    }

    public void visit(Node T, String name){
        System.out.println("Visited nodo: " + name + ", data: " + T.data);
    }

    // Θ(n)
    public void preorder(Node T){
        if (T != null){
            visit(T, "T");
            preorder(T.left);
            preorder(T.right);
        }
    }

    // Θ(n)
    public void inorder(Node T){
        if (T != null){
            inorder(T.left);
            visit(T, "T");
            inorder(T.right);
        }
    }

    public void BFS(Tree T){
        Queue Q = new Queue(1);
        if (T.root)
    }
}
