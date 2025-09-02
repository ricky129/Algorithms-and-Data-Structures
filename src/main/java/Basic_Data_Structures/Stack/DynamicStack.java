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
        int[] T;

        if (this.top == 0) {
            System.err.println("Error: Stack Underflow");
            return -1;
        } else {
            e = this.stack[this.top];
            this.top--;
            if (this.top <= Math.floor((double) this.stack.length / 4)) {
                n = this.stack.length;
                T = new int[n / 2];
                for (int i = 1; i < n / 4; i++) {
                    T[i] = this.stack[i];
                    this.stack = T;
                    this.size = (int) (Math.ceil((double) n / 2));
                }
            }
            return e;
        }
    }

    // Θ(n)
    public void push(int x) {
        int[] T;
        if (this.top == this.stack.length - 1) {
            this.size = this.stack.length * 2;
            T = new int[this.size];
            for (int i = 0; i < this.stack.length; i++)
                T[i] = this.stack[i];
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
