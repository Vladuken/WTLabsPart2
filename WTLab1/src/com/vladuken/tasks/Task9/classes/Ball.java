package com.vladuken.tasks.Task9.classes;

public class Ball {
    private Double weight;
    private Color color;

    public Ball(Double weight, Color color){
        this.weight = weight;
        this.color = color;
    }

    public Double getWeight(){
        return weight;
    }

    public Color getColor(){
        return color;
    }

    @Override
    public String toString(){
        return String.format( "Color: %8s", getColor())  +"  Weight: " + getWeight();
    }
}
