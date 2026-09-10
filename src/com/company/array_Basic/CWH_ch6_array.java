package com.company.array_Basic;

import java.util.Arrays;
import java.util.Scanner;

public class CWH_ch6_array {
    public static void main(String[] args) {

        /* Classroom of 500 students - you have to store marks of these 500 students
        you have 2 options:
        1. Create 500 variables
        2. Use Arrays
         */
        // array is the collection of the similar type of data and access of elements is fast in array
        // stored in contiguous memory location

        int [] marks = new int[5];  // declare and memory allocation --- creating the object in the heap memory
        marks[0] = 100; // initialize
        marks[1] = 60;
        marks[2] = 70;
        marks[3] = 85;
        marks[4] = 51;
        System.out.println(marks[4]); // if we print marks[5] it will show error

        // we can also create array like (declaration memory allocation and initialization together )
        int [] MARKS = {45, 85, 56, 32, 20};
        System.out.println(MARKS[4]);

        // Array starts from 0 and goes till n-1 where is the size of the array

        // Important -- Reverse an Array
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int [] num = new int[size];

        for (int i=0; i<size; i++){
            num[i]= sc.nextInt();
        }
        int left =0;
        int right =num.length-1;
        while(left<right){
            int temp = num[left];
            num[left] = num[right];
            num[right] = temp;
            left++;
            right--;
        }
        for (int i=0; i<size; i++){
            System.out.print(num[i] + " ");
        }


        // we can also print the array by using toString method

        int [] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr));





















    }
}
