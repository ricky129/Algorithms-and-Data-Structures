package Basic_Data_Structures.Trees;

import Basic_Data_Structures.Lists.Node;

public class BinarySearchTree<T> extends Tree {

    // O(h)
    public Node<T> search(int k) {
        Node<T> tmp = this.root;
        while (tmp != null) {
            if (k == tmp.getKey())
                return tmp;
            else if (k < tmp.getKey())
                tmp = tmp.getLeft();
            else
                tmp = tmp.getRight();
        }
        return null;
    }

    // O(h)
    public void swap(Node<T> v, Node<T> u) {
        if (v != null && u != null) {
            T temp = v.getData();
            v.setData(u.getData());
            u.setData(temp);
        }
    }

    // O(h)
    public Node<T> bstInsert(int key, T data) {
        Node<T> newNode = new Node<>(key, data);
        Node<T> prev = null;
        Node<T> curr = this.root;

        while (curr != null) {
            prev = curr;
            if (key == curr.getKey()) {
                System.out.println("Key: " + key + " already exists. Insertion failed.");
                return curr;
            }
            if (key < curr.getKey())
                curr = curr.getLeft();
            else
                curr = curr.getRight();
        }

        if (prev == null)
            this.root = newNode;
        else {
            newNode.setParent(prev);
            if (key < prev.getKey())
                prev.setLeft(newNode);
            else
                prev.setRight(newNode);
        }
        return newNode;
    }

    // O(h)
    public Node<T> max(Node<T> T) {
        while (T != null && T.getRight() != null)
            T = T.getRight();
        return T;
    }

    // O(h)
    public Node<T> min(Node<T> T) {
        while (T != null && T.getLeft() != null)
            T = T.getLeft();
        return T;
    }

    // O(h)
    public Node<T> predecessor(Node<T> T) {
        if (T == null)
            return null;
        if (T.getLeft() != null)
            return max(T.getLeft());
        Node<T> P = T.getParent();
        while (P != null && T == P.getLeft()) {
            T = P;
            P = P.getParent();
        }
        return P;
    }

    // O(h)
    public Node<T> bstDelete(int k) {
        Node<T> v = search(k);
        if (v != null && v.getLeft() != null && v.getRight() != null) {
            Node<T> u = predecessor(v);
            swap(v, u);
            v = u;
        }
        disconnect(v);
        return v;
    }

    // O(1)
    public void disconnect(Node<T> v) {
        if (v == null)
            return;
        Node<T> p = v.getParent(), c;
        if (v.getRight() == null)
            c = v.getLeft();
        else
            c = v.getRight();
        if (p == null)
            root = c;
        else if (p.getLeft() == v)
            p.setLeft(c);
        else
            p.setRight(c);
        if (c != null)
            c.setParent(p);
    }

    public void fillTree() {
        this.root = new Node<T>(4, (T) Integer.valueOf(4));
        Integer[] values = {2, 6, 1, 3, 5};
        for (Integer value : values)
            bstInsert(value, (T) value);
    }
}