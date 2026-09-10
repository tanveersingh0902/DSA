package DSA.Arrays;

public class sliding_window {

    public static void main(String[] args) {

 /*       // Template for fixed sliding window

        // Fixed-size sliding window template
        int windowSum = 0;

// 1️⃣ Build the first window of size k
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int maxSum = windowSum;

// 2️⃣ Slide the window across the array
        for (int i = k; i < n; i++) {

            // Add the new element & remove the old element
            windowSum += arr[i] - arr[i - k];

            // Update answer for this window
            maxSum = Math.max(maxSum, windowSum);
        }
// Return or use maxSum
        return maxSum;
  */



   /*  * TEMPLATE: Variable Size Sliding Window
     * Use when: Window size needs to grow/shrink based on conditions
     * Time: O(n), Space: O(1) or O(k) for tracking window state

        public int variableWindowTemplate(int[] arr, int target) {
            int n = arr.length;
            int left = 0;
            int windowState = 0; // Track window property (sum, count, etc.)
            int result = 0; // or Integer.MAX_VALUE/MIN_VALUE based on problem

            for (int right = 0; right < n; right++) {

                // 1. EXPAND: Add arr[right] to window
                windowState += arr[right];

                // 2. SHRINK: While window is invalid, shrink from left
                while ( window condition violated ) {
                    windowState -= arr[left];
                    left++;
                }

                // 3. UPDATE: Update result with current valid window
                result = Math.max(result, right - left + 1);
            }

            return result;
        }

         */


    }
}
