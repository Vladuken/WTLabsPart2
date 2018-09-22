package com.vladuken.tests;

import org.junit.Test;
import com.vladuken.tasks.Task6.Task6;

import static org.junit.Assert.*;

public class Task6Test {

    @Test
    public void testGetMatrixFromPlain() {
        Task6 task6 = new Task6();

        assertArrayEquals(new int[][]{{1,2,3}
                                     ,{2,3,1}
                                     ,{3,1,2}}, task6.getMatrixFromPlain(new int[]{1,2,3}));

        assertArrayEquals(new int[][]{{1,2,3,7}
                                     ,{2,3,7,1}
                                     ,{3,7,1,2}
                                     ,{7,1,2,3}}, task6.getMatrixFromPlain(new int[]{1,2,3,7}));

        assertArrayEquals(new int[][]{{1,1,1,1}
                                     ,{1,1,1,1}
                                     ,{1,1,1,1}
                                     ,{1,1,1,1}}, task6.getMatrixFromPlain(new int[]{1,1,1,1}));



        assertArrayEquals(new int[][]{}, task6.getMatrixFromPlain(new int[]{}));
        assertArrayEquals(new int[][]{{1}}, task6.getMatrixFromPlain(new int[]{1}));


    }
}