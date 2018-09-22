package com.vladuken.tasks.Task9;

import com.vladuken.tasks.Task9.classes.Ball;
import com.vladuken.tasks.Task9.classes.Basket;
import com.vladuken.tasks.Task9.classes.Color;

public class App {
    public static void main(String[] args) {
        Basket basket1 = new Basket(new Ball(3.5, Color.BLACK),
                                    new Ball(2.4,Color.BLUE),
                                    new Ball(1.2,Color.ORANGE));

        Basket basket2 = new Basket(new Ball(0.5, Color.BLACK),
                                    new Ball(1.4,Color.RED),
                                    new Ball(8.2,Color.RED));

        System.out.println(basket1);
        System.out.println(basket2);

    }
}
