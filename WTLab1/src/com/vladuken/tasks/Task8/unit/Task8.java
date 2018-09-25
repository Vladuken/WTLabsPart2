package com.vladuken.tasks.Task8.unit;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task8 {

    public static Double[] mergeTwoArrays(Double[] firstArray,Double[] secondArray){


        List<Double> firstList =  Arrays.asList(firstArray);
        List<Double> secondList = Arrays.asList(secondArray);


        Object[] objArr =  Stream.concat(firstList.stream(), secondList.stream())
                                 .sorted()
                                 .collect(Collectors.toList())
                                 .toArray();


        Double[] mergedArray = new Double[objArr.length];

        for(int i = 0; i < objArr.length; i++){
            mergedArray[i] = (Double) objArr[i];
        }




        return mergedArray;
    }
}
