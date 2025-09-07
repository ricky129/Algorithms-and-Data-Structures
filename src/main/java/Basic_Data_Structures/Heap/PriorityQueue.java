package Basic_Data_Structures.Heap;

import Basic_Data_Structures.Lists.Node;

public class PriorityQueue<T> extends Heap<T> {
    int d;

    public PriorityQueue(int length, int d) {
        super(length);
        this.d = d;
    }

    public Node<T> firstSon(Node<T> v) {
        return this.S[((v.getIndex() - 1) * this.d) + 2];
    }

    public Node<T> minSon(Node<T> v) {
        int fistChild = ((v.getIndex() - 1) * this.d) + 2;
        if (fistChild > this.heapsize)
            return null;
        int minIdx = fistChild;
        int lastChild = Math.min(v.getIndex() * this.d + 1, this.heapsize);
        for (int j = fistChild + 1; j <= lastChild; j++)
            if (S[j].getKey() < S[minIdx].getKey())
                minIdx = j;
        return !S[minIdx].isTombstone() ? S[minIdx] : null;
    }

    public Node<T> maxSon(Node<T> v) {
        int lastChild = Math.min(v.getIndex() * this.d + 1, this.heapsize);
        if (lastChild < ((v.getIndex() - 1) * this.d) + 2 || S[lastChild].isTombstone())
            return null;
        return S[lastChild];
    }

    public Node<T> lastSon(Node<T> v) {
        return !this.S[(v.getIndex() * this.d) + 1].isTombstone() ? this.S[(v.getIndex() * this.d) + 1] : null;
    }

    public Node<T> getChild(Node<T> v, int j) {
        int childIdx = ((v.getIndex() - 1) * d + 2 + j);
        return (childIdx <= this.heapsize) && !this.S[childIdx].isTombstone() ? this.S[childIdx] : null;
    }

    public Node<T> father(Node<T> v) {
        if (v.getIndex() <= 1)
            return null;
        Node<T> father = this.S[(int) Math.ceil((v.getIndex() - 1) / (double) d)];
        if (father == null || father.isTombstone())
            return null;
        return father;
    }

    private void swap(Node<T> v, Node<T> f) {
        int idxV = v.getIndex();
        int idxF = f.getIndex();
        S[idxV] = f;
        S[idxF] = v;
        f.setIndex(idxV);
        v.setIndex(idxF);
    }

    public void moveUp(Node<T> v) {
        Node<T> f = father(v);
        if (f == null)
            return;
        System.out.println("father(v) = " + f.getData());
        while (v.getIndex() > 1 && v.getKey() < f.getKey() && !v.isTombstone()) {
            swap(v, f);
            f = father(v);
        }
    }

    public void moveDown(Node<T> v) {
        Node<T> min = minSon(v);
        while (min != null && v.getKey() > min.getKey() && !v.isTombstone()) {
            swap(v, min);
            min = minSon(v);
        }
    }

    public Node<T> findMin() {
        if (this.heapsize == 0)
            return null;
        return this.S[1] != null ? this.S[1] : null;
    }

    public void fixBinaryHeap(Node<T>[] S, int c, int i) {
        if (2 * i > c)
            return; // No children
        int max = 2 * i; // Left child
        if (2 * i + 1 <= c && S[2 * i].getKey() < S[2 * i + 1].getKey() && !S[2 * i].isTombstone() && !S[2 * i + 1].isTombstone())
            max = 2 * i + 1; // Right child is smaller
        if (S[i].getKey() > S[max].getKey() && !S[i].isTombstone()) {
            Node<T> temp = S[max];
            S[max] = S[i];
            S[i] = temp;
            fixBinaryHeap(S, c, max);
        }
    }

    public void resize() {
        if (this.heapsize >= this.S.length - 2) {
            System.out.println("Resizing the queue.");
            int newsize = this.S.length * 2;
            Node<T>[] T = new Node[newsize];
            System.arraycopy(this.S, 0, T, 0, this.S.length);
            this.S = T;
        }
    }

    public void insert(Node<T> node) {
        resize();
        this.heapsize++;
        this.S[this.heapsize] = node;
        node.setIndex(this.heapsize);
        moveUp(node);
    }

    public void insert(int k, T e) {
        this.heapsize++;
        System.out.println("heapsize: " + this.heapsize);
        resize();
        Node<T> newNode = new Node<>(e, k, this.heapsize, false);
        this.S[this.heapsize] = newNode;
        moveUp(newNode);
    }

    public void delete(T e) {
        for (Node<T> node : this.S)
            if (node != null && node.getData() != null && node.getData().equals(e) && !node.isTombstone())
                node.setTombstone(true);
    }

    public void increaseKey(int k, T e) {
        Node<T> targetNode = null;
        for (Node<T> tNode : this.S)
            if (tNode != null && tNode.getData() != null && tNode.getData().equals(e) && k > tNode.getKey() && !tNode.isTombstone()) {
                tNode.setKey(k);
                targetNode = tNode;
            }
        if (targetNode != null)
            moveDown(targetNode);
    }

    public void decreaseKey(int k, T e) {
        Node<T> targetNode = null;
        for (Node<T> tNode : this.S)
            if (tNode != null && tNode.getData() != null && tNode.getData().equals(e) && k < tNode.getKey() && !tNode.isTombstone()) {
                tNode.setKey(k);
                targetNode = tNode;
            }
        if (targetNode != null)
            moveUp(targetNode);
    }

    public void deleteMin() {
        if (this.S[1] == null || this.heapsize == 0 || this.S[1].isTombstone())
            return;
        this.S[1] = this.S[this.heapsize];
        this.S[this.heapsize] = null;
        this.heapsize--;
        if (this.heapsize > 0) {
            this.S[1].setIndex(1);
            moveDown(this.S[1]);
        }
    }
}