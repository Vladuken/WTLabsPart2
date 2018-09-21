import org.junit.Test;

import static org.junit.Assert.*;

public class Task2Test {

    @Test
    public void isIn() {
        Task2 task = new Task2();
        assertEquals(true,task.isIn(0,0));
        assertEquals(true,task.isIn(2,1));
        assertEquals(true,task.isIn(-3,-2));
        assertEquals(true,task.isIn(4,0));
        assertEquals(true,task.isIn(4,5));
        assertEquals(true,task.isIn(6,0));
        assertEquals(true,task.isIn(6,-3));

        assertEquals(true,task.isIn(-4,0));
        assertEquals(true,task.isIn(-4,5));
        assertEquals(true,task.isIn(-6,-3));


        assertEquals(false,task.isIn(7,0));
        assertEquals(false,task.isIn(9,9));
        assertEquals(false,task.isIn(5,2));
        assertEquals(false,task.isIn(-5,2));
        assertEquals(false,task.isIn(5,-4));
        assertEquals(false,task.isIn(0,7));
    }
}