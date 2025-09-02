package Basic_Data_Structures.Hash;

import Basic_Data_Structures.Lists.LinkedList;
import Basic_Data_Structures.Lists.Node;

public class ConcatHash extends LinkedList {
    private LinkedList[] table;
    private int size;

    public ConcatHash(int size) {
        this.size = size;
        this.table = new LinkedList[size];
        for (int i = 0; i < size; i++)
            table[i] = new LinkedList();
    }

    // Θ(log k)
    public int hash(int k){
        int h = 0;
        int base = 10;
        // copy of the key k so that it can be manipulated
        // without changing its original value
        int tempK = k;

        if (tempK == 0)
            return 0;

        // until each digit of the key has been processed
        while (tempK > 0){
            // extracting the key's lsd
            int digit = tempK % base;
            /**
             * Horner's rule implementation: rearranging the polynomial into a factored
             * form that can be computed iteratively, making the process faster.
             * A generic polynomial of degree n is given by:
             * P(x) = aₙxⁿ + aₙ₋₁xⁿ⁻¹ + ... + a₁x + a₀
             * Horner's rule rewrites it in the following factored way:
             * P(x) = ( ... ( (aₙx + aₙ₋₁)x + aₙ₋₂)x + ... + a₁)x + a₀
             */
            h = (h * base + digit)%size;
            // removing the lsd from the key, preparing the loop for
            // the next digit's processing
            tempK /= base;
        }
        return h;
    }

    // O(L), L = length of the longest collision's list
    public int hashSearch(int k){
        Node tmp = table[hash(k)].llsearch(k);

        if (tmp != null)
            return tmp.getData();
        else
            return -1;
    }

    // O(L), L = length of the longest collision's list
    public void insert(int k, int d){
        LinkedList list = table[hash(k)];
        Node tmp = list.llsearch(k);

        if (tmp != null)
            tmp.setData(d);
        else
            list.llinsert(k, d);
    }

    // O(L), L = length of the longest collision's list
    public void delete(int k){
        table[hash(k)].lldelete(k);
    }
}
