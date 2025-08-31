package Basic_Data_Structures.Trees;

import Basic_Data_Structures.Lists.Node;

public class BinarySearchTree extends Tree {

    // O(h)
    public Node search(int k) {
        Node tmp = root;
        while (tmp != null) {
            if (k == tmp.data)
                return tmp;
            else if (k < tmp.data)
                tmp = tmp.left;
            else
                tmp = tmp.right;
        }
        return null;
    }

    // O(h)
    public void swap(Node v, Node u) {
        if (v != null && u != null) {
            int temp = v.data;
            v.data = u.data;
            u.data = temp;
        }
    }

    // O(h)
    public Node insert(int key) {
        Node newNode = new Node(key);
        Node prev = null;
        Node curr = root;

        while (curr != null) {
            prev = curr;
            if (key < curr.data)
                curr = curr.left;
            else
                curr = curr.right;
        }

        if (prev == null)
            root = newNode;
        else {
            newNode.parent = prev;
            if (key < prev.data)
                prev.left = newNode;
            else
                prev.right = newNode;
        }
        return newNode;
    }

    // O(h)
    public Node max(Node T) {
        while (T != null && T.right != null)
            T = T.right;
        return T;
    }

    // O(h)
    public Node min(Node T) {
        while (T != null && T.left != null)
            T = T.left;
        return T;
    }

    // O(h)
    public Node predecessor(Node T) {
        if (T == null)
            return null;
        if (T.left != null)
            return max(T.left);
        Node P = T.parent;
        while (P != null && T == P.left) {
            T = P;
            P = P.parent;
        }
        return P;
    }

    // O(h)
    public Node delete(int k) {
        Node v = search(k);
        if (v != null && v.left != null && v.right != null) {
            Node u = predecessor(v);
            swap(v, u);
            v = u;
        }
        disconnect(v);
        return v;
    }

    // O(1)
    public void disconnect(Node v) {
        if (v == null)
            return;
        Node p = v.parent, c;
        if (v.right == null)
            c = v.left;
        else
            c = v.right;
        if (p == null)
            root = c;
        else if (p.left == v)
            p.left = c;
        else
            p.right = c;
        if (c != null)
            c.parent = p;
    }

    @Override
    public void fillTree(Node T) {
        root = T;
        int[] values = {4, 2, 6, 1, 3, 5};
        for (int value : values)
            insert(value);
    }

    public void printTree() {
        inorder(root);
    }
}
