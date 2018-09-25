package com.vladuken.tasks.Task7.runner;

import com.vladuken.tasks.Task6.unit.Task6;
import com.vladuken.tasks.Task7.unit.Task7;

public class Runner {

    public static void main(String[] args){

        double[] array = Task7.shellSort(new double[]{1.1,2.0,3.0,2.2,1.2});

        for(double item:array){
            System.out.print(item + " ");
        }

    }
}
