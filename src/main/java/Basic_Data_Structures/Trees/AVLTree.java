package Basic_Data_Structures.Trees;

import Basic_Data_Structures.Lists.Node;

public class AVLTree<T> extends BinarySearchTree<T> {

    public void rightRotate(Node<T> u) {
        if (u != null && u.getLeft() != null) {
            Node<T> v = u.getLeft();
            u.setLeft(v.getRight());
            v.setRight(u);
            if (u.getLeft() != null)
                u.getLeft().setParent(u);
            v.setParent(u.getParent());
            if (u.getParent() == null)
                this.root = v;
            else if (u.getParent().getLeft() == u)
                v.getParent().setLeft(v);
            else
                v.getParent().setRight(v);
            u.setParent(v);
            updateheight(u);
            updateheight(v);
            u.setBalanceFactor();
            v.setBalanceFactor();
        }
    }

    public void leftRotate(Node<T> u) {
        if (u != null && u.getRight() != null) {
            Node<T> v = u.getRight();
            u.setRight(v.getLeft());
            v.setLeft(u);
            if (u.getRight() != null)
                u.getRight().setParent(u);
            v.setParent(u.getParent());
            if (u.getParent() == null)
                this.root = v;
            else if (u.getParent().getRight() == u)
                v.getParent().setRight(v);
            else
                v.getParent().setLeft(v);
            u.setParent(v);
            updateheight(u);
            updateheight(v);
            u.setBalanceFactor();
            v.setBalanceFactor();
        }
    }

    // O(1)
    public void balance(Node<T> u) {
        int b;

        if (u == null)
            return;
        u.setBalanceFactor();
        b = u.getBalanceFactor();
        if (b == 2) {
            u.getLeft().setBalanceFactor();
            if (u.getLeft().getBalanceFactor() == -1)
                leftRotate(u);
            rightRotate(u);
        } else if (b == -2) {
            u.getRight().setBalanceFactor();
            if (u.getRight().getBalanceFactor() == 1)
                rightRotate(u.getRight());
            leftRotate(u);
        }
    }

    // Θ(log n)
    public void insert(int key, T data) {
        Node<T> v = bstInsert(key, data);
        Node<T> p = v.getParent();

        while (p != null && Math.abs(p.getBalanceFactor()) != 2) {
            updateheight(p);
            p.setBalanceFactor();
            p = p.getParent();
            if (p != null)
                balance(p);
        }
    }

    // Θ(log n)
    public Node<T> delete(int d) {
        Node<T> v = bstDelete(d);
        Node<T> p = null;

        if (v != null)
            p = v.getParent();
        while (p != null) {
            if (Math.abs(p.getBalanceFactor()) == 2)
                balance(p);
            else {
                updateheight(p);
                p.setBalanceFactor();
            }
            p = p.getParent();
        }
        return v;
    }

    public void createAVLTree(Node<T> initialRoot) {
        this.root = initialRoot;
        if (initialRoot != null) {
            updateheight(initialRoot);
            initialRoot.setBalanceFactor();
        }
        Integer[] values = {4, 2, 6, 1, 3, 5};
        for (Integer value : values)
            insert(value, (T)value);
    }

    // Θ(log n)
    public Node<T> search(Node<T> T) {
        BinarySearchTree<T> BST1 = new BinarySearchTree();
        return BST1.search(T.getKey());
    }
}
