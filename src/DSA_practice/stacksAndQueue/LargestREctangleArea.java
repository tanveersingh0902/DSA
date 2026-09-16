package DSA_practice.stacksAndQueue;
import java.util.Stack;

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

        int n = heights.length;

        // int[] array acts as our stack
        // top = -1 means empty stack
        int[] stack = new int[n + 1]; // +1 for sentinel index
        int top = -1;                 // Stack pointer

        int max = 0;

        for (int i = 0; i <= n; i++) {

            // Current height: 0 for virtual bar at end (acts as trailing sentinel)
            int currHeight = (i == n) ? 0 : heights[i];

            // Pop while current bar is shorter than stack top
            while (top != -1 && currHeight < heights[stack[top]]) {

                int popped = stack[top--]; // Pop (decrement top pointer)

                // Width calculation
                int width = (top == -1) ? i : (i - stack[top] - 1);

                int area = heights[popped] * width;
                max = Math.max(max, area);
            }

            stack[++top] = i; // Push current index (pre-increment top)
        }

        return max;
    }
}
