package Basic_Data_Structures.Stack;

public class DynamicStack {
    private int[] stack;
    private int top, size, n;

    public DynamicStack(int size) {
        if (size <= 0)
            throw new IllegalArgumentException("Stack size must be positive");
        this.stack = new int[size];
        this.top = -1;
        this.size = size;
    }

    // Θ(n)
    public int pop() {
        int e;

        if (this.top == 0) {
            System.err.println("Error: Stack Underflow");
            return -1;
        } else {
            e = this.stack[this.top];
            this.top--;
            if (this.stack.length > 10 && this.top + 1 <= this.stack.length / 4) {
                System.out.println("Resizing the dynamic Stack to save space.");
                int newCapacity = this.stack.length / 2;
                int[] T = new int[newCapacity];
                System.arraycopy(this.stack, 0, T, 0, this.top + 1);
                this.stack = T;
                this.size = newCapacity;
            }
            return e;
        }
    }

    // Θ(n)
    public void push(int x) {
        int[] T;
        if (this.top == this.stack.length - 1) {
            System.out.println("Resizing the dynamic array to fit more elements.");
            this.size = this.stack.length * 2;
            T = new int[this.size];
            System.arraycopy(this.stack, 0, T, 0, this.stack.length);
            this.stack = T;
        }
        this.top++;
        this.stack[this.top] = x;
    }

    public void fillStack() {
        for (int i = 0; i < this.size; i++)
            push(i);
    }

    public void printStack() {
        System.out.print("DynamicStack:     ");
        for (int i = 0; i < this.size; i++)
            System.out.print(this.stack[i] + " ");
        System.out.println();
    }
}
