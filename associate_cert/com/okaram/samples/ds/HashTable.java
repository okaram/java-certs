package com.okaram.samples.ds;
import java.util.ArrayList;
public class HashTable {
    static class Entry {
        int key; // easier to illustrate
        String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    ArrayList<Entry>[] values=new ArrayList<Entry>[100];

    // public void set(int key, String value) {
    //     int index = key % values.length;
    //     values[index] = new ArrayList<Entry>();
    //     values[index].add(new Entry(key, value));
    // }

    // public String get(int key) {
    //     int index = key % values.length;
    //     Entry entry = values[index];
    //     return entry != null && entry.key==key ? entry.value : null;
    // }

}
