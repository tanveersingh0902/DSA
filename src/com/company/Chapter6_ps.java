package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Chapter6_ps {
    public static void main(String[] args) {

        // Question 1
   /*     float[] num = {10.5f, 20.5f, 30.5f, 40.5f, 50.5f};
        float sum=0;
        for (int i=0; i< num.length; i++){
            sum += num[i];
        }
        System.out.println(sum);

    */


        // Question2
/*        Scanner sc = new Scanner(System.in);

            System.out.println("Enter the size of the array");
            int size = sc.nextInt();
            int[] num = new int[size];

            System.out.println("enter the elements");
            for (int i = 0; i < size; i++) {
                num[i] = sc.nextInt();
            }
            System.out.println("Enter the integer");
            int x = sc.nextInt();

            boolean isINArray = false;
            for (int i = 0; i < size; i++) {
                if (num[i] == x) {
                    isINArray = true;
                    break;
                }
            }
            if (isINArray) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
 */

        // Question 3
/*        float sum=0;
        float avg =0;
        float [] marks = {100, 45, 65, 45, 54};
        for (float element: marks){
            sum += element;
             avg = sum / m
        System.out.println(avg);
 */

        // Question4
      int [][] mat1 = {{1, 2, 3},
                       {4, 5, 6}};
      int [][] mat2 = {{2, 6, 15},
                       {3, 7, 1}};
      int [][] result  = {{0, 0, 0},
                       {0, 0, 0}};

      for (int i =0; i< mat1.length; i++){
          for (int j=0; j< mat1[i].length; j++){
              result [i][j] = mat1[i][j] + mat2[i][j];
              System.out.print(result[i][j] + " ");
          }
          System.out.println("");
      }



        // Question5

    /*    int [] n = {1, 2, 3, 4, 5};
        for (int i =0; i<=n.length/2; i++){
            int temp = n[i];
            n[i] = n[n.length-i-1];
            n[n.length-i-1] = temp;
        }
        for (int i=0; i<n.length; i++){
            System.out.println(n[i]);
        }

     */


        // Question 6
/*        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size");
        int size = sc.nextInt();
        int[] num = new int [size];

        System.out.println("Enter the number");
        for (int i=0;i<size; i++ ){
            num[i]= sc.nextInt();
        }
        int max = Integer.MIN_VALUE;

        for (int i =0; i<size; i++){
            if (num[i]>max){
                max = num[i];
            }
        }
        System.out.println(max);
 */

        // Question 7
/*        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size");
        int size = sc.nextInt();
        int []num = new int [size];

        System.out.println("Enter the number");
        for (int i=0; i<size; i++){
            num[i]= sc.nextInt();
        }
        int min = Integer.MAX_VALUE;

        for (int i=0; i<size; i++){
            if (num[i]<min){
                min = num[i];
            }
        }
        System.out.println(min);
 */

        // Question 8
/*        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int []num = new int [size];

        for (int i=0; i<size; i++){
            num[i] = sc.nextInt();
        }
        boolean isSorted = true;

        for (int i =0; i<size-1; i++){
            if (num[i]>num[i+1]){
                isSorted = false;
                break;
            }
        }
            if (isSorted){
                System.out.println("Array is sorted");
            }
            else {
                System.out.println("Array is not sorted");
        }
 */



















    }
}
