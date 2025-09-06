package Basic_Data_Structures.Stack;

import java.util.logging.Logger;

public class StaticStack {
    private int[] stack;
    private int top;
    private static final Logger LOGGER = Logger.getLogger(StaticStack.class.getName());

    public StaticStack(int size) {
        if (size <= 0)
            throw new IllegalArgumentException("Stack size must be positive");
        this.stack = new int[size];
        this.top = 0; // 1-based logic
    }

    // Θ(1)
    public void push(int x){
        if (this.top == this.stack.length - 1)
            System.out.println("Error: Stack Overflow");
        else {
            this.top++;
            this.stack[this.top] = x;
        }
    }

    // Θ(1)
    public int pop(){
        int e;
        if (this.top == 0) {
            LOGGER.severe("Error: Stack Underflow");
            System.err.flush();
        }
        else {
            e = this.stack[this.top];
            this.top--;
            return e;
        }
        return -1;
    }

    public void fillStack(Integer[] values){
        for (Integer value : values)
            push(value);
    }
    public void fillStack(){
        for (int i = 1; i < this.stack.length; i++)
            this.push(i);
    }

    public void printStack(){
        System.out.print("StaticStack: ");
        for (int i = 1; i < this.stack.length; i++)
            System.out.print(this.stack[i]+  " ");
        System.out.println();
    }
}
