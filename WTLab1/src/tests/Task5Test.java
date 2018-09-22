import org.junit.Test;

import static org.junit.Assert.*;

public class Task5Test {

    @Test
    public void testFindNumOfElementsToDelete() {
        Task5 task5 = new Task5();
        //возрастающая != неубывающая
        assertEquals(1,task5.findNumOfElementsToDelete(new Integer[]{5,1,2,4}));
        assertEquals(2,task5.findNumOfElementsToDelete(new Integer[]{1,2,1,2,4}));
        assertEquals(0,task5.findNumOfElementsToDelete(new Integer[]{1,2,4}));
        assertEquals(4,task5.findNumOfElementsToDelete(new Integer[]{5,4,3,2,1}));
        assertEquals(3,task5.findNumOfElementsToDelete(new Integer[]{1,2,3,1,2,3}));
        assertEquals(0,task5.findNumOfElementsToDelete(new Integer[]{}));


    }
}