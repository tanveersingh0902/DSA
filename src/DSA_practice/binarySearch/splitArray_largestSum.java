package DSA_practice.binarySearch;

//https://leetcode.com/problems/split-array-largest-sum/description/
//Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.
//Return the minimized largest sum of the split.

public class splitArray_largestSum {


        public int splitArray(int[] nums, int k) {
            // Initialize binary search boundaries
            int start = 0;  // Minimum possible answer: largest single element
            int end = 0;    // Maximum possible answer: sum of all elements

            for(int i = 0; i < nums.length; i++){
                // start should be at least the largest element
                // (we can't split an element, so minimum largest sum is the max element)
                if(nums[i] > start) start = nums[i];

                // end is the sum of all elements
                // (worst case: all elements in one subarray)
                end += nums[i];
            }

            // Edge case optimization: if k equals array length
            // Each element must be in its own subarray, so answer is the max element
            if(k == nums.length) return start;

            // Binary search on the answer
            while(start < end){
                int mid = start + (end - start) / 2;

                // Check if we can split the array into k or fewer subarrays
                // where each subarray sum is <= mid
                if(canSplit(nums, k, mid)){
                    // If yes, mid might be our answer or we can go even smaller
                    // So search in the left half (smaller values)
                    end = mid;
                } else {
                    // If no, mid is too small, we need a larger value
                    // So search in the right half (larger values)
                    start = mid + 1;
                }
            }
            // When start == end, we've found our answer
            return start;
        }

        /**
         * Helper method to check if we can split the array into k or fewer subarrays
         * where each subarray sum is at most maxSum
         *
         *  nums - the input array
         *  k - maximum number of subarrays allowed
         *  maxSum - the maximum sum allowed for each subarray
         * @return true if split is possible, false otherwise
         */
        private boolean canSplit(int[] nums, int k, int maxSum){
            int pieces = 1;        // Start with 1 subarray
            int currentSum = 0;    // Sum of current subarray

            // Greedily try to fit elements into current subarray
            for(int num : nums){
                // If adding current element exceeds maxSum
                if(currentSum + num > maxSum){
                    // Start a new subarray
                    pieces++;
                    currentSum = num;  // Current element goes to new subarray

                    // If we've already exceeded k subarrays, no point continuing
                    // This saves time by not processing remaining elements
                    if(pieces > k) return false;
                } else {
                    // Add current element to existing subarray
                    currentSum += num;
                }
            }
            // If we finished the loop with pieces <= k, split is possible
            return true;
        }
    }

    /*
     * ALGORITHM EXPLANATION:
     * =====================
     *
     * Problem: Split array into k subarrays to minimize the largest subarray sum
     *
     * Key Insight: Instead of trying all possible splits, we binary search on the answer!
     *
     * Search Space:
     * - Minimum answer = largest element (can't split an element)
     * - Maximum answer = sum of all elements (all in one subarray)
     *
     * For each candidate answer (mid):
     * - Try to split array greedily where each subarray sum <= mid
     * - If we can do it in k or fewer pieces → try smaller answer
     * - If we need more than k pieces → try larger answer
     *
     * Example: nums = [7,2,5,10,8], k = 2
     *
     * Initial: start = 10 (max element), end = 32 (sum)
     *
     * Iteration 1: mid = 21
     * - Can we split with max sum 21? → [7,2,5] sum=14, [10,8] sum=18 → YES (2 pieces)
     * - Set end = 21
     *
     * Iteration 2: mid = 15
     * - Can we split with max sum 15? → [7,2,5] sum=14, [10] sum=10, [8] sum=8 → NO (3 pieces > 2)
     * - Set start = 16
     *
     * Iteration 3: mid = 18
     * - Can we split with max sum 18? → [7,2,5] sum=14, [10,8] sum=18 → YES (2 pieces)
     * - Set end = 18
     *
     * Final answer: 18
     *
     * TIME COMPLEXITY: O(n × log(sum of array))
     * - Binary search: log(sum - max_element)
     * - Each check: O(n) to iterate array
     *
     * SPACE COMPLEXITY: O(1)
     * - Only using constant extra space
     */









