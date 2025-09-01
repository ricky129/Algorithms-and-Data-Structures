package Basic_Data_Structures.Lists;

public class Node {
    public int data;
    public Node next, left, right , parent;
    public int height, balanceFactor;;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.height = -1;
        this.balanceFactor = -1;
    }

    public void setBalanceFactor() {
        this.balanceFactor = (this.left == null ? -1 : this.left.height) - (this.right == null ? -1 : this.right.height);
    }
}

