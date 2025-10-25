package com.okaram.samples.ds;

import java.util.Iterator;

public class MyArrayList implements Iterable<Integer>{
    private int[] elements=new int[10];
    private int size=0;

    private class MyIterator implements java.util.Iterator<Integer> {
        int current=0;
        public boolean hasNext(){
            return current<size;
        }
        public Integer next() {
            ++current;
            return elements[current-1];
        }
    }
    
    public Iterator<Integer> iterator() {
        return new MyIterator();
    }
    public int size() {
        return size;
    }

    public boolean add(int elem) {
        if (size<elements.length) {
            elements[size]=elem;
            ++size;
            return true;
        } else {
            // for now
            return false;
        }
    }

    public int get(int index) {
        if(index<0 || index>=size)
            throw new java.lang.IndexOutOfBoundsException(String.format("Index %d out of bounds for length %d",index,size));
        return elements[index];
    }

    public int set(int index, int value) {
        if(index<0 || index>=size)
            throw new java.lang.IndexOutOfBoundsException(String.format("Index %d out of bounds for length %d",index,size));
        int tmp=elements[index];
        elements[index]=value;
        return tmp;
    }
}
