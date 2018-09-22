package com.vladuken.tasks.Task4;

public class Prime {
    public static boolean isPrime(int number){
        boolean isPrime = true;
        for(int i = 2; i <= number/2; ++i)
        {
            // condition for nonprime number
            if(number % i == 0)
            {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }
}
