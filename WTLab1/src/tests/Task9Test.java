import Task9.Ball;
import Task9.Basket;
import Task9.Color;
import org.junit.Test;

import static org.junit.Assert.*;

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