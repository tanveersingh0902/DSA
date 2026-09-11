package DSA_practice.twoPointers;

import java.util.Arrays;

public class MaxNumberOfKSumPair {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int k = 5;
        int result = maxOperations(nums , k);
        System.out.println(result);
    }

    public static int maxOperations(int[] arr , int k){

        //step 1. Sort the array so we can use two pointers
        // After sorting, smaller values are on the left, larger on the right
        // This lets us smartly decide which pointer to move
        Arrays.sort(arr);

        // Left pointer starts at the smallest element
        int left = 0;

        // Right pointer starts at the largest element
        int right = arr.length-1;

        //counts how many valid pairs (summing to k) we remove
        int operations = 0;

        // Run until both pointer meet
        // once they meet , no more valid pair possible

        while(left < right){

            // Calculate the sum of elements at both pointers
            int sum = arr[left] + arr[right];

            if(sum == k){
                // perfect! this pair sums to k
                // Remove both elements (increment operations count
                operations++;

                // Move both pointers inward to look for next pair
                left++;
                right--;
            } else if (sum <k ) {
                // Sum is too small — we need a larger value
                // Since array is sorted, move left pointer right
                // to get a bigger number on the left side
                left++;
            }
            else {
                // Sum is too large — we need a smaller value
                // Since array is sorted, move right pointer left
                // to get a smaller number on the right side
                right--;
            }
        }

        // Return total number of valid pair removals
        return operations;

        }
    }
