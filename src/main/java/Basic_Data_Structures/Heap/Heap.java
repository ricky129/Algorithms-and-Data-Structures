package Basic_Data_Structures.Heap;

import Basic_Data_Structures.Lists.Node;

public class Heap<T> {
    public Node<T>[] S;
    public int heapsize;

    @SuppressWarnings("unchecked")
    public Heap(int heapsize) {
        this.heapsize = heapsize;
        this.S = (Node<T>[]) new Node[heapsize];
    }
}