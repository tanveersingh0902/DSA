package DSA_practice.sorting;

// https://leetcode.com/problems/find-the-duplicate-number/
// Asked in Google, Microsoft, Amazon

public class FindDuplicate {

    /**
     * Finds the duplicate number in an array containing n+1 integers.
     * Each integer is in the range [1, n] inclusive.
     * There is only one repeated number, but it could be repeated more than once.
     * Uses cyclic sort approach to detect the duplicate.
     */
    public int findDuplicate(int[] nums) {

        int i = 0;

        // Cyclic sort approach: try to place each number at its correct index
        while(i < nums.length) {

            // Check if current number is not at its correct position
            // Number 'x' should ideally be at index 'x-1'
            if(nums[i] != i + 1) {
                // Calculate the correct index for current number
                int correct = nums[i] - 1;

                // If the number at current position is different from
                // the number at its correct position, swap them
                if(nums[i] != nums[correct]) {
                    swap(nums, i, correct);
                }
                else {
                    // If both positions have the same number, we found the duplicate
                    return nums[i];
                }
            }
            else {
                // If number is already at correct position, move to next index
                i++;
            }
        }

        // If no duplicate found (shouldn't reach here as per problem constraints)
        return -1;
    }
    void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
