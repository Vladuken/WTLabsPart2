package com.vladuken.tests;

import com.vladuken.tasks.Task9.classes.Ball;
import com.vladuken.tasks.Task9.classes.Basket;
import com.vladuken.tasks.Task9.classes.Color;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task9Test {

    Ball ball1 = new Ball(3.5,Color.BLUE);
    Ball ball2 = new Ball(2.1,Color.GREEN);
    Ball ball3 = new Ball(5.2, Color.GREEN);

    Basket basket1 = new Basket(new Ball(3.5, Color.GREEN),new Ball(3.4,Color.BLUE),new Ball(2.1,Color.GREEN));
    Basket basket2  = new Basket(ball1,ball2,ball3,ball2);
    @Test
    public void testCountWeight() {

        assertEquals(9,basket1.countWeight(),0.001);
        assertEquals(12.9,basket2.countWeight(),0.001);

    }

    @Test
    public void testCountBallsWithColor() {
        assertEquals(2,basket1.countBallsWithColor(Color.GREEN));
        assertEquals(3,basket2.countBallsWithColor(Color.GREEN));
    }
}