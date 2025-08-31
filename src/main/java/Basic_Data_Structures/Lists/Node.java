package Basic_Data_Structures.Lists;

public class Node {
    public int data;
    public Node next, left, right , parent;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}

