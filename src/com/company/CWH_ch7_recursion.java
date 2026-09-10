package com.company;

public class CWH_ch7_recursion {

    // factorial(0) = 1
    // factorial(n) = n * factorial(n-1)

    static int factorial(int n){
        if (n==0 || n==1){
            return 1;
        }
        else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        int x = 4;
        System.out.println(" The value of factorial n is:" + factorial(x));
    }











}
