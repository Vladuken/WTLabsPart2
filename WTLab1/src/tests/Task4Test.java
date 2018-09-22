import Task4.Task4;
import org.junit.Test;

import static org.junit.Assert.*;

public class Task4Test {

    @Test
    public void testGetPrimesIndexesArray() {
        Task4 task4 = new Task4();

        assertArrayEquals(new Integer[]{0,1,3},task4.getPrimesIndexesArray(new Integer[]{1,3,6,7}));
        assertArrayEquals(new Integer[]{},task4.getPrimesIndexesArray(new Integer[]{}));
        assertArrayEquals(new Integer[]{},task4.getPrimesIndexesArray(new Integer[]{4,6,8,10}));
        assertArrayEquals(new Integer[]{0},task4.getPrimesIndexesArray(new Integer[]{1}));
        assertArrayEquals(new Integer[]{4},task4.getPrimesIndexesArray(new Integer[]{4,4,4,4,7}));
        assertArrayEquals(new Integer[]{0,1,2,3,4,5},task4.getPrimesIndexesArray(new Integer[]{1,3,5,7,11,13}));
    }
}