import org.junit.Test;

import static org.junit.Assert.*;

public class Task3Test {

    @Test
    public void testComputeWithStep() {

        Task3 task = new Task3();

        //task.computeWithStep(0,1,0.1);
        String res1 ="0.00 0.000\n0.25 0.255\n0.50 0.546\n";
        String res2 ="1.00 1.557\n1.50 14.101\n2.00 -2.185\n";
        assertEquals(res1,task.computeWithStep(0,0.6,0.25));
        assertEquals(res2,task.computeWithStep(1,2.1,0.5));

    }
}