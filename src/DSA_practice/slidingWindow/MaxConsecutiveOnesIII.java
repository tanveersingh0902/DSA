package DSA_practice.slidingWindow;

public class MaxConsecutiveOnesIII {
    /**
     * ═══════════════════════════════════════════════════════════
     *  LeetCode 1004: Max Consecutive Ones III
     * ═══════════════════════════════════════════════════════════
     *
     *  Approach : Sliding Window (Two Pointers)
     *
     *  LOGIC:
     *  - Expand right pointer → include nums[right] in window
     *  - If nums[right] == 0 → count++ (one flip used)
     *  - If count > k → we used MORE flips than allowed
     *       → Shrink from LEFT until count ≤ k again
     *       → If nums[left] was 0 → count-- (flip freed up)
     *       → left++  (remove left element from window)
     *  - Update max = right - left + 1 (window size)
     *
     *  TIME  : O(n) — each element enters and exits window once
     *  SPACE : O(1) — only 3 variables used
     * ═══════════════════════════════════════════════════════════
     */
    public int longestOnes(int[] nums, int k) {

        int left  = 0;    // Left boundary of window
        int count = 0;    // Count of zeros in current window (= flips used)
        int max   = 0;    // Stores the best window size seen so far

        // right pointer EXPANDS the window each iteration
        for (int right = 0; right < nums.length; right++) {

            // ── STEP 1: EXPAND — include nums[right] ───────────────
            if (nums[right] == 0) {
                count++;  // One more zero (flip) used
            }

            // ── STEP 2: SHRINK — if we exceeded k flips ────────────
            // Keep removing from left UNTIL count is back to ≤ k
            while (count > k) {
                if (nums[left] == 0) {
                    count--;   // Freed up a flip (removed a zero from window)
                }
                left++;        // Shrink window from left
            }

            // ── STEP 3: UPDATE MAX ──────────────────────────────────
            // Window [left..right] has at most k zeros (all flipped to 1)
            // So window size = number of consecutive 1's we can achieve
            max = Math.max(max, right - left + 1);
        }

        return max;
    }



}
