package com.company;

public class CWH_ch7_varargs {

    static int sum(int ...arr){
        int result =0;
        for (int a:arr){
            result += a;
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println("Welcome to varargs tutorial");
        System.out.println("The sum of 4 and 5 is: " + sum(4,5));
        System.out.println("The sum of 1 2 and 5 is: " +sum(1,2,5));
        System.out.println("The sum of 1 2 5 and 7 is: " +sum(1,2,5,7));
        System.out.println("The sum of 1 2 5 7 and 10 is: " +sum(1,2,5,7,10));














    }
}
