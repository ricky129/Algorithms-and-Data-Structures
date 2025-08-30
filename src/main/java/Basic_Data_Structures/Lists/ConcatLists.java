package Basic_Data_Structures.Lists;

public class ConcatLists {
    private Node search_node(LinkedList L, int d) {
        Node tmp = L.head;
        while (tmp != null) {
            if (tmp.data == d)
                return tmp;
            tmp = tmp.next;
        }
        return null;
    }

    public boolean search(LinkedList L, int d) {
        return search_node(L, d) != null;
    }

    public void insert(LinkedList L, int d) {
        Node tmp = null;
        tmp.data = d;
        if (L.head == null)
            L.head = L.tail = tmp;
    }
}
