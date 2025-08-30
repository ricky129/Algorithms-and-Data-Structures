package Basic_Data_Structures.Queue;

public class Queue {
    private int size, head, tail, buf[];

    public Queue(int initialSize) {
        if (initialSize < 0)
            throw new IllegalArgumentException("Initial size must be positive");
        this.buf = new int[initialSize];
        this.size = 0;
        this.head = 0;
        this.tail = 0;
    }

    // Θ(1)
    public void enqueue(int x){
        if (this.size == this.buf.length) {
            System.err.println("Error: Queue Overflow");
            return;
        }
        this.buf[this.tail] = x;
        this.tail = (this.tail + 1 )%this.buf.length;
        this.size++;
    }

    // Θ(1)
    public int dequeue(){
        if (this.size == 0) {
            System.err.println("Error: Queue Underflow");
            return -1;
        }
        int x = this.buf[this.head];
        this.head = (this.head+ 1 )%this.buf.length;
        this.size--;
        return x;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }
}
