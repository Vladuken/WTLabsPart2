package com.vladuken.tasks.Task3.runner;

import com.vladuken.tasks.Task2.unit.Task2;
import com.vladuken.tasks.Task3.unit.Task3;
import com.vladuken.tasks.Task5.unit.Task5;
import com.vladuken.tasks.scanner.Reader;

public class Runner {

    public static void main(String[] args){
        System.out.println("Please input a,b and h (different lines1):");

        double a = Reader.readDouble();
        double b = Reader.readDouble();
        double h = Reader.readDouble();

        Task3 task3 = new Task3(a,b,h);
        System.out.println(task3.getAnswersAsString());
    }
}
