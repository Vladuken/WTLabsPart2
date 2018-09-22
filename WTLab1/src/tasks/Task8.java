import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task8 {

    public Double[] mergeTwoArrays(Double[] firstArray,Double[] secondArray){


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
