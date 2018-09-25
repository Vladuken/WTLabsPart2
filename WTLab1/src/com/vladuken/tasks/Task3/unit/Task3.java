package com.vladuken.tasks.Task3.unit;

import java.util.Map;
import java.util.TreeMap;

public class Task3 {

    TreeMap<Double,Double> answerMap;

    public Task3(double a,double b, double h){
        this.answerMap = computeWithStep(a,b,h);
    }

    public TreeMap<Double,Double> computeWithStep(double a,double b,double h){
        // [a,b] step = h
        if (a>b){
            double temp = b;
            b = a;
            a = temp;
        }
        if (h<0) h = -h;

        TreeMap<Double,Double> answerMap = new TreeMap<>();

        while (a < b){
            answerMap.put(a,Math.tan(a));
            a+=h;
        }

        return answerMap;
    }

    public String getAnswersAsString(){
        StringBuilder stringBuilder = new StringBuilder("");

        for(Map.Entry<Double,Double> entry: answerMap.entrySet()){
            Double a = entry.getKey();
            Double f = entry.getValue();
            stringBuilder.append(String.format("%.2f", a) + " " + String.format("%.3f",f) +"\n");
        }

        return stringBuilder.toString();
    }

}
