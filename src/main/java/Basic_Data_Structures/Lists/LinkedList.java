package Basic_Data_Structures.Lists;

public class LinkedList {
    public Node head;
    public Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insert(int d) {
        Node tmp = new Node(d);

        if (this.head == null) {
            this.head = this.tail = tmp;
        } else {
            tmp.next = this.head;
            this.head = tmp;
        }
    }

    public void append(int d) {
        Node tmp = new Node(d);

        if (this.head == null) {
            this.head = this.tail = tmp;
        } else {
            this.tail.next = tmp;
            this.tail = tmp;
        }
    }

    public void delete(int d) {
        Node prev = null;
        Node curr = this.head;

        while (curr != null && d != curr.data) {
            prev = curr;
            curr = curr.next;
        }

        if (curr != null) {
            if (curr == this.head) {
                this.head = curr.next;
            } else {
                prev.next = curr.next;
            }
            if (curr == this.tail) {
                this.tail = prev;
            }
        }
    }

    public void remove(int d) {
        this.head = remove(this.head, d);
        if (this.head == null) {
            this.tail = null;
        }
    }

    private Node remove(Node head, int d) {
        if (head == null) {
            return null;
        }
        if (head.data == d) {
            return remove(head.next, d);
        } else {
            head.next = remove(head.next, d);
            return head;
        }
    }
}