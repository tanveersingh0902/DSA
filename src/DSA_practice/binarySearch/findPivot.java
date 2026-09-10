package DSA_practice.binarySearch;

public class findPivot {
    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2};
        int ans = pivot(nums);
        System.out.println(ans);

    }
    // pivot for the sorted rotated array without duplicate elements
    static int pivot(int[] nums){
        int left = 0;
        int right = nums.length-1;

        while(left < right){
            int mid = left + (right - left) / 2;

            // If mid element is greater than the right element
            // pivot is in the right half
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }
            else {
                // pivot is in the left half or mid is the pivot
                right = mid;
            }
        }
        // if array is not rotated at all
        if(left == 0 && nums[left] < nums[right]){
            return -1;
        }
        return left;
    }


    }




