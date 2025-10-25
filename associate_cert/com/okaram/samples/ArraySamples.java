package com.okaram.samples;

public class ArraySamples {

    public static
    void declare_example(){
        int[] a={1,2,3}; // a is an array variable, referencing an array of 3 elements
        int[] b=new int[10]; // b references an array of 10 elements, all 0
        a=b; // now a and b reference the same array
    }
    
}
