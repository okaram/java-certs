package com.okaram.samples.ds;

public class HashTableWrong {
    static class Entry {
        int key; // easier to illustrate
        String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    Entry[] values=new Entry[100];

    public void set(int key, String value) {
        int index = key % values.length;
        values[index] = new Entry(key, value);
    }

    public String get(int key) {
        int index = key % values.length;
        Entry entry = values[index];
        return entry != null && entry.key==key ? entry.value : null;
    }

}
