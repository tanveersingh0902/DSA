package com.company.array_Basic;

import java.util.Scanner;

public class CWH_ch6_forEachloop {
    public static void main(String[] args) {

        // Length of Array

    /*  float [] marks = {45.5f, 86.5f, 96.5f, 30.5f, 1.5f,};
        System.out.println(marks[0]);
        System.out.println(marks.length);
        String [] students = {"Tanveer", "Sahib", "Rohan", "Shubham", "Preet"};
        System.out.println(students[1]);
        System.out.println(students.length);
    */

        // Displaying the Array ( for loop )
        System.out.println("Printing Using for loop");
        int [] marks = {10, 50, 45, 69, 83};
        for (int i=0; i<marks.length; i++){
            System.out.println(marks[i]);
        }

        // Displaying the Array in reverse order ( for loop )
        System.out.println("Printing using for loop in reverse order");
         for (int i=marks.length-1; i>=0; i--){
             System.out.println(marks[i]);
        }

         // Displaying the Array ( for each loop )
        System.out.println("Printing using for each loop");
        for ( int element : marks){
            System.out.println(element);
        }


        // Taking the input from user
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int [] number = new int[size];

        // Input
        for (int i =0; i<size; i++){
            number[i] = sc.nextInt();
        }
        //output
        for (int i = 0; i<number.length; i++){
            System.out.println(number[i]);

        }





    }
}
