package com.vladuken.tests;

import com.vladuken.tasks.Task1.unit.Task1;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Task1Test {

    @Test
    public void compute() {
        Assert.assertEquals(0.5,Task1.compute(0,0),0.0001);
    }
}