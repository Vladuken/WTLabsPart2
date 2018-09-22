package Task4;

public class Prime {
    public static boolean isPrime(int number){
        boolean flag = true;
        for(int i = 2; i <= number/2; ++i)
        {
            // condition for nonprime number
            if(number % i == 0)
            {
                flag = false;
                break;
            }
        }

        return flag;
    }
}
