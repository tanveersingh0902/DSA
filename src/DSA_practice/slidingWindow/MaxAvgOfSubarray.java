package DSA_practice.slidingWindow;

public class MaxAvgOfSubarray {
    public double findMaxAverage(int[] nums, int k) {

        int n = nums.length;

        // ✅ OPTIMIZATION 1: Use int instead of double
        // Integer arithmetic is significantly faster than floating point
        // We compare SUMS (not averages), divide only ONCE at the end
        int windowSum = 0;

        // Phase 1: Compute sum of first window [0...k-1]
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        // maxSum tracks the best window sum seen so far
        int maxSum = windowSum;

        // Phase 2: Slide window across the array
        for (int i = k; i < n; i++) {

            // Slide: remove outgoing (nums[i-k]), add incoming (nums[i])
            windowSum += nums[i] - nums[i - k];

            // ✅ OPTIMIZATION 2: Direct if-check instead of Math.max()
            // Avoids method call overhead on EVERY iteration
            if (windowSum > maxSum) {
                maxSum = windowSum;
            }
        }

        // ✅ OPTIMIZATION 3: Single cast + division at the very end
        // (double) cast ensures floating-point result
        return (double) maxSum / k;
    }
}
