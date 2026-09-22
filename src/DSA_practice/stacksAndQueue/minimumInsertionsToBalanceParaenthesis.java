package DSA_practice.stacksAndQueue;

import java.util.Stack;

public class minimumInsertionsToBalanceParaenthesis {
    /**
     * PROBLEM STATEMENT:
     * Given a string s containing '(' and ')' only.
     * A string is balanced if every '(' is followed by exactly TWO consecutive ')'.
     * Example: "(())" is NOT balanced, but "(()))" IS balanced.
     * <p>
     * Find minimum number of insertions to make the string balanced.
     * <p>
     * KEY RULE: '(' needs "))", not just ")" to be balanced!
     */

    public static int minInsertions(String s) {

        int openCount = 0;   // Tracks unmatched '(' that still need "))".
        int insertions = 0;   // Total insertions we need to make.
        int i = 0;   // Current index pointer.

        while (i < s.length()) {

            char ch = s.charAt(i);

            // -------------------------------------------------------
            // CASE 1: We encounter '('
            // -------------------------------------------------------
            if (ch == '(') {
                /*
                 * This '(' is waiting for "))" ahead.
                 * Just increment openCount and move forward.
                 *
                 * Example: "(..."
                 *           ^
                 *           openCount becomes 1, waiting for "))"
                 */
                openCount++;
                i++;
            }

            // -------------------------------------------------------
            // CASE 2: We encounter ')'
            // -------------------------------------------------------
            else {
                /*
                 * A valid closing needs TWO consecutive ')' i.e. "))".
                 * Check if the NEXT character is also ')'.
                 */

                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    /*
                     * SUBCASE 2A: Next char is also ')' → perfect pair "))"
                     * Consume both characters together.
                     *
                     * Example: "...)) ..."
                     *               ^^
                     *               i  i+1
                     * Skip both → i += 2
                     */
                    i += 2;

                } else {
                    /*
                     * SUBCASE 2B: Next char is NOT ')' (it's '(' or end of string).
                     * We only have a single ')' but need "))".
                     * So INSERT one extra ')' to complete the pair.
                     *
                     * Example: "...)( ..."  or  "...)"  (end)
                     *               ^
                     *               only one ')', insert another
                     */
                    insertions++; // Insert one ')' to complete the "))" pair.
                    i++;          // Move past current ')'.
                }

                /*
                 * Now we have a complete "))" pair (either naturally or after insertion).
                 * This pair should CLOSE one '('.
                 *
                 * Check if there's an open '(' waiting.
                 */
                if (openCount > 0) {
                    /*
                     * Great! A '(' is waiting → match it with this "))" pair.
                     * Reduce openCount.
                     *
                     * Example: "( ... ))"
                     *           matched!
                     */
                    openCount--;

                } else {
                    /*
                     * No '(' is available to match this "))" pair.
                     * We must INSERT a '(' before this "))" pair.
                     *
                     * Example: "))" → no preceding '(', so insert → "(  ))"
                     */
                    insertions++; // Insert '(' to match this "))" pair.
                }
            }
        }

        // -------------------------------------------------------
        // FINAL STEP: Handle remaining unmatched '('
        // -------------------------------------------------------
        /*
         * If openCount > 0, there are still '(' that never got their "))".
         * Each unmatched '(' needs TWO ')' inserted.
         *
         * Example: "(((" → openCount = 3 → need 3 × 2 = 6 insertions
         */
        insertions += openCount * 2;

        return insertions;
    }

    /**
     * APPROACH: Stack-Based
     * <p>
     * INTUITION:
     * - Use a stack to track unmatched '(' characters.
     * - Use a counter to track how many ')' we still need to close current '('.
     * <p>
     * STACK STORES: Unmatched '(' that are waiting for their "))".
     * <p>
     * KEY INSIGHT:
     * - Every '(' needs EXACTLY TWO ')' to close it.
     * - When we see ')', we check if it has a partner ')' next to it.
     * → If yes  : consume "))" and pop one '(' from stack.
     * → If no   : insert one ')', then pop one '(' from stack.
     * (if stack empty, also insert one '(')
     * <p>
     * At the end, every remaining '(' in stack needs 2 ')' inserted.
     */

    public static int minInsertionss(String s) {

        Stack<Character> stack = new Stack<>(); // Holds unmatched '('
        int insertions = 0;                     // Count of insertions needed
        int i = 0;                              // Index pointer

        while (i < s.length()) {

            char ch = s.charAt(i);

            // =============================================================
            // CASE 1: Current character is '('
            // =============================================================
            if (ch == '(') {
                /*
                 * Push '(' onto stack.
                 * It is now waiting for "))" to close it.
                 *
                 * Stack before: [ ... ]
                 * Stack after : [ ... , '(' ]
                 */
                stack.push(ch);
                i++;
            }

            // =============================================================
            // CASE 2: Current character is ')'
            // =============================================================
            else {

                // ---------------------------------------------------------
                // SUBCASE 2A: We have a natural "))" pair
                // ---------------------------------------------------------
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    /*
                     * Found "))" naturally — perfect closing pair.
                     * Consume both ')' characters.
                     *
                     * Example:  "...  )  )  ..."
                     *                 i  i+1
                     *           skip both → i += 2
                     */
                    i += 2; // consume both ')' characters

                }
                // ---------------------------------------------------------
                // SUBCASE 2B: Single ')' with no partner next
                // ---------------------------------------------------------
                else {
                    /*
                     * Only ONE ')' available, but we need TWO.
                     * INSERT one extra ')' to complete the "))" pair.
                     *
                     * Example:  "...  )  (  ..."   or   "...  )"  (end of string)
                     *                 i
                     *           insert ')' here to make "))"
                     */
                    insertions++; // Insert one ')' to complete the pair
                    i++;          // Move past current ')'
                }

                // ---------------------------------------------------------
                // After handling the '))', try to match with a '(' in stack
                // ---------------------------------------------------------
                if (!stack.isEmpty()) {
                    /*
                     * A '(' is waiting on the stack → POP it.
                     * The "))" we just processed closes this '('.
                     *
                     * Stack before: [ ... , '(' ]
                     * Stack after : [ ... ]
                     */
                    stack.pop();

                } else {
                    /*
                     * Stack is EMPTY — no '(' available to match "))"
                     * We must INSERT a '(' to pair with this "))".
                     *
                     * Example:  "))" with empty stack
                     *           insert '(' → "( ))"
                     */
                    insertions++; // Insert '(' to match this "))" pair
                }
            }
        }

        // =============================================================
        // FINAL STEP: Clear remaining unmatched '(' from the stack
        // =============================================================
        /*
         * Every remaining '(' in stack never got its "))".
         * Each one needs TWO ')' inserted.
         *
         * Example: stack = ['(', '('] → need 2 × 2 = 4 insertions
         *
         * Stack drains as:
         *   pop '(' → insertions += 2
         *   pop '(' → insertions += 2
         */
        while (!stack.isEmpty()) {
            stack.pop();
            insertions += 2; // Each '(' needs "))" → 2 insertions
        }

        return insertions;

    }
}