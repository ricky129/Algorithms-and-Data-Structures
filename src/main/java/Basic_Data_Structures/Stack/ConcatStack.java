package Basic_Data_Structures.Stack;

import Basic_Data_Structures.Lists.LinkedList;

public class ConcatStack {
    private LinkedList stack;

    public ConcatStack(){
        this.stack = new LinkedList();
    }

    // O(1)
    public void push(int d){
        this.stack.insert(d);
    }

    // O(n)
    public Integer pop(){
        int d;
        if (this.stack != null) {
            d = this.stack.head.data;
            this.stack.delete(d);
            return d;
        }
        return null;
    }

    public Integer peek(){
        if (this.stack.head != null)
            return this.stack.head.data;
        return null;
    }

    public boolean isEmpty(){
        return this.stack.head == null;
    }

}
