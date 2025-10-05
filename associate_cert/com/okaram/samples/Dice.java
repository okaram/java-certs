package com.okaram.samples;

import java.util.Random;

public class Dice {
    static Random generator=new Random();

    private int sides;
    public Dice(){
        sides=6;
    }

    public Dice(int sides){
        this.sides=sides;
    }

    public int roll(){
        return generator.nextInt(sides)+1;
    } 

    @Override
    public String toString() {
        return "Dice( "+sides+" sides)";
    }
}