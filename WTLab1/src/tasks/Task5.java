import java.util.LinkedList;

public class Task5 {

    public int findNumOfElementsToDelete(Integer[] array){


        int length = 0,maxlength=0;
        for(int i = 0; i < array.length;i++){
            int startpoint = Integer.MIN_VALUE;
            length = 0;
            for(int j = i; j < array.length; j++){
                if (startpoint < array[j]){
                    startpoint = array[j];
                    length++;
                }
            }
            if (length>maxlength){
                maxlength=length;
            }
        }
        return array.length - maxlength;
    }
}
