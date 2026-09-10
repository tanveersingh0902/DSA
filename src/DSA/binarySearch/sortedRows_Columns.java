package DSA.binarySearch;

import java.util.Arrays;

// Searches for a target value in a 2D matrix where:
// Each row is sorted in ascending order (left to right)
// Each column is sorted in ascending order (top to bottom)

public class sortedRows_Columns {
    public static void main(String[] args) {

        int[][] arr = {
                {10,20,30,40},
                {15,25,35,45},
                {28,29,37,49},
                {33,34,38,50}
        };
        System.out.println(Arrays.toString(search(arr, 37)));


    }

    static int[] search(int[][] matrix , int target){

        // Start from the TOP-RIGHT corner of the matrix
        int r = 0;                      // first row (top)
        int c = matrix[0].length - 1;  //  last column (right)

        // r < matrix.length ensures we don't go below the matrix
        // c >= 0 ensures we don't go left of the matrix

        while(r < matrix.length && c >= 0){
            if(matrix[r][c] == target){
                return new int[]{r,c};
            }

            // Case 2: Current element is SMALLER than target
            // Since row is sorted, all elements to the LEFT are even smaller
            // So we can eliminate this entire row and move DOWN
            if(matrix[r][c] < target){
                r++;  // move to next row
            }
            // Case 3: Current element is LARGER than target
            // Since column is sorted, all elements BELOW are even larger
            // So we can eliminate this entire column and move LEFT
            else{
                c--;  // move to previous column
            }
        }
        return new int[]{-1,-1};
    }
}
