package Basic_Data_Structures.Heap;

import Basic_Data_Structures.Lists.Node;

public class PriorityQueue<T> extends Heap<T> {
    int d;

    public PriorityQueue(int heapsize, int d) {
        super(heapsize + 1); // 1-based logic
        this.d = d;
    }

    public Node<T> fistSon(Node<T> v) {
        return this.S[((v.getIndex() - 1) * this.d) + 2];
    }

    public Node<T> minSon(Node<T> v) {
        int fistChild = ((v.getIndex() - 1) * this.d) + 2;
        if (fistChild > heapsize)
            return null;
        int minIdx = fistChild;
        int lastChild = Math.min(v.getIndex() * this.d + 1, heapsize);
        for (int j = fistChild + 1; j <= lastChild; j++)
            if (S[j].getKey() < S[minIdx].getKey())
                minIdx = j;
        return S[minIdx];
    }

    public Node<T> maxSon(Node<T> v) {
        int lastChild = Math.min(v.getIndex() * this.d + 1, heapsize);
        if (lastChild < ((v.getIndex() - 1) * this.d) + 2)
            return null;
        return S[lastChild];
    }

    public Node<T> lastSon(Node<T> v) {
        return this.S[(v.getIndex() * this.d) + 1];
    }

    public Node<T> getChild(Node<T> v, int j) {
        int childIdx = ((v.getIndex() - 1) * d + 2 + j);
        return (childIdx <= heapsize) ? this.S[childIdx] : null;
    }

    public Node<T> father(Node<T> v) {
        if (v.getIndex() <= 1)
            return null;
        return S[(int) Math.ceil((v.getIndex() - 1) / (double) d)];
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
        while (v.getIndex() > 1 && f != null && v.getKey() < f.getKey()) {
            swap(v, f);
            f = father(v);
        }
    }

    public void moveDown(Node<T> v) {
        Node<T> min = minSon(v);
        while (min != null && v.getKey() > min.getKey()) {
            swap(v, min);
            min = minSon(v);
        }
    }

    public Node<T> findMin() {
        if (heapsize == 0)
            return null;
        return S[1];
    }

    public void fixHeap(Node<T>[] S, int c, int i) {
        if (2 * i > c) return; // No children
        int max = 2 * i; // Left child
        if (2 * i + 1 <= c && S[2 * i].getKey() < S[2 * i + 1].getKey()) {
            max = 2 * i + 1; // Right child is smaller
        }
        if (S[i].getKey() > S[max].getKey()) {
            Node<T> temp = S[max];
            S[max] = S[i];
            S[i] = temp;
            fixHeap(S, c, max);
        }
    }

    public void insert(int k, T e) {
        heapsize++;
        Node<T> newNode = new Node<>(e, k, heapsize, false);
        this.S[heapsize] = newNode;
        moveUp(newNode);
    }

    public void delete(T e) {
        for (Node<T> node : this.S)
            if (node != null && node.getData() != null && node.getData().equals(e))
                node.setTombstone(true);
    }

    public void increaseKey(int k, T e) {
        Node<T> targetNode = null;
        for (int i = 0; i < this.S.length; i++)
            if (this.S[i] != null && this.S[i].getData() != null && this.S[i].getData().equals(e) && k > this.S[i].getKey()) {
                this.S[i].setKey(k);
                targetNode = this.S[i];
            }
        if (targetNode != null)
            moveDown(targetNode);
    }

    public void decreaseKey(int k, T e) {
        Node<T> targetNode = null;
        for (int i = 0; i < this.S.length; i++)
            if (this.S[i] != null && this.S[i].getData() != null && this.S[i].getData().equals(e) && k < this.S[i].getKey()) {
                this.S[i].setKey(k);
                targetNode = this.S[i];
            }
        if (targetNode != null)
            moveUp(targetNode);
    }

    public void deleteMin() {
        if (heapsize == 0) return;
        this.S[1] = this.S[heapsize];
        this.S[heapsize] = null;
        heapsize--;
        if (heapsize > 0) {
            this.S[1].setIndex(1);
            moveDown(this.S[1]);
        }
    }
}