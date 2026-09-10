package com.company.array_Basic;

public class merge{

    public static int[] merge(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int[] result = new int[n + m];

        int i = 0; // pointer for array a
        int j = 0; // pointer for array b
        int k = 0; // pointer for result

        // Step 1: Compare and pick smaller element
        while (i < n && j < m) {
            if (a[i] <= b[j]) {
                result[k] = a[i];
                i++;
            } else {
                result[k] = b[j];
                j++;
            }
            k++;
        }

        // Step 2: Copy remaining elements of a (if any)
        while (i < n) {
            result[k] = a[i];
            i++;
            k++;
        }

        // Step 3: Copy remaining elements of b (if any)
        while (j < m) {
            result[k] = b[j];
            j++;
            k++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7};
        int[] b = {2, 4, 6, 8};

        int[] merged = merge(a, b);

        System.out.print("Merged Array: ");
        for (int x : merged) {
            System.out.print(x + " ");
        }
    }
}