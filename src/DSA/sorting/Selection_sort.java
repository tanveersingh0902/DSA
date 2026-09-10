package DSA.sorting;

import java.util.Arrays;

public class Selection_sort {

    public static void main(String[] args) {
        int[] arr = {3,1,5,4,2};
        selection(arr);
        System.out.println(Arrays.toString(arr));
    }

    // selection sort finding max and placing at end
    static void selection(int[] arr){

        for(int i =0; i< arr.length; i++){
            // find the max item in the remaining array and swap with correct index

            int last = arr.length - i -1;
            int maxIndex = getMaxIndex(arr , 0 , last);
            swap(arr , maxIndex , last);
        }
    }

    // Helper method to find index of max element
    static int getMaxIndex(int[] arr ,int start , int end){
        int max = start;

        for(int i = start; i<=end; i++){
            if(arr[max] < arr[i]){
                max = i;
            }
        }
        return max;
    }

    // helper method of swap two elements
    static void swap(int[] arr , int first , int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    // Alternative - finding minimum and placing at the beginning
    static void minSelection(int[] arr){
        for(int i = 0; i< arr.length; i++){
            int minIndex = getMinIndex(arr, i , arr.length - 1);
            swap(arr , minIndex , i);
        }
    }

    // Helper method to find index of min element
    static int getMinIndex(int[] arr , int start , int end){
        int min = start;

        for(int i = start; i<=end; i++){
            if(arr[min] > arr[i]){
                min = i;
            }
        }
        return min;
    }


}
