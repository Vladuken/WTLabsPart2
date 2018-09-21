import  java.lang.Math;

public class Task1 {
    public double compute(int x, int y){

        double top = (1 + Math.pow(Math.sin(x + y), 2));
        top = top / (2 + Math.abs(x - ( 2*x/(1+x*x*y*y)))) + x;

        return top;
    }
}
