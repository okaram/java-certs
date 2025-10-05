package com.okaram.samples;

/* long term capital gains rate, 
 Tax rate   Single              Married filing jointly  Married filing separately   Head of household

    0%      $0 to $48,350           $0 to $96,700           $0 to $48,350           $0 to $64,750

    15%     $48,351 to $533,400     $96,701 to $600,050     $48,350 to $300,000     $64,751 to $566,700

    20%     $533,401 or more        $600,051 or more        $300,001 or more        $566,701 or more
 */
public class ConditionalSamples {

    public void simpleIfExample() {
        int a=5;
        boolean b=a>5; // what's the value?
        if (b)
            System.out.println("a is greater than 5");

        if (a%2==0)
            System.out.println("a is greater than 5");
        else
            System.out.println("a is greater than 5");
    }

    public double lontTermCapitalGainsRateFilingSingle(int taxableIncome) {
            if (taxableIncome<=48350)
                return 0;
            else if (taxableIncome<=533400)
                return 0.15;
            else
                return 0.2;
    }

    public double longTermCapitalGainsRate(int taxableIncome, EnumSamples.TaxFilingStatus filingStatus){
        if (filingStatus==EnumSamples.TaxFilingStatus.SINGLE) {
            if (taxableIncome<=48350)
                return 0;
            else if (taxableIncome<=533400)
                return 0.15;
            else
                return 0.2;
        }
        if (filingStatus==EnumSamples.TaxFilingStatus.MARRIED_FILING_JOINTLY) {
            if (taxableIncome<=96700)
                return 0;
            else if (taxableIncome<=600050)
                return 0.15;
            else
                return 0.2;
        }
        if (filingStatus==EnumSamples.TaxFilingStatus.MARRIED_FILING_SEPARATELY) {
            if (taxableIncome<=48350)
                return 0;
            else if (taxableIncome<=300000)
                return 0.15;
            else
                return 0.2;
        }
        if (filingStatus==EnumSamples.TaxFilingStatus.HEAD_OF_HOUSEHOLD) {
            if (taxableIncome<=64750)
                return 0;
            else if (taxableIncome<=566700)
                return 0.15;
            else
                return 0.2;
        }
        return -1;
    }   
}
