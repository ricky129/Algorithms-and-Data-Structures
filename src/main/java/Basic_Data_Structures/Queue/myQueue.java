package Basic_Data_Structures.Queue;

public class myQueue<T> {
    private Object[] buf;
    private int size, head, tail, capacity;

    public myQueue(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("Initial size must be positive");
        this.buf = new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
        this.head = 0;
        this.tail = 0;
    }

    // Θ(1)
    public void enqueue(Object x){
        if (this.size == this.capacity) {
            System.err.println("Error: Queue Overflow");
            return;
        }
        this.buf[this.tail] = x;
        this.tail = (this.tail + 1)%this.capacity;
        this.size++;
    }

    // Θ(1)
    public T dequeue(){
        if (this.size == 0) {
            System.err.println("Error: Queue Underflow");
            return null;
        }
        T x = (T)this.buf[this.head];
        this.buf[this.head] = null;
        this.head = (this.head + 1)%this.capacity;
        this.size--;
        return x;
    }

    public void fillQueue(T[] elements){
        for (T element : elements) enqueue(element);
    }

    public void printQueue(){
        System.out.print("Queue:    ");
        if (size == 0) {
            System.out.println("Empty");
            return;
        }
        int index = head;
        for (int i = 0; i < size; i++) {
            System.out.print("Cell: " + this.buf[index] + " ");
            index = (index+1)%buf.length;
        }
        System.out.println();
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public Object[] getBuf() {
        return buf;
    }

    public void setBuf(Object[] buf) {
        this.buf = buf;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
