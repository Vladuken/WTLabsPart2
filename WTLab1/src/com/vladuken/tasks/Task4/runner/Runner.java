package com.vladuken.tasks.Task4.runner;

import com.vladuken.tasks.Task3.unit.Task3;
import com.vladuken.tasks.Task4.unit.Task4;
import com.vladuken.tasks.scanner.Reader;

public class Runner {

    public static void main(String[] args){

        Integer[] array = Task4.getPrimesIndexesArray(new Integer[]{1,2,3,4,5,6,7,8});
        array.toString();
        for(Integer item: array){
            System.out.println(item);
        }

    }
}
