import org.junit.Test;

import static org.junit.Assert.*;

public class Task8Test {

    @Test
    public void testMergeTwoArrays() {
        Task8 task8 = new Task8();

        assertArrayEquals(new Double[]{2.2,3.2},task8.mergeTwoArrays(new Double[]{2.2},new Double[]{3.2}));
        assertArrayEquals(new Double[]{},task8.mergeTwoArrays(new Double[]{},new Double[]{}));
        assertArrayEquals(new Double[]{5.0,6.0,6.0,7.0},task8.mergeTwoArrays(new Double[]{5.0,7.0},new Double[]{6.0,6.0}));
        assertArrayEquals(new Double[]{2.2,3.2},task8.mergeTwoArrays(new Double[]{},new Double[]{2.2,3.2}));

    }
}