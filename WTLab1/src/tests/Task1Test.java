import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Task1Test {

    @Test
    public void compute() {

        Task1 task1 = new Task1();



        assertEquals(0.5,task1.compute(0,0),0.001);


    }
}