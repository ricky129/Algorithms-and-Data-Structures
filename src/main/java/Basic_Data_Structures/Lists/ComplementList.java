package Basic_Data_Structures.Lists;

public class ComplementList<T extends Comparable<T>> {
    int length;

    public static void printArray (int[] A, String name) {
        System.out.print("Array " + name + ": ");
        for (int j : A) System.out.print(j + " ");
        System.out.println();
    }

    public int[] removeA1fromA2(int[] A1, int[] A2) {
        printArray(A1, "A1");
        printArray(A2, "A2");

        length = A1.length;
        removeA1fromA2Recursive(A1, A2, 0, 0);
        return cleanRecursive(A1, new int[length], 0, 0);
    }

    private void removeA1fromA2Recursive(int[] A1, int[] A2, int i, int j) {
        if (i >= A1.length)
            return;
        if (j < A2.length) {
            if (A2[j] == A1[i]) {
                A1[i] = -1;
                length--;
            }
            removeA1fromA2Recursive(A1, A2, i, j + 1);
        } else
            removeA1fromA2Recursive(A1, A2, i + 1, 0);
    }

    private int[] cleanRecursive(int[] arr, int[] ret, int i, int j) {
        if (i >= ret.length || j >= arr.length)
            return ret;
        if (arr[j] != -1) {
            ret[i] = arr[j];
            return cleanRecursive(arr, ret, i + 1, j + 1);
        }
        return cleanRecursive(arr, ret, i, j + 1);
    }

    private void printList(Node<T> head, String name) {
        Node<T> current = head;
        System.out.print("List " + name + ": ");
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    public void sortedComplementInit (LinkedList<T> L1, LinkedList<T> L2) {
        printList(L1.head, "L1");
        printList(L2.head, "L2");

        Node<T> result = sortedComplement(L1.head, L2.head);
        printList(result, "result");

        L1.head = result;
        if (result == null)
            L1.tail = null;
        else {
            Node<T> current = result;
            while (current.getNext() != null)
                current = current.getNext();
            L1.tail = current;
        }

        System.out.println("Tail of L1 after complement: " + (L1.tail != null ? L1.tail.getData() : "null"));
    }

    // Θ(L1.length + L2.length)
    private Node<T> sortedComplement(Node<T> L1, Node<T> L2) {
        if (L1 == null || L2 == null)
            return null;

        int cmp = L1.getData().compareTo(L2.getData());

        if (cmp > 0)
            return sortedComplement(L1, L2.getNext());
        else if (cmp < 0) {
            L1.setNext(sortedComplement(L1.getNext(), L2));
            return L1;
        } else
            return sortedComplement(L1.getNext(), L2);
    }

}