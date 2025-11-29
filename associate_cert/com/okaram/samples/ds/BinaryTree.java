package com.okaram.samples.ds;

public class BinaryTree {
    public static class Value{
        enum ValueType { INT, CHAR };
        int iValue;
        char cValue;
        ValueType type;
        public Value(int value){
            this.iValue=value;
            this.type = ValueType.INT;
        }
        public Value(char value){
            this.cValue=value;
            this.type = ValueType.CHAR;
        }

        public String toString(){
            if (type==ValueType.INT)
                return Integer.toString(iValue);
            else 
                return Character.toString(cValue);
        }
    }
    public static class Node {
        Value value;
        Node left;
        Node right;

        public Node(Value value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(Value value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    Node root = null;

    public static BinaryTree makeTree(){
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(new Value(1));
        tree.root.left = new Node(new Value(2));
        tree.root.right = new Node(new Value(3));
        tree.root.left.left = new Node(new Value(4));
        tree.root.left.right = new Node(new Value(5))  ;
        return tree;
    }

    public static BinaryTree makeBSTree(){
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(new Value(50));
        tree.root.left = new Node(new Value(25));
        tree.root.right = new Node(new Value(75));
        tree.root.left.left = new Node(new Value(10));
        tree.root.left.right = new Node(new Value(35));
        return tree;
    }

    public static BinaryTree makeExpressionTree(){
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(new Value('+'));
        tree.root.left = new Node(new Value('*'), new Node(new Value(5)), new Node(new Value(4)));
        tree.root.right = new Node(new Value('-'), new Node(new Value(100)), new Node(new Value(20)));
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

    private void inOrderString(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        inOrderString(node.left, sb);
        sb.append(node.value).append(" ");
        inOrderString(node.right, sb);
    }
    public String inOrderString() {
        StringBuilder sb = new StringBuilder();
        inOrderString(root, sb);
        return sb.toString();
    }
}
