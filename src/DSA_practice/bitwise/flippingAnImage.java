package DSA_practice.bitwise;

//https://leetcode.com/problems/flipping-an-image/

import java.util.Arrays;

public class flippingAnImage {

    public static int[][] flip(int[][] image){

        // Iterate over each row in 2d array
        for(int[] row: image){

            // loop only till the middle of the row
            // (length + 1)/2 handles both even and odd length arrays

            for(int i = 0; i<(image[0].length+1)/2; i++){

                // STEP 1: Store row[i] inverted (XOR with 1) in temp
                // This is the LEFT element, inverted

                int temp = row[i] ^ 1;

                // STEP 2: Place the RIGHT element (inverted) into LEFT position
                // row[image[0].length - i - 1] is the mirror index

                row[i] = row[image[0].length - i - 1] ^ 1;

                // STEP 3: Place temp (original left, inverted) into RIGHT position
                row[image[0].length - i - 1] = temp;
            }
        }
        return image;
    }

    public static void main(String[] args) {

        int[][] arr = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        System.out.println(Arrays.deepToString(flip(arr)));   // use to print 2d array

    }
}
