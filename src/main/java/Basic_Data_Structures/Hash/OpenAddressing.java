package Basic_Data_Structures.Hash;

import Basic_Data_Structures.Lists.Node;
import org.apache.commons.math3.primes.Primes;

public class OpenAddressing {
    private Node[] table;
    private int size;

    public OpenAddressing(Node[] table, int size) {
        this.size = size;
        this.table = new Node[size];
    }

    // O(prime)
    private int findClosestPrime(int prime) {
        while (!Primes.isPrime(prime) && prime > 0)
            prime--;
        return prime;
    }

    // O(1)
    private int hash1(int k) {
        return Math.abs(k) % this.size;
    }

    // O(1)
    private int hash2(int k) {
        /**
         * In a double hashing scheme, the second hash function, h2(k),
         * must be coprime with the table size to ensure the probe sequence
         * visits every slot in the table before repeating. This is achieved
         * by choosing the table size as a prime number and using a second
         * hash function of the form 1+(k(mod m')), where m is a smaller prime number.
         * h(k, i) = (h_1(k) + i * h_2(k)) mod m, with h_2(k) = 1 + (k mod m')
         */
        int prime = this.size - 1;
        if (Primes.isPrime(prime))
            return 1 + (Math.abs(k) % prime);
        else
            return 1 + (Math.abs(k) % findClosestPrime(prime));
    }

    // O(1)
    public int hash(int k, int i) {
        return (hash1(k) + i*hash2(k)) % this.size;
    }

    // O(size)
    public int search(int k) {
        int i = 0, j = 0;
        while (table[j] != null || i != this.size) {
            j = hash(k, i);
            if (table[j] == null)
                return -1;
            if (table[j].getKey() == k)
                return table[j].getData();
            i++;
        }
        return -1;
    }

    // O(size)
    public void insert(int k, int d) {
        int i = 0, j = 0;
        while (i != this.size) {
            j = hash(k, i);
            if (table[j] == null || table[j].isTombstone()) {
                table[j] = new Node(k, d);
                return;
            }
            i++;
        }
        System.err.println("Error: Overflow");
    }

    // O(size)
    public void delete(int k) {
        int i = 0, j = 0;
        while (table[j] != null || i == this.size) {
            j = hash(k, i);
            if (table[j].getKey() == k) {
                table[j].setTombstone(true);
                return;
            }
            i++;
        }
    }

}
