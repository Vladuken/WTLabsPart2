package com.vladuken.tasks.Task4.unit;

import com.vladuken.tasks.Task4.unit.Prime;

import java.util.LinkedList;
public class Task4 {

    public static Integer[] getPrimesIndexesArray(Integer[] array){

        LinkedList<Integer> primeList = new LinkedList<>();

        for(int i = 0; i<array.length; i++){
            if (Prime.isPrime(array[i])){
                primeList.add(i);
            }
        }

        return primeList.toArray(new Integer[primeList.size()]);

    }

}
