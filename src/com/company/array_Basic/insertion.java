package com.company.array_Basic;

public class insertion {
    public static void main(String[] args) {


        int[] arr = {10, 20, 30, 40, 0};
        int n = 4;
        int element = 50;
        int pos = 2;

        // Insert array at begining

        // Shift all elements to the right
        for (int i = n - 1; i >= 0; i--) {
            arr[i + 1] = arr[i];
        }
        // Insert new element at the beginning
        arr[0] = element;

        System.out.println("\nArray after insertion");
        for (int i = 0; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }

        // Inserting at the end of the array

        //Declare an integer array of 6 elements
        int [] intArray= new int[6];
        int length =0;

        // Add 3 elements to the array
        for (int i=0; i<3; i++){
            intArray[length]=i;
            length++;
        }
        // inserting a new element in the array
        intArray[length] = 10;
        length++;

       for (int i = 0; i< intArray.length; i++){
            System.out.println("Index " + i + " contains " + intArray[i]);
        }

        // Inserting Anywhere in the array

        // Suppose we have to insert the element in the 2 index

        for (int i=n; i>=pos; i--){
            intArray[i+1] = intArray[i];
        }
        intArray[2] = 30;

        for (int i=0; i< intArray.length; i++){
            System.out.println("Index " + i + " contains " + intArray[i]);
        }











































    }


    }




