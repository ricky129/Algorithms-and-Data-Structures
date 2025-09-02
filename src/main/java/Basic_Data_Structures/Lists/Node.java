package Basic_Data_Structures.Lists;

public class Node {
    private int key, data, height, balanceFactor;
    private Node next, left, right , parent;
    private boolean tombstone;

    public Node(int data, int key) {
        this.data = data;
        this.key = key;
        this.next = null;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.height = 0;
        this.balanceFactor = -1;
        this.tombstone = false;
    }

    public void setBalanceFactor() {
        this.balanceFactor = (this.left == null ? -1 : this.left.height) - (this.right == null ? -1 : this.right.height);
    }

    public int getBalanceFactor() {
        return balanceFactor;
    }

    public void setBalanceFactor(int balanceFactor) {
        this.balanceFactor = balanceFactor;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isTombstone() {
        return tombstone;
    }

    public void setTombstone(boolean tombstone) {
        this.tombstone = tombstone;
    }
}

