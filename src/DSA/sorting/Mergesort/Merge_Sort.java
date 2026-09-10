package DSA.sorting.Mergesort;

import java.util.Arrays;

public class Merge_Sort {
    public static void main(String[] args) {

        int[] arr = {5 , 4 , 3 , 2 , 1};

        // original arr is never modified -- alawys assign back the result
        arr = mergesort(arr);
        System.out.println(Arrays.toString(arr));


    }
    //  DIVIDE PHASE
    //  Recursively splits the array into two halves
    //  until each piece has only 1 element

    static int[] mergesort(int[] arr){
        if(arr.length == 1){
            return arr;
        }

        int mid = arr.length /2;


        // Recursively sort the LEFT half  → index 0 to mid-1
        // Arrays.copyOfRange creates a brand new sub-array (does NOT modify original)
        int[] left = mergesort(Arrays.copyOfRange(arr , 0 , mid));

        // Recursively sort the RIGHT half → index mid to arr.length-1
        int[] right = mergesort(Arrays.copyOfRange(arr , mid , arr.length));

        return merge(left , right);
    }

    //  CONQUER PHASE
    //  Takes two individually sorted arrays and
    //  merges them into one fully sorted array

    private static int[] merge(int[] first , int[] second){
        int[] mix = new int[first.length+ second.length];

        int i = 0;
        int j = 0;
        int k = 0;

        // Compare elements from both arrays one by one
        // Pick the smaller one and put it into mix[]
        while (i < first.length && j < second.length){
            if (first[i] <= second[j]){
                mix[k] = first[i];
                i++;
            }
            else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }

        // If 'first' array still has remaining elements
        // (means all of 'second' is already placed)
        // Copy them directly — they are already in sorted order
        while (i < first.length){
            mix[k] = first[i];
            i++;
            k++;
        }
        // If 'second' array still has remaining elements
        // (means all of 'first' is already placed)
        // Copy them directly — they are already in sorted order
        while (j < second.length){
            mix[k] = second[j];
            j++;
            k++;
        }
        return mix;
    }
}
