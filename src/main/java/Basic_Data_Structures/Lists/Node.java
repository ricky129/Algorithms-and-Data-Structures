package Basic_Data_Structures.Lists;

public class Node<T> {
    private int key, index, height, balanceFactor;
    String code;
    private T data;
    private Node<T> next, left, right, parent;
    private boolean tombstone;

    public Node(int key, T data) {
        this(data, key, 0, false);
    }

    public Node(T data, int key, int index, boolean tombstone) {
        this.data = data;
        this.key = key;
        this.index = index;
        this.tombstone = tombstone;
        this.next = null;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.height = 0;
        this.balanceFactor = -1;
        this.code = null;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
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

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}