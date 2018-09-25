package com.vladuken.tasks.Task6.runner;

import com.vladuken.tasks.Task5.unit.Task5;
import com.vladuken.tasks.Task6.unit.Task6;

public class Runner {

    public static void main(String[] args){

        int[][] matrix = Task6.getMatrixFromPlain(new int[]{1,2,3,4});
        for(int[] line:matrix){
            for(int item:line){
                System.out.print(item);
            }
            System.out.println();
        }

        System.out.println(matrix);
    }
}
