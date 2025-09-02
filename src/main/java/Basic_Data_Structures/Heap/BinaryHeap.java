package Basic_Data_Structures.Heap;

import Basic_Data_Structures.Trees.BinarySearchTree;

public class BinaryHeap extends BinarySearchTree {
    int S[];
    
    public void fixHeap(int c, int i){
        if (2*i == c)
            return;
        
        int max = 2*i;
        if (2*i+1 <= c && this.S[2] < this.S[3]) {
            max = 2*i+1;
            if (this.S[i] < this.S[max]) {
                int temp = this.S[max];
                this.S[max] = this.S[i];
                this.S[i] = temp;
                fixHeap(c, max);
            }
        }
    }

    public void deleteMax(){
        remove(S[1]);
        S[1] = S[heapsize]:
        remove (S[heapsize]);
        fixHeap(heapsize, 1);
    }
}
