package DSA.binarySearch;

import java.util.Arrays;

public class sorted_MAtrix {

//         * Binary Search in Fully Sorted Matrix (Treated as 1D Array)
//         * This works when the matrix is COMPLETELY sorted:
//         * - Each row is sorted left to right
//         * - First element of each row > last element of previous row
//         *
//         * Example: {1,3,5,7}, {10,11,16,20}, {23,30,34,60}
//         * Can be viewed as: [1,3,5,7,10,11,16,20,23,30,34,60]


        static int[] search(int[][] matrix, int target) {

            // Handle empty matrix
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return new int[]{-1, -1};
            }

            int rows = matrix.length;           // Total number of rows (m)
            int cols = matrix[0].length;        // Total number of columns (n)

            // Treat matrix as 1D array with indices from 0 to (rows*cols - 1)
            int left = 0;                       // Start of virtual 1D array
            int right = rows * cols - 1;        // End of virtual 1D array

            // Standard binary search on virtual 1D array
            while (left <= right) {

                // Find middle index in virtual 1D array
                int mid = left + (right - left) / 2;

                // KEY CONVERSION: Convert 1D index to 2D coordinates
                // Formula:
                //   row = mid / cols    (which row does this index fall in?)
                //   col = mid % cols    (which column within that row?)
                int midRow = mid / cols;
                int midCol = mid % cols;
                int midValue = matrix[midRow][midCol];

                // Case 1: Target found at middle position
                if (midValue == target) {
                    return new int[]{midRow, midCol};
                }

                // Case 2: Middle value is smaller than target
                // Search in right half (larger elements)
                else if (midValue < target) {
                    left = mid + 1;
                }

                // Case 3: Middle value is larger than target
                // Search in left half (smaller elements)
                else {
                    right = mid - 1;
                }
            }

            // Target not found in matrix
            return new int[]{-1, -1};
        }

        public static void main(String[] args) {

            // Example 1: Fully sorted matrix
            int[][] matrix1 = {
                    {1,  3,  5,  7},    // Row 0
                    {10, 11, 16, 20},   // Row 1
                    {23, 30, 34, 60}    // Row 2
            };

            System.out.println("Matrix 1:");
            System.out.println(Arrays.toString(search(matrix1, 3)));   // [0, 1]
            System.out.println(Arrays.toString(search(matrix1, 16)));  // [1, 2]
            System.out.println(Arrays.toString(search(matrix1, 60)));  // [2, 3]
            System.out.println(Arrays.toString(search(matrix1, 13)));  // [-1, -1]



        }
    }
