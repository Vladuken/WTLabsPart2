package com.vladuken.scanner;

import java.util.Scanner;

public class Reader{

    public static double readDouble(){
        Scanner in = new Scanner(System.in);

        while(!in.hasNextDouble()){
            in.next();
        }
        double result = in.nextDouble();

        return result;
    }

    public static int readInt(){
        Scanner in = new Scanner(System.in);

        while(!in.hasNextInt()){
            in.next();
        }
        int result = in.nextInt();
        return result;
    }

    public static  String readString(){
        Scanner in = new Scanner(System.in);
        String result = in.nextLine();
        return result;
    }


}
