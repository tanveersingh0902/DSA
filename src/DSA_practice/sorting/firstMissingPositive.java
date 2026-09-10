package DSA_practice.sorting;

import java.util.Arrays;

// https://leetcode.com/problems/first-missing-positive/
// Asked in Amazon, Google, Microsoft, Apple


//Finds the smallest missing positive integer in an unsorted array.
//        * Uses cyclic sort to place each number in range [1, n] at its correct index.
//        *
//        * Approach:
//        * 1. Use cyclic sort to place numbers 1 to n at indices 0 to n-1
//        * 2. Ignore numbers <= 0 and numbers > n (not relevant)
//     * 3. After sorting, first index where nums[i] != i+1 is the answer


public class firstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {1, 2, 0};

        System.out.println((positive(nums)));
    }


    public static int positive(int[] nums) {

        int i = 0;
        while(i<nums.length){
            int correct = nums[i] - 1;
            if(nums[i]>0 && nums[i] <=nums.length &&  nums[i] != nums[correct]){
                swap(nums , i , correct);
            }
            else {
                i++;
            }
        }
        for(int index = 0; index<nums.length; index++){
            if(nums[index] != index + 1){
                return index+1;

            }
        }
        return nums.length+1;


    }
   static void swap(int[] nums , int left , int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}

