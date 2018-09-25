package com.vladuken.tasks.Task8.runner;

import com.vladuken.tasks.Task6.unit.Task6;
import com.vladuken.tasks.Task8.unit.Task8;

public class Runner {

    public static void main(String[] args){

        Double[] mergedArray = Task8.mergeTwoArrays(new Double[]{1.0,2.0,3.1,4.1}, new Double[]{2.1,3.2,5.0,7.6,8.2});
        for(Double item:mergedArray){
                System.out.print(item + " ");
        }

    }
}
