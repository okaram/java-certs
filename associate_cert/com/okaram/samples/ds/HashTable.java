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

    ArrayList<ArrayList<Entry>> values=new ArrayList<ArrayList<Entry>>();

    public HashTable(int size){ 
        for(int i=0;i<size;i++){
            values.add(new ArrayList<Entry>());
        }
    }

    public HashTable(){ 
        for(int i=0;i<100;i++){
            values.add(new ArrayList<Entry>());
        }
    }

    public void set(int key, String value) {
        int index = key % values.size();
        ArrayList<Entry> bucket = values.get(index);
        for(Entry entry: bucket){
            if(entry.key==key){
                entry.value=value;
                return;
            }
        }
        bucket.add(new Entry(key, value));
    }

    public String get(int key) {
        int index = key % values.size();
        ArrayList<Entry> bucket = values.get(index);
        for(Entry entry: bucket)
            if(entry.key==key)
                return entry.value; 
        return null;
    }

}
