package com.okaram.samples;

import java.util.Scanner;

public class WhileSamples {

    public static boolean readYesNo(String message){
        Scanner scanner=new Scanner(System.in);
        var answer="";

        System.out.println(message);
        System.out.print("Please enter yes or no ");
        while (!answer.equals("yes") && !answer.equals("no")) {
            answer=scanner.nextLine().toLowerCase();
            if (!answer.equals("yes") && !answer.equals("no"))
                System.out.print("Sorry, that's not a valid input. Please enter yes or no");
        }
        return answer.equals("yes");
    }
    
    public static int pow(int base, int exponent) {
        int p=1;
        while(exponent>0){
            p*=base;
            exponent--;
        }
        return p;
    }

    public static int gcd(int large, int small) {
    
        while(small>0){
            int t=small;
            small=large%small;
            large=small;
        }
        return large;
    }

}
