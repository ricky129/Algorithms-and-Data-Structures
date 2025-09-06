package Basic_Data_Structures.Lists;

public class LinkedList<T> {
    public Node<T> head;
    public Node<T> tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    // O(1)
    public void llinsert(int k, T d) {
        Node<T> tmp = new Node<>(k, d);

        if (this.head == null)
            this.head = this.tail = tmp;
        else {
            tmp.setNext(this.head);
            this.head = tmp;
        }
    }

    // O(1)
    public void append(int k, T d) {
        Node<T> tmp = new Node<>(k, d);

        if (this.head == null) {
            this.head = this.tail = tmp;
        } else {
            this.tail.setNext(tmp);
            this.tail = tmp;
        }
    }

    // O(n)
    public void lldelete(T d) {
        Node<T> prev = null;
        Node<T> curr = this.head;

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
    public void lldelete(int k) {
        Node<T> prev = null;
        Node<T> curr = this.head;

        while (curr != null && k != curr.getKey()) {
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
    private Node<T> remove(Node<T> head, T d) {
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
    public Node<T> llsearch(T d) {
        Node<T> tmp = head;
        while (tmp != null) {
            if (tmp.getData() == d)
                return tmp;
            tmp = tmp.getNext();
        }
        return null;
    }

    // O(n)
    public Node<T> llsearch(int k) {
        Node<T> tmp = head;
        while (tmp != null) {
            if (tmp.getKey() == k)
                return tmp;
            tmp = tmp.getNext();
        }
        return null;
    }

    // O(n)
    public boolean search(T d) {
        return llsearch(d) != null;
    }
}