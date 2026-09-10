package DSA.sorting;

import java.util.Arrays;

public class insertion_Sort {

    public static void main(String[] args) {
        int[] arr = {5,3,4,1,2};
        insertion(arr);
        System.out.println(Arrays.toString(arr));
    }

    // insertion sort by swap approach --- slightly slower but more clean code
    static void insertion(int[] arr){

        for(int i = 0; i < arr.length - 1; i++){
            for(int j = i + 1; j > 0; j--){
                if(arr[j] < arr[j-1]){
                    swap(arr , j , j-1);
                }
                else{
                    break;    // early exit when element is in correct position
                }
            }
        }
    }

    static void swap(int[] arr , int first , int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    // traditional approach ( shift approach) -- slightly faster
    static void Insertion(int[] arr){

        // start form second element
        for(int i = 1; i< arr.length; i++){
            int key = arr[i];    // element to be inserted
            int j = i - 1;

            // Move element greater than key one position ahead
            while(j>=0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j--;
            }
            // Insert key at its correct position
            arr[j+1] = key;
        }
    }




}
