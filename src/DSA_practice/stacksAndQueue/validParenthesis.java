package DSA_practice.stacksAndQueue;

import java.util.Stack;

public class validParenthesis {


    /*
     * Problem: Given a string containing only '(', ')', '{', '}', '[', ']',
     * determine if the input string is valid.
     *
     * A string is valid if:
     *   1. Every opening bracket has a corresponding closing bracket.
     *   2. Brackets are closed in the correct ORDER (most recent first).
     *
     * Approach: Stack-based matching
     *   - Push opening brackets onto the stack.
     *   - For closing brackets, check if the top of the stack is the matching opener.
     *   - At the end, if stack is empty → all brackets matched → valid.
     *
     * Time Complexity : O(n) — one pass through the string
     * Space Complexity: O(n) — stack can hold up to n characters (worst case all openers)
     */

    public boolean isValid(String s) {

        // Stack stores only opening brackets ( '(', '{', '[' )
        Stack<Character> stack = new Stack<>();
        
        // Iterate over every character in the string
        for(char ch : s.toCharArray()){

            // ── CASE 1: Opening bracket ──
            // Push it onto the stack to be matched later
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }

            // ── CASE 2: Closing bracket ──
            else{
                if(ch == ')'){

                    // stack.isEmpty() → no opener waiting → invalid
                    // stack.pop() != '(' → top opener doesn't match → invalid
                    if(stack.isEmpty() || stack.pop() != '(' ){
                        return false;
                    }
                }
                if(ch == '}'){
                    if( stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                }
                if(ch == ']'){
                     if(stack.isEmpty() || stack.pop() != '['){
                         return false;
                     }
                }
            }
        }
        /*
         * Final check:
         * If stack is EMPTY  → all openers were matched → return true
         * If stack is NOT EMPTY → some openers are left unmatched → return false
         *
         * Example: "(((" → stack still has 3 items → false
         * Example: "()"  → stack is empty           → true
         */

        return stack.isEmpty();

        
        
    }
}
