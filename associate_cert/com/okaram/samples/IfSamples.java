package com.okaram.samples;

/* long term capital gains rate, 
 Tax rate   Single              Married filing jointly  Married filing separately   Head of household

    0%      $0 to $48,350           $0 to $96,700           $0 to $48,350           $0 to $64,750

    15%     $48,351 to $533,400     $96,701 to $600,050     $48,350 to $300,000     $64,751 to $566,700

    20%     $533,401 or more        $600,051 or more        $300,001 or more        $566,701 or more
 */
public class IfSamples {

    public void simpleIfExample() {
        int a=5;
        boolean b=a>5; // what's the value of b?
        if (b)
            System.out.println("a is greater than 5");

        if (a%2==0){
            System.out.println("a is greater than 5");
        } else {
            System.out.println("a is greater than 5");
        }
    }

    public String dayOfWeek(int dow){
        String answer="Undefined";
        if (dow==1)
            answer="Sunday";
        else if (dow==2)
            answer="Monday";
        else if (dow==3)
            answer="Tuesday";
        else if (dow==4)
            answer="Wednesday";
        else if (dow==5)
            answer="Thursday";
        else if (dow==6)
            answer="Friday";
        else if (dow==7)
            answer="Saturday";
        return answer;
    }

}
