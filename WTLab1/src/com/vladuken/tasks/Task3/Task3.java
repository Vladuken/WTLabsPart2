package com.vladuken.tasks.Task3;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Task3 {
    public String computeWithStep(double a,double b,double h){
        // [a,b] step = h
        if (a>b){
            double temp = b;
            b = a;
            a = temp;
        }
        if (h<0) h = -h;

        String res = "";
        double buff;
        while (a < b){
            buff = Math.tan(a);
            res += String.format("%.2f", a) + " " + String.format("%.3f",buff) +"\n";
            a+=h;
        }

        System.out.println(res);

        return res;

    }


}
