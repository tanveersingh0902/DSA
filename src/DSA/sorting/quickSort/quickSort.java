package DSA.sorting.quickSort;

import java.util.Arrays;

public class quickSort {
    public static void main(String[] args) {

        int[] arr = {5,4,3,2,1};
        sort(arr , 0 , arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] nums , int low , int high){

        // BASE CASE: if the segment has 0 or 1 element, it's already sorted
        // This stops the infinite recursion

        if(low >= high){
            return;
        }
        int start = low;    // left pointer — moves RIGHT
        int end  = high;     // right pointer — moves LEFT
        int mid = start + (end - start)/2;
        int pivot = nums[mid];

        while(start <= end) {    // keep going until pointers cross

            // Move `start` RIGHT until we find something >= pivot
            // These elements are already on the correct side — no swap needed
            while (nums[start] < pivot) {
                start++;
            }

            // Move `end` LEFT until we find something <= pivot
            // Same idea — already on the correct side
            while (nums[end] > pivot) {
                end--;
            }

            // Both pointers found an element that is "out of place"
            // nums[start] >= pivot but it's on the left side  (should be right)
            // nums[end]   <= pivot but it's on the right side (should be left)
            // So we SWAP them

            if (start <= end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }

        // After the while loop:
        //   end   < start  (pointers have crossed)
        //   [low..end]   — all elements <= pivot
        //   [start..high] — all elements >= pivot
        sort(nums , low , end);
        sort(nums , start , high);
    }


}
