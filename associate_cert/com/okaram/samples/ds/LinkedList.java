package com.okaram.samples.ds;

public class LinkedList {
    static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value=value;
            this.next=next;
        }
        public Node(int value) {
            this.value=value;
            this.next=null;
        }
    };

    Node head=null;

    // adds at the *beginning* of the list
    void push(int value){
        head=new Node(value,head);
    }

    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("[ ");
        // could we convert this into a for loop?
        Node current=head;
        while(current!=null){
            sb.append(current.value);
            sb.append(", ");
            current=current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
