package DSA_practice.sorting;

// https://leetcode.com/problems/find-all-duplicates-in-an-array/
// Asked in Google, Amazon, Microsoft

import java.util.ArrayList;
import java.util.List;

public class findAllDuplicates {

    /**
     * Finds all numbers that appear twice in the array.
     * The array contains numbers from 1 to n, where n is the length of the array.
     * Each number appears either once or twice.
     * Uses cyclic sort approach to place each number at its correct index.
     */
    public List<Integer> findDuplicates(int[] nums) {

        int i = 0;

        // Cyclic sort: Place each number at its correct index
        // Number 'x' should be at index 'x-1'
        while(i < nums.length) {

            // Calculate the correct index for current number
            int correct = nums[i] - 1;

            // If current number is not at its correct position
            // AND the correct position doesn't already have this number
            if(nums[i] != nums[correct]) {
                // Swap to place the number at its correct position
                swap(nums, i, correct);
            }
            else {
                // If number is already at correct position OR
                // the correct position already has this number (duplicate)
                // Move to next index
                i++;
            }
        }

        // After cyclic sort, find all duplicates
        // If a number is not at its correct position (nums[index] != index + 1),
        // it means the correct number for this position is somewhere else
        // and this position contains a duplicate
        List<Integer> ans = new ArrayList<>();

        for(int index = 0; index < nums.length; index++) {
            // If the number at this index is not the expected number (index + 1)
            if(nums[index] != index + 1) {
                // This number is a duplicate (it belongs somewhere else too)
                ans.add(nums[index]);
            }
        }

        return ans;
    }

    void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}

