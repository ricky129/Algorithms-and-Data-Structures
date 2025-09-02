package Basic_Data_Structures.Lists;

public class LinkedList {
    public Node head;
    public Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    // O(1)
    public void llinsert(int k, int d) {
        Node tmp = new Node(k, d);

        if (this.head == null)
            this.head = this.tail = tmp;
        else {
            tmp.setNext(this.head);
            this.head = tmp;
        }
    }

    // O(1)
    public void append(int k, int d) {
        Node tmp = new Node(k, d);

        if (this.head == null) {
            this.head = this.tail = tmp;
        } else {
            this.tail.setNext(tmp);
            this.tail = tmp;
        }
    }

    // O(n)
    public void lldelete(int d) {
        Node prev = null;
        Node curr = this.head;

        while (curr != null && d != curr.getData()) {
            prev = curr;
            curr = curr.getNext();
        }

        if (curr != null) {
            if (curr == this.head)
                this.head = curr.getNext();
            else
                prev.setNext(curr.getNext());
            if (curr == this.tail)
                this.tail = prev;
        }
    }

    // O(n)
    private Node remove(Node head, int d) {
        if (head == null)
            return null;
        if (head.getData() == d)
            return remove(head.getNext(), d);
         else {
            head.setNext(remove(head.getNext(), d));
            return head;
        }
    }

    // O(n)
    public Node llsearch(int d) {
        Node tmp = head;
        while (tmp != null) {
            if (tmp.getData() == d)
                return tmp;
            tmp = tmp.getNext();
        }
        return null;
    }

    // O(n)
    public boolean search(int d) {
        return llsearch(d) != null;
    }
}