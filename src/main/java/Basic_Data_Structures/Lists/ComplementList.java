package Basic_Data_Structures.Lists;

public class ComplementList {
    int length;

    public static void printArray (int[] A, String name) {
        System.out.print("Array " + name + ": ");
        for (int i = 0; i < A.length; i++)
            System.out.print(A[i] + " ");
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

    private static void printList (Node head, String name) {
        Node current = head;
        System.out.print("List " + name + ": ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void sortedComplementInit (LinkedList L1, LinkedList L2) {
        printList(L1.head, "L1");
        printList(L2.head, "L2");

        Node result = sortedComplement(L1.head, L2.head);
        printList(result, "result");

        L1.head = result;
        if (result == null)
            L1.tail = null;
        else {
            Node current = result;
            while (current.next != null)
                current = current.next;
            L1.tail = current;
        }

        System.out.println("Tail of L1 after complement: " + (L1.tail != null ? L1.tail.data : "null"));
    }

    // Θ(L1.length + L2.length)
    private static Node sortedComplement (Node L1, Node L2) {
        if (L1 == null || L2 == null)
            return null;
        else if (L1.data > L2.data)
            return sortedComplement(L1, L2.next);
        else if (L1.data < L2.data) {
            L1.next = sortedComplement(L1.next, L2);
            return L1;
        } else
            return sortedComplement(L1.next, L2);
    }

}