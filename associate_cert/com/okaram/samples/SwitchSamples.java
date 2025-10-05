package com.okaram.samples;

public class SwitchSamples {
    public String dayOfWeek(int dow){
        String answer="Undefined";
        switch (dow) {
            case 1:
                answer="Sunday";
                break;
            case 2:
                answer="Monday";
                break;
            case 3:
                answer="Tuesday";
                break;
            case 4:
                answer="Wednesday";
                break;
            case 5:
                answer="Thursday";
                break;
            case 6:
                answer="Friday";
                break;
            case 7:
                answer="Saturday";
                break;
        }
        return answer;
    }
}
