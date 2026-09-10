package com.company.array_Basic;

public class deletion {

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 50, 100, 40};
        int n = arr.length;
        int pos = 2;


        // delete form begining
        // Shift all the elements 1 position to the left
        // starting from second element
        for (int i = 1; i < n; i++)
            arr[i - 1] = arr[i];

        // Reduce the array size by 1
        n--;

        System.out.println("\nArray after deletion");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        // delete from end
        // Reduce the array size by 1
        n--;

        System.out.println("\nArray after deletion");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        // delete from specific position
        for (int i = pos; i < n; i++) {
            arr[i - 1] = arr[i];
        }

        if (pos <= n) {
            n--;
        }

        System.out.println("\nArray after deletion");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");

        }
    }
}

