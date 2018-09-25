package com.vladuken.tasks.Task6.unit;

public class Task6 {


    public static int[][] getMatrixFromPlain(int[] array){

        int[][] matrix = new int[array.length][array.length];

        for(int i = 0; i < array.length; i++){

            for(int j = 0; j < array.length; j++){

                if (j < array.length - i ){
                    matrix[i][j] = array[i+j];
                }else{
                    matrix[i][j] = array[i+j-array.length];
                }
            }
        }

        return matrix;
    }
}
