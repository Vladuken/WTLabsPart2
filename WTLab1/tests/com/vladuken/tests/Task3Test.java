package com.vladuken.tests;

import com.vladuken.tasks.Task3.unit.Task3;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task3Test {

    @Test
    public void testComputeWithStep() {

        Task3 task1 = new Task3(0,0.6,0.25);
        Task3 task2 = new Task3(1,2.1,0.5);

        //task.computeWithStep(0,1,0.1);
        String res1 ="0.00 0.000\n0.25 0.255\n0.50 0.546\n";
        String res2 ="1.00 1.557\n1.50 14.101\n2.00 -2.185\n";
        assertEquals(res1,task1.getAnswersAsString());
        assertEquals(res2,task2.getAnswersAsString());

    }
}