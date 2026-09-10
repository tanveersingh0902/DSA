package DSA_practice.recursion.pattern;

import java.util.Arrays;

public class Triangle {

    public static void main(String[] args) {

        triangle(4,0);
//        triangle2(4 , 0);
        int[] arr = {4,3,2,1};
      //  bubble(arr ,arr.length - 1 , 0 );
//        selection(arr , arr.length , 0 , 0);
     //   System.out.println(Arrays.toString(arr));
    }

    static void triangle(int r , int c){

        if(r == 0){
            return;
        }
        if(c < r){
            System.out.print("* ");
            triangle(r , c+1);
        }
        else{
            System.out.println();
            triangle(r - 1 , 0);
        }
    }

    static void triangle2(int r , int c){

        if(r == 0){
            return;
        }
        if(c < r){
            triangle2(r , c+1);
            System.out.print("* ");
        }
        else{
            triangle2(r - 1 , 0);
            System.out.println();
        }
    }

    static void bubble(int[] arr , int r , int c ){

        // BAse case
        if(r == 0){
            return;
        }
        //  column work - still comparing with current pass
        if(c < r){
            if(arr[c] > arr[c+1]){   // out of order
                int temp = arr[c];   // swap
                arr[c] = arr[c+1];
                arr[c+1] = temp;
            }

            bubble(arr , r , c+1);   // move to the next pair
        }
        else {

            // row work - pass comp,ete , reduce unsorted zone
            bubble(arr , r-1 , 0);  // shrink r ,  reset c
        }
    }

    static void selection(int[] arr , int r ,int c , int max){

        // BAse case array is sorted
        if(r==0) {
            return;
        }

        // column work - still scanning within the current pass
        if(c < r){
            // found a new max element , update max to current index c
            if(arr[c] > arr[max]){
                selection(arr , r, c+1 , c);    // c becomes new max
            }

            // current element is smaller , old max still holds
            else {
                selection(arr , r , c+1 , max);
            }
        }

        // row end - full pass complete , max index is finalized
        else {
            // swap
            int temp  = arr[max];
            arr[max] = arr[r-1];
            arr[r-1] = temp;

            // shrink unsorted zone by 1
            selection(arr , r-1 , 0 , 0);
        }


    }

}

