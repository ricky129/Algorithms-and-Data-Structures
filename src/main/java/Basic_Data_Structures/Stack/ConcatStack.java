package Basic_Data_Structures.Stack;

import Basic_Data_Structures.Lists.LinkedList;
import Basic_Data_Structures.Lists.Node;

public class ConcatStack<T> {
    private LinkedList<T> stack;

    public ConcatStack(){
        this.stack = new LinkedList<>();
    }

    // O(1)
    public void push(T d, int k){
        this.stack.llinsert(k, d);
    }

    // O(n)
    public Node<T> pop(){
        if (this.stack != null) {
            Node<T> popped = this.stack.head;
            this.stack.lldelete(popped.getData());
            return popped;
        }
        return null;
    }

    public T peek(){
        if (this.stack.head != null)
            return this.stack.head.getData();
        return null;
    }

    public boolean isEmpty(){
        return this.stack.head == null;
    }

}
