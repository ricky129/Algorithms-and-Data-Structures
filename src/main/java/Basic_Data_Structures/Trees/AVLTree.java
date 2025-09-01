package Basic_Data_Structures.Trees;

import Basic_Data_Structures.Lists.Node;

public class AVLTree extends Tree {

    public void rightrotate(Node u) {
        if (u != null && u.left != null) {
            Node v = u.left;
            u.left = v.right;
            v.right = u;
            if (u.left != null)
                u.left.parent = u;
            v.parent = u.parent;
            if (u.parent == null)
                this.root = v;
            else if (u.parent.left == u)
                v.parent.left = v;
            else
                v.parent.right = v;
            u.parent = v;
            updateheight(u);
            updateheight(v);
        }
    }

    public void leftrotate(Node u) {
        if (u != null && u.right != null) {
            Node v = u.right;
            u.right = v.left;
            v.left = u;
            if (u.right != null)
                u.right.parent = u;
            v.parent = u.parent;
            if (u.parent == null)
                this.root = v;
            else if (u.parent.right == u)
                v.parent.right = v;
            else
                v.parent.left = v;
            u.parent = v;
            updateheight(u);
            updateheight(v);
        }
    }

    // O(1)
    public void balance(Node u) {
        int b = u.balanceFactor;
        if (b == 2) {
            if (u.left.balanceFactor == -1)
                leftrotate(u);
            rightrotate(u);
        } else if (b == -2) {
            if (u.right.balanceFactor == 1)
                rightrotate(u.right);
            leftrotate(u);
        }
    }

    public Node insert(int value) {
        BinarySearchTree BST1 = new BinarySearchTree();
        Node v = BST1.bstInsert(value);
        Node p = v.parent;

        while (p != null && Math.abs(p.balanceFactor) != 2) {
            updateheight(p);
            p = p.parent;
            if (p != null)
                balance(p);
        }
        return v;
    }

    public Node delete(int d) {
        BinarySearchTree BST1 = new BinarySearchTree();
        Node v = BST1.bstDelete(d);
        Node p = null;

        if (v != null)
            p = v.parent;
        while (p != null) {
            if (p.balanceFactor == 2)
                balance(p);
            else
                updateheight(p);
            p = p.parent;
        }
        return v;
    }

    public void createAVLTree(int valueToAdd) {
        root.data = valueToAdd;
        int[] values = {4, 2, 6, 1, 3, 5};
        for (int value : values)
            insert(value);
    }
}
