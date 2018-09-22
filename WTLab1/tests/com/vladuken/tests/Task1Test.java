package com.vladuken.tests;

import org.junit.Test;
import com.vladuken.tasks.Task1.Task1;

import static org.junit.Assert.*;

public class Task1Test {

    @Test
    public void testCompute() {
        Task1 task1 = new Task1();
        assertEquals(0.5,task1.compute(0,0),0.001);
    }
}