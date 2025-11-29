package com.okaram.samples.ds;

import javax.naming.NoPermissionException;

public class BinaryTree {
    public class Node {
        int value;
        Node left;
        Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

    }

    Node root = null;

    public static BinaryTree makeTree(){
        BinaryTree tree = new BinaryTree();
        tree.root = tree.new Node(1);
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(3);
        tree.root.left.left = tree.new Node(4);
        tree.root.left.right = tree.new Node(5);
        return tree;
    }

    public static BinaryTree makeBSTree(){
        BinaryTree tree = new BinaryTree();
        tree.root = tree.new Node(50);
        tree.root.left = tree.new Node(25);
        tree.root.right = tree.new Node(75);
        tree.root.left.left = tree.new Node(10);
        tree.root.left.right = tree.new Node(35);
        return tree;
    }

    public Node getRoot(){
        return root;
    }

    private void buildString(Node node, StringBuilder sb, int depth) {
        if (node == null) {
            sb.append("  ".repeat(depth)).append("null\n");
            return;
        }
        sb.append("  ".repeat(depth)).append(node.value).append("\n");
        buildString(node.left, sb, depth + 1);
        buildString(node.right, sb, depth + 1);
    } 

    public String toString() {
        StringBuilder sb = new StringBuilder("\n");
        buildString(root, sb, 0);
        return sb.toString();
    }
}
