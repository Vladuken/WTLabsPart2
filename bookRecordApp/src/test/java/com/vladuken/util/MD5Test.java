package com.vladuken.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MD5Test {

    @Test
    public void getMD5() {
        Assert.assertEquals("5eb63bbbe01eeed093cb22bb8f5acdc3",MD5.getMD5("hello world"));
    }
}