package com.okaram.samples.ds;

public class RedBlackTree {
    static enum Color { RED, BLACK };
    static enum Direction { LEFT, RIGHT };
    public static class Node {
        int value;
        Node left, right, parent;
        Color color;

        public Node(int value, Color color, Node left, Node right, Node parent) {
            this.value = value;
            this.color = color;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        public Node(int value) {
            this.value = value;
            this.color = Color.RED;
            this.left = null;
            this.right = null;
            this.parent = null;
        }

        public boolean isLeaf(){
            return left==null && right==null;
        }

        public Direction directionFromParent(){
            if (parent == null)
                return null; // root node
            return this == parent.right ? Direction.RIGHT : Direction.LEFT;
        }

        public String toString(){
            return Integer.toString(value) + "(" + color.toString().charAt(0) + ")";
        }
    }

    Node root = null;

    public Node getRoot(){
        return root;
    }

    void leftRotate(Node x)
    {
        Node y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        }
        else if (x == x.parent.left) {
            x.parent.left = y;
        }
        else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    void rightRotate(Node y)
    {
        Node x = y.left;
        y.left = x.right;
        if (x.right != null) {
            x.right.parent = y;
        }
        x.parent = y.parent;
        if (y.parent == null) {
            root = x;
        }
        else if (y == y.parent.left) {
            y.parent.left = x;
        }
        else {
            y.parent.right = x;
        }
        x.right = y;
        y.parent = x;
    }

    void fixInsert(Node k)
    {
        while (k != root && k.parent.color == Color.RED) {
            if (k.parent == k.parent.parent.left) {
                Node u = k.parent.parent.right; // uncle
                if (u.color == Color.RED) {
                    k.parent.color = Color.BLACK;
                    u.color = Color.BLACK;
                    k.parent.parent.color = Color.RED;
                    k = k.parent.parent;
                }
                else {
                    if (k == k.parent.right) {
                        k = k.parent;
                        leftRotate(k);
                    }
                    k.parent.color = Color.BLACK;
                    k.parent.parent.color = Color.RED;
                    rightRotate(k.parent.parent);
                }
            }
            else {
                Node u = k.parent.parent.left; // uncle
                if (u.color == Color.RED) {
                    k.parent.color = Color.BLACK;
                    u.color = Color.BLACK;
                    k.parent.parent.color = Color.RED;
                    k = k.parent.parent;
                }
                else {
                    if (k == k.parent.left) {
                        k = k.parent;
                        rightRotate(k);
                }
                    k.parent.color = Color.BLACK;
                    k.parent.parent.color = Color.RED;
                    leftRotate(k.parent.parent);
                }
            }
        }
        root.color = Color.BLACK;
    }   

    public static RedBlackTree makeSampleTree(){
        RedBlackTree tree = new RedBlackTree();
        Node n10 = new Node(10, Color.BLACK, null, null, null);
        Node n20 = new Node(20, Color.RED, null, null, n10);
        Node n30 = new Node(30, Color.RED, null, null, n10);
        n10.left = n20;
        n10.right = n30;

        Node n5 = new Node(5, Color.BLACK, null, null, n20);
        Node n15 = new Node(15, Color.BLACK, null, null, n20);
        n20.left = n5;
        n20.right = n15;

        Node n25 = new Node(25, Color.BLACK, null, null, n30);
        Node n35 = new Node(35, Color.BLACK, null, null, n30);
        n30.left = n25;
        n30.right = n35;

        tree.root = n10;
        return tree;
    }

    static Node bstInsert(Node root, Node newNode) {
        if (root == null) {
            return newNode;
        }
        if (newNode.value < root.value) {
            root.left = bstInsert(root.left, newNode);
            root.left.parent = root;
        } else if (newNode.value > root.value) {
            root.right = bstInsert(root.right, newNode);
            root.right.parent = root;
        }
        return root;
    }

    void bstInsert(Node newNode) {
        root = bstInsert(root, newNode);
    }
    
    public void insert(int value) {
        Node newNode = new Node(value);
        root = bstInsert(root, newNode);
        fixInsert(newNode);
    }

    private void buildString(Node node, StringBuilder sb, int depth) {
        if (node == null) {
            sb.append("  ".repeat(depth)).append("null\n");
            return;
        }
        sb.append("  ".repeat(depth)).append(node.toString()).append("\n");
        buildString(node.left, sb, depth + 1);
        buildString(node.right, sb, depth + 1);
    } 

    public String toString() {
        StringBuilder sb = new StringBuilder("\n");
        buildString(root, sb, 0);
        return sb.toString();
    }

}
