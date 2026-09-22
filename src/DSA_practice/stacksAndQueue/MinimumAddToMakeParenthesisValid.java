package DSA_practice.stacksAndQueue;

import java.util.Stack;

public class MinimumAddToMakeParenthesisValid {
    /**
     * APPROACH: Stack-based
     *
     * Rule:
     *   - If we see ')' AND top of stack is '(' → they MATCH → pop the '('
     *   - Otherwise → push the character (it's unmatched for now)
     *
     * At the end, stack holds ALL unmatched brackets.
     * stack.size() = minimum additions needed to make string valid.
     *
     * Time:  O(n) — single pass through the string
     * Space: O(n) — stack can hold at most n characters
     */
    public int minAddToMakeValid(String s) {

        // Stack stores only UNMATCHED parentheses
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c == ')') {
                // Check if there's a matching '(' at top of stack
                if (!stack.isEmpty() && stack.peek() == '(') {
                    // ✅ Match found! Cancel them out → pop the '('
                    stack.pop();
                } else {
                    // ❌ No match available → this ')' is unmatched → push it
                    stack.push(c);
                }
            } else {
                // c == '('
                // Always push '(' — we don't know yet if ')' will come later
                stack.push(c);
            }
        }

        // Everything left in stack is UNMATCHED
        // Each unmatched '(' needs one ')' added
        // Each unmatched ')' needs one '(' added
        return stack.size();
    }

    public int minAddToMake(String s){

        int open  = 0;  // Counts unmatched '(' → each needs a ')' added at end
        int close = 0;  // Counts unmatched ')' → each needed a '(' before it

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);  // O(1) direct read, no extra array created

            if (c == '(') {
                // --------------------------------------------------
                // Found '(' → we don't know yet if ')' will come
                // So mark it as "pending/unmatched" for now
                // --------------------------------------------------
                open++;

            } else {   // c == ')'

                if (open > 0) {
                    // --------------------------------------------------
                    // A previous '(' is AVAILABLE to match this ')'
                    // → Perfect pair found! Cancel one open bracket
                    // --------------------------------------------------
                    open--;

                } else {
                    // --------------------------------------------------
                    // No '(' available to match this ')'
                    // → This ')' is permanently unmatched
                    // → We need to INSERT a '(' before it
                    // --------------------------------------------------
                    close++;
                }
            }
        }

        //  open  → how many '(' never found their ')'  → add ')' for each
        //  close → how many ')' never had a '(' before → add '(' for each
        //  Total insertions needed = open + close
        return open + close;
    }


}
