package DSA.Arrays;

public class KadanesAlgo {

    // Kadane's Algorithm is an efficient method to find the maximum sum of a
    // contiguous subarray within a one-dimensional array of numbers.
    // It solves the "Maximum Subarray Problem" in O(n) time and O(1) space.

    public static int kadane(int[] arr) {
        // maxSum: Stores the maximum sum found so far (global maximum)
        // Initialize with first element
        int maxSum = arr[0];

        // currentSum: Stores the maximum sum of subarray ending at current position
        // Initialize with first element
        int currentSum = arr[0];

        // Start from second element (index 1)
        for (int i = 1; i < arr.length; i++) {
            // At each position, we have two choices:
            // 1. Extend the existing subarray by adding current element: currentSum + arr[i]
            // 2. Start a new subarray from current element: arr[i]
            // We choose whichever gives larger sum
            currentSum = Math.max(arr[i], currentSum + arr[i]);

            // Update the global maximum if current sum is larger
            maxSum = Math.max(maxSum, currentSum);
        }

        // Return the maximum subarray sum
        return maxSum;
    }

    public static int kadaneAlternative(int[] arr) {
        // maxSoFar: Tracks the maximum sum found so far
        int maxSoFar = arr[0];

        // currentSum: Tracks the sum of current subarray
        int currentSum = arr[0];

        // Iterate through array starting from index 1
        for (int i = 1; i < arr.length; i++) {
            // If currentSum becomes negative, it won't contribute positively
            // to any future subarray, so we reset and start fresh
            if (currentSum < 0) {
                currentSum = arr[i];  // Start new subarray from current element
            } else {
                currentSum += arr[i];  // Extend current subarray
            }

            // Update maximum sum if current sum is larger
            if (currentSum > maxSoFar) {
                maxSoFar = currentSum;
            }
        }

        return maxSoFar;
    }




}
