package Task9;

public class Ball {
    private Double weight;
    private Color color;

    public Ball(Double weight,Task9.Color color){
        this.weight = weight;
        this.color = color;
    }


    public Double getWeight(){
        return weight;
    }

    public Color getColor(){
        return color;
    }
}
