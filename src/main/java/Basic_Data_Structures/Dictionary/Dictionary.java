package Basic_Data_Structures.Dictionary;

public class Dictionary<Key extends Comparable<Key>, V> {
    private static class Entry<K, V> {
        K k;
        V data;

        Entry(K k, V data) {
            this.k = k;
            this.data = data;
        }
    }

    private Entry<Key, V>[] arr;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public Dictionary() {
        arr = (Entry<Key, V>[]) new Entry[INITIAL_CAPACITY];
        size = 0;
    }

    public void fillDictionary(Key[] keys, V[] values) {
        if (keys.length != values.length)
            throw new IllegalArgumentException("Keys and values arrays must have the same length.");
        for (int i = 0; i < keys.length; i++)
            insert(keys[i], values[i]);
    }

    public void printDictionary() {
        System.out.print("Dictionary: ");
        for (int i = 0; i < size; i++)
            System.out.print("Key: " + arr[i].k + ", data: " + arr[i].data + ".    ");
        System.out.println();
    }

    // Θ(log n)
    public V search(Key k) {
        int i = binSearch(k);
        if (i != -1)
            return arr[i].data;
        return null;
    }

    // Θ(n)
    private int linSearch(Key k) {
        for (int i = 0; i < size; i++)
            if (arr[i].k.equals(k))
                return i;
        return -1;
    }

    // Θ(log n)
    public int binSearch(Key k) {
        int low = 0, high = this.size;

        while (low < high) {
            int mid = (low+high)/2;

            int comparison = arr[mid].k.compareTo(k);
            if (comparison == 0)
                return mid;
            else if (comparison < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    // Θ(n)
    public void insert(Key k, V data) {
        if (size >= arr.length) {
            throw new IllegalStateException("Array capacity exceeded");
        }

        int i = binSearch(k);

        if (i >= size || !arr[i].k.equals(k)) {
            rightshift(i);
            size++;
            arr[i] = new Entry<>(k, data);
        }
    }

    // Θ(n)
    private void rightshift(int i) {
        for (int j = this.size; j >= i; j--)
            arr[j + 1] = arr[j];
    }

    // Θ(n)
    private void leftshift(int i) {
        for (int j = i; j < this.size; j++)
            arr[j] = arr[j + 1];
    }

    // Θ(n)
    public void delete(Key k) {
        int index = binSearch(k);

        if (index > 0 && index < size && arr[index].k.equals(k)) {
            arr[index].k = null;
            arr[index].data = null;
            leftshift(index);
            size--;
        }
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        Entry<Key, V>[] newArray = (Entry<Key, V>[]) new Entry[arr.length * 2];
        for (int i = 0; i < size; i++)
            newArray[i] = arr[i];
        arr = newArray;
    }
}