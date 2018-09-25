
import com.vladuken.tasks.Task1.unit.Task1;
import com.vladuken.tasks.scanner.Reader;

public class Runner {

    public static void main(String[] args){
        System.out.println("Please input x and y (different lines1):");

        double x = Reader.readDouble();
        double y = Reader.readDouble();

        System.out.println(Task1.compute(x,y));
    }
}
