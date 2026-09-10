package com.company.array_Basic;

import java.util.Arrays;
import java.util.Scanner;

public class CWH_ch6_MultidimensionalArray {
    public static void main(String[] args) {

       int [] marks;   // 1-D Array
        int [][] flats; // 2-D Array
        flats = new int [2][3];
        flats [0][0] = 101;
        flats [0][1] = 102;
        flats [0][2] = 103;
        flats [1][0] = 201;
        flats [1][1] = 202;
        flats [1][2] = 203;

        // Displaying the 2-D Array (for loop)
 /*       System.out.println("Printing a 2-D Array using for loop");
        for (int i = 0; i< flats.length; i++){
            for (int j = 0; j< flats[i].length; j++){
                System.out.print(flats[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

  */

        int [] [] arr = {

                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},

        };


      // Taking input from the user

        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int columns = sc.nextInt();
        int [][] numbers = new int [rows][columns];

        // input
        for (int i = 0; i<rows; i++){
            for (int j = 0; j<columns; j++){
                numbers[i][j] = sc.nextInt();
            }
        }

        //output
 /*       for (int i = 0; i<rows; i++){
            for (int j = 0; j< columns; j++){
                System.out.print(numbers[i][j]+" ");
            }
            System.out.println();
        }

  */
        // another method for output

//        for( rows=0; rows< numbers.length; rows++){
//            System.out.println(Arrays.toString(numbers[rows]));
//        }

        // another method for the output

        for(int []a : numbers){
            System.out.println(Arrays.toString(a));
        }










    }
}
