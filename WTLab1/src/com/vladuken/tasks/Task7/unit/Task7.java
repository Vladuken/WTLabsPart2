package com.vladuken.tasks.Task7.unit;

public class Task7 {

    public static double[] shellSort(double [] rawArray){
        int inner,outer;
        double temp;

        int h = 1;

        while (h <= rawArray.length){
            h = h * 3 + 1;
        }

        while (h > 0) {
            //сдвигаемся на 1 шаг, для h-сортировки следующей группы элементов
            for (outer = h; outer < rawArray.length; outer++) {
                temp = rawArray[outer];
                inner = outer;
                //сортируем массив с шагом h
                while (inner > h - 1 && rawArray[inner - h] >= temp) {
                    rawArray[inner] = rawArray[inner - h];
                    inner -= h;
                }
                rawArray[inner] = temp;
            }
            //на каждом шаге уменьшаем h
            h = (h - 1) / 3;
        }
    return rawArray;
    }


}
