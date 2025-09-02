package Basic_Data_Structures.Trees;

import Basic_Data_Structures.Lists.Node;

public class AVLTree extends BinarySearchTree {

    public void rightRotate(Node u) {
        if (u != null && u.getLeft() != null) {
            Node v = u.getLeft();
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

    public void leftRotate(Node u) {
        if (u != null && u.getRight() != null) {
            Node v = u.getRight();
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
    public void balance(Node u) {
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
    public Node insert(int key, int data) {
        Node v = bstInsert(key, data);
        Node p = v.getParent();

        while (p != null && Math.abs(p.getBalanceFactor()) != 2) {
            updateheight(p);
            p.setBalanceFactor();
            p = p.getParent();
            if (p != null)
                balance(p);
        }
        return v;
    }

    // Θ(log n)
    public Node delete(int d) {
        Node v = bstDelete(d);
        Node p = null;

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

    public void createAVLTree(Node initialRoot) {
        this.root = initialRoot;
        if (initialRoot != null) {
            updateheight(initialRoot);
            initialRoot.setBalanceFactor();
        }
        int[] values = {4, 2, 6, 1, 3, 5};
        for (int value : values)
            insert(value, value);
    }

    // Θ(log n)
    public Node search(Node T) {
        BinarySearchTree BST1 = new BinarySearchTree();
        return BST1.search(T.getData());
    }
}
