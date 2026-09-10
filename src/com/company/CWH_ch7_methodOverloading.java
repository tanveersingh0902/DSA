package com.company;

public class CWH_ch7_methodOverloading {

    static void foo(){
        System.out.println("Good morning bro");
    }
    static void foo(int a){
        System.out.println("Good Morning " + a + " bro");
    }
    static void foo(int a, int b){
        System.out.println("Good morning " + a + " bro");
        System.out.println("Good morning " + b + " bro");
    }
    static void change (int a){
        a = 98;
    }
    static void change2 (int [] arr){
        arr[0] = 98;
    }
    static void tellJoke(){
        System.out.println("I invented a new word\n" + "Plagiarism");
    }

    public static void main(String[] args) {
       // tellJoke();

        // Case 1: Changing the integer
        int [] marks = {52, 73, 77, 89, 98, 94};
        int x = 45;
        change(x);
        System.out.println("The value of x after running change is: " + x);

        //  Case 2: Changing the array
        int [] Marks = {52, 73, 77, 89, 98, 94};
        change2(Marks);
        System.out.println("THe value of x after running  the change is: " + Marks[0]);


        // METHOD OVERLOADING
        foo();
        foo(3000);
        foo(1000, 5222);

        // method overloading cannot be performed by changing the return type of methods















    }
}
