package com.vladuken.tests;

import org.junit.Test;
import com.vladuken.tasks.Task7.Task7;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Task7Test {

    @Test
    public void testShellSort() {

        Task7 task7 = new Task7();

        assertArrayEquals(new double[]{1.2,5,7},task7.shellSort(new double[]{5,7,1.2}),0.001);
        assertArrayEquals(new double[]{},task7.shellSort(new double[]{}),0.001);
        assertArrayEquals(new double[]{1,2,3,4,5},task7.shellSort(new double[]{5,4,3,2,1}),0.001);
        assertArrayEquals(new double[]{0,0,0,0,0},task7.shellSort(new double[]{0,0,0,0,0}),0.001);


        //create huge array and sort it
        double[] array = new double[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (Math.random() * 10000);
        }
        double[] sortedarray = array;
        Arrays.sort(sortedarray);

        assertArrayEquals(sortedarray,task7.shellSort(array),0.0001);

    }
}