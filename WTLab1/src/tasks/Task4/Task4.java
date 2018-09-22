package Task4;

import java.util.LinkedList;
public class Task4 {

    public Integer[] getPrimesIndexesArray(Integer[] array){

        LinkedList<Integer> primeList = new LinkedList<>();
        for(int i = 0; i<array.length; i++){
            if (Prime.isPrime(array[i])){
                primeList.add(i);
                //System.out.println(array[i]);
            }
        }

        return primeList.toArray(new Integer[primeList.size()]);

    }

}
