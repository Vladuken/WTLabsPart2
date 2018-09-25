package com.vladuken.tasks.Task5.runner;

import com.vladuken.tasks.Task3.unit.Task3;
import com.vladuken.tasks.Task5.unit.Task5;
import com.vladuken.tasks.scanner.Reader;

public class Runner {

    public static void main(String[] args){

        int num = Task5.findNumOfElementsToDelete(new Integer[]{1,2,3,4,5,6,7,8});
        System.out.println(num);
    }
}
