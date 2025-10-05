package com.okaram.samples;

public class Person {
    public String first, last;
    public Person(String  first, String last){
        this.first=first;
        this.last=last;
    }

    public String full_name() {
        return first+" "+last;
    }

    @Override
    public String toString() {
        return "Person( "+first+" "+last+")";
    }

    @Override
    public boolean equals(Object o) {
        Person po=(Person)o;
        return this.first==po.first && this.last==po.last;
    }
}