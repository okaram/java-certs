package com.okaram.samples.ds;

public class AVLTree {
    public static class Node {
        int value;
        Node left, right;
        int height;

        public Node(int value, Node left, Node right, int height) {
            this.value = value;
            this.left = left;
            this.right = right;
            this.height = height;
        }

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
            this.height = 1;
        }

        public boolean isLeaf(){
            return left==null && right==null;
        }


        public String toString(){
            return Integer.toString(value) + "(h=" + height + ")";
        }
    }

    Node root = null;

    public Node getRoot(){
        return root;
    }

    int height(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    Node rightRotate(Node node) {
        Node leftChild = node.left;
        Node temp = leftChild.right;

        // Perform rotation
        leftChild.right = node;
        node.left = temp;

        // Update heights
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        leftChild.height = Math.max(height(leftChild.left), height(leftChild.right)) + 1;

        // Return new root
        return leftChild;
    }

    Node leftRotate(Node node) {
        Node rightChild = node.right;
        Node temp = rightChild.left;

        // Perform rotation
        rightChild.left = node;
        node.right = temp;

        // Update heights
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        rightChild.height = Math.max(height(rightChild.left), height(rightChild.right)) + 1;

        // Return new root
        return rightChild;
    }

    int getBalance(Node node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }


    Node insert(Node root, int value) {
        if (root == null)
            return new Node(value);

        if (value < root.value)
            root.left = insert(root.left, value);
        else if (value > root.value)
            root.right = insert(root.right, value);
        else
            return root;

        // Update height of root
        root.height = 1 + Math.max(height(root.left), height(root.right));

        // Get balance factor
        int balance = getBalance(root);

        // Left Left Case
        if (balance > 1 && value < root.left.value)
            return rightRotate(root);

        // Right Right Case
        if (balance < -1 && value > root.right.value)
            return leftRotate(root);

        // Left Right Case
        if (balance > 1 && value > root.left.value) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Left Case
        if (balance < -1 && value < root.right.value) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }
    public void insert(int value) {
        root = insert(root, value);
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
