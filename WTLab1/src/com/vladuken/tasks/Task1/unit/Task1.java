package com.vladuken.tasks.Task1.unit;

public class Task1 {
    public static double compute(double x, double y){

        double top = (1 + Math.pow(Math.sin(x + y), 2));
        top = top / (2 + Math.abs(x - ( 2*x/(1+x*x*y*y)))) + x;

        return top;
    }
}
