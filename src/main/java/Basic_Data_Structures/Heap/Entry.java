package Basic_Data_Structures.Heap;

public class Entry {
    private int key, element, index;
    private boolean tombstone;

    public Entry(int key, int element, int index, boolean tombstone) {
        this.key = key;
        this.element = element;
        this.index = index;
        this.tombstone = tombstone;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isTombstone() {
        return tombstone;
    }

    public void setTombstone(boolean tombstone) {
        this.tombstone = tombstone;
    }
}