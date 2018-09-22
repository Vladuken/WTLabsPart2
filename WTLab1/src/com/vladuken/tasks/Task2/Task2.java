package com.vladuken.tasks.Task2;

public class Task2 {

    public boolean isIn(double x, double y){

        boolean isin = false;
        if ((x <= 4 && x >= -4) && (y >= 0 && y <= 5)){
            isin = true;
        } else if((x<= 6 && x >= -6)&& (y<=0 && y>= -3)){
            isin = true;
        }

        return isin;
    }
}
