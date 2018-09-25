package com.vladuken.tasks.Task9.classes;

import java.util.LinkedList;

public class Basket {
    private LinkedList<Ball> ballList;

    public Basket(Ball... balls){
        this.ballList = new LinkedList<>();
        for (Ball ball: balls){
            this.ballList.add(ball);
        }
    }

    public void add(Ball ball){
        this.ballList.add(ball);
    }

    public Double countWeight(){
        return ballList.stream()
                       .mapToDouble(i -> i.getWeight().doubleValue()).sum();
    }

    public long countBallsWithColor(Color ballColor){
        return ballList.stream()
                       .filter(i -> i.getColor() == ballColor).count();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder("");
        res.append("Basket with " + ballList.size() + " balls\n");

        for (Ball ball:ballList){
            res.append("    "+ ball + "\n");
        }
        res.append("Total weight: " + countWeight());

        return res.toString();
    }
}
