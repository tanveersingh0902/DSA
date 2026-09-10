package com.company;

public class Chapter7_ps {

    static void multi(int x){
        for (int i =1; i<=10; i++){
            System.out.println(x + "*" + i + " = " + (x * i));
        }
    }
    static void pat(int x){
        for (int i =1; i<=x; i++){
            for(int j=1; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static int sum(int x){
        if (x == 1) {
            return 1;
        }
            return x + sum(x-1);
    }
    static void pat2(int x){
        for (int i =1; i<=x; i++){
            for(int j=1; j<=x-i+1; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    // question 5 of reccursion














    public static void main(String[] args) {

        // Question 1
//        multi(5);

        // Question 2
//        pat(4);

        // Question 3
//        int c = sum(5);
//        System.out.println(c);

        // Question 4
//        pat2(4);

        // Question5
     //   System.out.println(result);

        //Question 6












    }
}
