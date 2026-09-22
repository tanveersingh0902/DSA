package DSA_practice.stacksAndQueue;

public class LargestREctangleArea {


    /**
     * OPTIMIZATION: Array-based Stack (No Boxing Overhead)
     *
     * Java's Stack<Integer> has TWO performance costs:
     *   1. Boxing   → int → Integer object (heap allocation)
     *   2. Unboxing → Integer → int (extra dereference)
     *
     * Using int[] array as stack eliminates both costs.
     * This is the FASTEST version in competitive programming.
     *
     * TIME  : O(n)     → same asymptotic
     * SPACE : O(n)     → same asymptotic
     * PRACTICAL SPEED  → 2-3x faster than Stack<Integer>
     */
    public int largestRectangleArea(int[] heights) {

        // ═══════════════════════════════════════════════════
        // LINE 1: Get the length of the input array
        // ═══════════════════════════════════════════════════
        int n = heights.length;
        // heights = [2, 1, 5, 6, 2, 3]
        // n = 6


        // ═══════════════════════════════════════════════════
        // LINE 2: Create our array-based stack
        // ═══════════════════════════════════════════════════
        int[] stack = new int[n + 1];
        // WHY n+1?
        // We loop from i=0 to i=n (n+1 iterations)
        // In worst case (fully increasing array like [1,2,3,4,5,6])
        // ALL n bars get pushed before any pop happens
        // Then sentinel at i=n triggers all pops
        // So stack can hold at most n indices → size n+1 is safe
        //
        // Example worst case: [1,2,3,4,5,6]
        // stack gets: [0,1,2,3,4,5] pushed → needs size 6 = n
        // then i=6 (sentinel) triggers all pops
        // stack[6] = 6 gets pushed → needs size 7 = n+1


        // ═══════════════════════════════════════════════════
        // LINE 3: Stack pointer — tracks top of our stack
        // ═══════════════════════════════════════════════════
        int top = -1;
        // top = -1 means the stack is currently EMPTY
        // Think of it as: "there's nothing at index -1"
        // This is the standard way to represent an empty array-stack


        // ═══════════════════════════════════════════════════
        // LINE 4: Variable to track maximum area found
        // ═══════════════════════════════════════════════════
        int max = 0;
        // Start with 0, update whenever we find a larger area


        // ═══════════════════════════════════════════════════
        // LINE 5: The main loop — i goes from 0 to n (INCLUSIVE)
        // ═══════════════════════════════════════════════════
        for (int i = 0; i <= n; i++) {
            // WHY i <= n and not i < n?
            // When i = n (one past the last real bar),
            // we use currHeight = 0 (the virtual sentinel bar)
            // This sentinel drains all remaining bars from the stack
            // So we handle everything in ONE loop — no separate drain needed


            // ═══════════════════════════════════════════════
            // LINE 6: Determine the height at current index
            // ═══════════════════════════════════════════════
            int currHeight = (i == n) ? 0 : heights[i];
            // TERNARY EXPLANATION:
            // If i == n → we're at the virtual sentinel bar → height = 0
            // If i != n → we're at a real bar → use actual heights[i]
            //
            // WHY height 0?
            // 0 is shorter than any real bar (constraints say heights[i] >= 1)
            // So height=0 will trigger popping of ALL remaining bars
            //
            // heights = [2, 1, 5, 6, 2, 3]
            // i=0 → currHeight = heights[0] = 2
            // i=1 → currHeight = heights[1] = 1
            // i=6 → currHeight = 0  (sentinel!)


            // ═══════════════════════════════════════════════
            // LINE 7: Pop and calculate while stack is not
            //         empty AND current bar is SHORTER than
            //         the bar at the top of the stack
            // ═══════════════════════════════════════════════
            while (top != -1 && currHeight < heights[stack[top]]) {
                // BREAKDOWN:
                //   top != -1              → stack is not empty
                //   stack[top]             → INDEX of bar at top of stack
                //   heights[stack[top]]    → HEIGHT of bar at top of stack
                //   currHeight < heights[stack[top]] → current bar is SHORTER
                //
                // WHY do we pop here?
                // Current bar is shorter than top of stack.
                // This means the bar at top of stack CANNOT extend any further right
                // (it's blocked by the current shorter bar).
                // So NOW is the time to calculate its maximum rectangle!
                //
                // We keep popping until:
                //   - Stack is empty, OR
                //   - Top of stack is shorter than or equal to current bar


                // ═══════════════════════════════════════════
                // LINE 8: Pop the top index from our stack
                // ═══════════════════════════════════════════
                int popped = stack[top--];
                // BREAKDOWN:
                //   stack[top]  → read the index stored at current top
                //   top--       → THEN decrement top (post-decrement)
                //
                // This is equivalent to:
                //   int popped = stack[top];  // read
                //   top = top - 1;            // decrement
                //
                // 'popped' holds the INDEX of the bar we just removed
                // heights[popped] will give us its HEIGHT
                //
                // Example: stack=[1,2,3], top=2
                //   popped = stack[2] = 3
                //   top becomes 1
                //   stack=[1,2,3], top=1  (3 is logically removed)


                // ═══════════════════════════════════════════
                // LINE 9: Calculate the WIDTH of the rectangle
                // ═══════════════════════════════════════════
                int width = (top == -1) ? i : (i - stack[top] - 1);
                // This is the MOST IMPORTANT line. Let's break it down:
                //
                // CASE 1: top == -1 (stack is empty after popping)
                //   → The popped bar is the SHORTEST bar we've seen so far
                //   → It has NO shorter bar to its LEFT (nothing in stack)
                //   → So the rectangle extends from index 0 all the way to i-1
                //   → WIDTH = i - 0 = i
                //
                // CASE 2: top != -1 (stack still has elements)
                //   → stack[top] = index of the bar just below popped in stack
                //   → That bar is SHORTER than popped bar
                //   → So it acts as the LEFT BOUNDARY (cannot cross it)
                //   → RIGHT BOUNDARY = i (current position, exclusive)
                //   → WIDTH = i - stack[top] - 1
                //
                //   WHY subtract 1?
                //   stack[top] and i are both EXCLUSIVE boundaries
                //   Actual bars span from (stack[top]+1) to (i-1)
                //   Count = (i-1) - (stack[top]+1) + 1 = i - stack[top] - 1
                //
                // VISUAL EXAMPLE (i=4, popped=2, stack[top]=1 after pop):
                //
                // Index:  0  1  2  3  4  5
                // Height: 2  1  5  6  2  3
                //                    ↑
                //                    i=4 (right boundary, exclusive)
                //            ↑
                //            stack[top]=1 (left boundary, exclusive)
                //               ↑  ↑
                //               2  3  ← actual bars counted
                //
                // Width = 4 - 1 - 1 = 2 ✅


                // ═══════════════════════════════════════════
                // LINE 10: Calculate the AREA
                // ═══════════════════════════════════════════
                int area = heights[popped] * width;
                // heights[popped] = HEIGHT of the popped bar
                //                 = the LIMITING height of rectangle
                //                 (since popped bar is the shortest
                //                  within the calculated width)
                //
                // area = HEIGHT × WIDTH
                //
                // Example: popped=2, heights[2]=5, width=2
                //          area = 5 * 2 = 10


                // ═══════════════════════════════════════════
                // LINE 11: Update maximum area
                // ═══════════════════════════════════════════
                max = Math.max(max, area);
                // Keep track of the largest area seen so far

            } // end while


            // ═══════════════════════════════════════════════
            // LINE 12: Push current index onto the stack
            // ═══════════════════════════════════════════════
            stack[++top] = i;
            // BREAKDOWN:
            //   ++top       → FIRST increment top (pre-increment)
            //   stack[top]  → THEN store i at new top position
            //
            // This is equivalent to:
            //   top = top + 1;    // increment first
            //   stack[top] = i;   // then store
            //
            // WHY do we push here?
            // Current bar is >= top of stack (or stack was empty)
            // The MONOTONIC property is maintained
            // This bar might be useful as a LEFT BOUNDARY for future bars
            //
            // NOTE: When i = n (sentinel bar with height=0)
            // we push index n, but it doesn't matter
            // because we return max right after and never use it

        } // end for

        // ═══════════════════════════════════════════════════
        // LINE 13: Return the answer
        // ═══════════════════════════════════════════════════
        return max;
    }

}
