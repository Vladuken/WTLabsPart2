package com.vladuken.tasks.Task2.runner;

import com.vladuken.tasks.Task2.unit.Task2;
import com.vladuken.tasks.scanner.Reader;

public class Runner {

    public static void main(String[] args){
        System.out.println("Please input x and y (different lines):");

        double x = Reader.readDouble();
        double y = Reader.readDouble();

        System.out.println(Task2.isIn(x,y));
    }
}
