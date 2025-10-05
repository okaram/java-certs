package com.okaram.samples;

public class MathSamples {
    public static
    double solveQuadratic(double a, double b, double c) {
        return (-b * Math.sqrt( Math.pow(b,2) - 4*a*c) )/(2*a);
    }
}
