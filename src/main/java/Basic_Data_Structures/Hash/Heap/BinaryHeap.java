package Basic_Data_Structures.Heap;

public class BinaryHeap<T> extends Heap<T> {
    int[] S;
    int heapsize;

    public BinaryHeap(int heapsize) {
        super(heapsize);
        this.S = new int[heapsize+1]; // 1-based logic
    }

    // Helper method to bubble up an element to restore heap property
    public void bubbleUp(int[] S, int i) {
        while (i > 1 && S[i / 2] < S[i]) { // While not at root and parent is smaller
            int temp = S[i];
            S[i] = S[i / 2];
            S[i / 2] = temp;
            i = i / 2; // Move to parent
        }
    }

    /**
     * restores heap order by moving the element that is in the wrong position down
     * until it is smaller than its parent and larger than its largest child (swap
     * with the larger of the 2 children)
     * @param S heap that needs fixing
     * @param c heap size
     * @param i current node
     */
    public void fixHeap(int[] S, int c, int i) {
        if (2 * i > c) return; // No children

        int max = 2 * i; // Left child
        if (2 * i + 1 <= c && S[2 * i] < S[2 * i + 1]) {
            max = 2 * i + 1; // Right child is larger
        }
        if (S[i] < S[max]) {
            int temp = S[max];
            S[max] = S[i];
            S[i] = temp;
            fixHeap(S, c, max);
        }
    }

    public void remove(int[] S, int c, int toRemove) {
        if (c == 0)
            return; // empty heap

        // find the index of toRemove
        int index = -1;
        for (int i = 1; i <= c; i++) {
            if (S[i] == toRemove) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return; // element not found
        }

        // replace with last element
        S[index] = S[c];
        S[c] = 0;
        this.heapsize--;

        if (c == 0 || index > c) {
            return;
        }

        // Bubble up if necessary
        if (index != 1 && S[index] > S[index / 2]) {
            bubbleUp(S, index);
        }
    }

    public void deleteMax(int[] S, int c) {
        if (c == 0) return;

        // replace root with last element
        S[1] = S[c];
        S[c] = 0;
        this.heapsize--;

        if (c > 0) {
            fixHeap(S, this.heapsize, 1); // restore heap property
        }
    }

    public void heapify(int[] S, int n, int i) {
        if (i > n) return;
        heapify(S, n, 2 * i); // heapify left subtree
        heapify(S, n, 2 * i + 1); // heapify right subtree
        fixHeap(S, n, i); // fix heap at current node
    }

    public void heapsort(int[] A) {
        this.S = A; // temporarily set S to A
        this.heapsize = A.length - 1;

        // transform A into a max-heap
        heapify(A, A.length - 1, 1);

        // extract max and place at end
        for (int c = A.length - 1; c > 1; c--) {
            int k = A[1]; // maximum is at root
            deleteMax(A, c);
            A[c] = k; // place max at end
        }
    }

    public int[] getS() {
        return S;
    }

    public void setS(int[] s) {
        S = s;
    }

    public int getHeapsize() {
        return heapsize;
    }

    public void setHeapsize(int heapsize) {
        this.heapsize = heapsize;
    }
}