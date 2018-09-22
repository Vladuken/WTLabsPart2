package Task9;

import java.util.LinkedList;

public class Basket {
    private LinkedList<Ball> ballList;

    public Basket(Ball... balls){
        this.ballList = new LinkedList<Ball>();
        for (Ball ball: balls){
            this.ballList.add(ball);
        }
    }


    public void add(Ball ball){
        this.ballList.add(ball);
    }

    public Double countWeight(){
        return ballList.stream().mapToDouble(i -> i.getWeight().doubleValue()).sum();
    }

    public long countBallsWithColor(Color ballColor){
        return ballList.stream().filter(i -> i.getColor() == ballColor).count();
    }
}
