package DSA_practice.slidingWindow;

import java.awt.*;

public class LongestSubarrayAfterDeletingOneElement {

    /**
     * -------------------------------------------------------
     * LeetCode 1493: Longest Subarray of 1's After Deleting One Element
     * -------------------------------------------------------
     * Approach  : Sliding Window (Two Pointers)
     * Time  : O(n) — single pass through array
     * Space : O(1) — only a few variables
     * -------------------------------------------------------
     */
    public int longestSubarray(int[] nums) {

        int left   = 0;  // Left boundary of the sliding window
        int zeros  = 0;  // Count of zeros in the current window
        int result = 0;  // Stores the maximum 1's count found so far

        // 'right' is the right boundary — we expand the window each iteration
        for (int right = 0; right < nums.length; right++) {

            // ── Step 1: Expand window — include nums[right] ──
            if (nums[right] == 0) {
                zeros++;          // One more zero entered our window
            }

            // ── Step 2: Shrink window if it has more than 1 zero ──
            // We can only DELETE ONE element, so at most 1 zero is allowed
            while (zeros > 1) {
                if (nums[left] == 0) {
                    zeros--;      // We're removing a zero from the window
                }
                left++;           // Shrink window from the left
            }

            // ── Step 3: Update result ──
            // Window [left..right] contains at most 1 zero.
            // After deleting that zero (or any 1 if no zeros exist),
            // count of 1's = (right - left + 1) - 1 = right - left
            result = Math.max(result, right - left);
        }

        return result;
    }

    /**
     * ════════════════════════════════════════════════════════════
     *  LeetCode 1493 — Longest Subarray of 1's After Deleting One
     * ════════════════════════════════════════════════════════════
     *
     *  OPTIMIZATION TRICKS for 100% Beats:
     *
     *  1. USE "if" INSTEAD OF "while" for shrinking:
     *     → while loop: may do multiple left++ per right step
     *     → if   loop: does EXACTLY 1 left++ per right step (O(1) guaranteed)
     *     → Window never SHRINKS, only GROWS or SLIDES (same size)
     *
     *  2. COMPUTE RESULT AT THE END (no max() every iteration):
     *     → Since window only grows/slides, final (right - left) = best size
     *     → Answer = nums.length - left - 1
     *     → Saves one operation per loop iteration
     *
     *  3. SINGLE PASS — no nested loops, no extra space
     *
     *  Time  : O(n) — every element touched at most twice (right++, left++)
     *  Space : O(1) — only 2 variables (left, zeros)
     * ════════════════════════════════════════════════════════════
     */
    public int longestSubarrayOptimise(int[] nums) {

        int left  = 0;   // Left boundary of sliding window
        int zeros = 0;   // Count of zeros in current window

        for (int right = 0; right < nums.length; right++) {

            // ── STEP 1: EXPAND — include nums[right] in window ──────
            if (nums[right] == 0) {
                zeros++;          // New zero entered the window
            }

            // ── STEP 2: SLIDE (not shrink!) if window is invalid ────
            // If zeros > 1, window is invalid.
            // Instead of SHRINKING (while), we SLIDE by 1 (if).
            // This preserves our "best window size" in (right - left).
            if (zeros > 1) {
                if (nums[left++] == 0) {  // left++ slides the window
                    zeros--;              // If we removed a zero, update count
                }
                // NOTE: left++ happens regardless (post-increment)
                // zeros-- happens ONLY IF nums[old_left] was 0
            }

            // ── NO max() calculation here — window size is auto-tracked ──
        }

        // ── STEP 3: COMPUTE ANSWER ───────────────────────────────────
        // After loop: right = nums.length (one past last index)
        // Best window size  = nums.length - left
        // Mandatory deletion = subtract 1
        // Final answer       = nums.length - left - 1
        return nums.length - left - 1;
    }

//    ╔═══════════════════════════════════════════════════════════════════╗
//            ║          while version vs if version                             ║
//            ╠═══════════════════════════════════════════════════════════════════╣
//            ║                                                                   ║
//            ║  WHILE version (per right step):                                 ║
//            ║  ✗ May do multiple left++ in one step                            ║
//            ║  ✗ Needs max() call every iteration                              ║
//            ║  ✗ More branch predictions needed                                ║
//            ║  ✗ Higher constant factor                                         ║
//            ║                                                                   ║
//            ║  IF version (per right step):                                    ║
//            ║  ✓ EXACTLY 1 left++ per right step — guaranteed O(1)            ║
//            ║  ✓ No max() call — answer at the very end                        ║
//            ║  ✓ Simple branch prediction                                      ║
//            ║  ✓ Minimum constant factor                                        ║
//            ║                                                                   ║
//            ║  KEY PROPERTY: Window NEVER shrinks, only GROWS or SLIDES        ║
//            ║  → Final (right-left) = best window size ever seen               ║
//            ║  → No need to track result separately                            ║
//            ╚═══════════════════════════════════════════════════════════════════╝
    
}
