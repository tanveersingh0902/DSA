package DSA_practice.sorting;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
// Asked in google

public class findAllMissingNumbers {
    public static void main(String[] args) {

    }


    public List<Integer> findDisappearedNumbers(int[] nums) {

        int i = 0;
        while(i<nums.length){
            int correct = nums[i] - 1;
            if(nums[i] !=nums[correct] ){
                swap(nums , i, correct);
            }
            else {
                i++;
            }
        }
        // Find all indices where number is not equal to index + 1
        // Those index + 1 values are the missing numbers

        List<Integer>ans = new ArrayList<>();
        for(int index = 0; index < nums.length; index++){
            if(nums[index] != index + 1){
                ans.add(index + 1);
            }
        }
        return ans;

    }
    void swap(int[] arr , int left , int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
