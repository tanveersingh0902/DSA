package DSA.sorting;


import java.util.Arrays;

public class cyclic_sort {
    public static void main(String[] args) {

        int[] arr = {3,5,2,1,4};
        cycle(arr);
        System.out.println(Arrays.toString(arr));
    }

    // for array containing 1 to N
    static void cycle(int[] arr){

        int i = 0;
        while(i < arr.length){
            int correct = arr[i] - 1;      // find the correct position of the i --- index - 1
            if(arr[i] != arr[correct]){    // if not equal to correct position swap it with correct position
                swap(arr , i , correct);
            }
            else{
                i++;
            }
        }
    }

    // for array containing 0 to N
    static void sort(int[] arr) {
        int i = 0;
        while (i < arr.length){
            int correct = arr[i];
            if(arr[i] != arr[correct]){
                swap(arr , i , correct);
            }
            else {
                i++;
            }
        }
    }

    static void swap(int[] arr , int first , int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }


}
