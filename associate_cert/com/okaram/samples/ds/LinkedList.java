package com.okaram.samples.ds;

import java.security.InvalidParameterException;

public class LinkedList {
    private static class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value, Node next,Node prev) {
            this.value=value;
            this.next=next;
            this.prev=prev;
        }

        public Node(int value, Node next) {
            this.value=value;
            this.next=next;
            this.prev=null;
        }

        public Node(int value) {
            this.value=value;
            this.next=null;
            this.prev=null;
        }
    };

    Node head=null;
    Node last=null;

    // adds at the *beginning* of the list
    public void push(int value){
        head=new Node(value,head);
        if (head.next!=null)
            head.next.prev=head;
        else 
            last=head;
    }

    public void pop(){
        if (head==null)
            throw new InvalidParameterException("List is already empty");
        if (head.next==null) {
            head=null;
            last=null;
        }
        head.next.prev=null;
        head=head.next;
    }

    // remove from the end is an exercise
    
    // add at the end
    public void add(int value) {
        if (head==null)
            push(value);
        else {
            last.next=new Node(value,null,last);
            last=last.next;
        }
    }

    private int size( Node current ){
        if (current==null)
            return 0;
        return 1+size(current.next);
    }

    public int size() {
        return size(head);
        // int count=0;
        // for(Node current=head; current!=null; current=current.next){
        //     count++;
        // }
        // return count;
    }

    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("[ ");
        // could we convert this into a for loop?
        // Node current=head;
        // while(current!=null){
        //     sb.append(current.value);
        //     sb.append(", ");
        //     current=current.next;
        // }

        for(Node current=head; current!=null; current=current.next){
            sb.append(current.value);
            if (current.next!=null)               
                sb.append(", ");
        }

        sb.append(" ]");
        return sb.toString();
    }
}
