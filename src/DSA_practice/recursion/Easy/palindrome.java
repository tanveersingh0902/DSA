package DSA_practice.recursion.Easy;

public class palindrome {
    public static void main(String[] args) {
        System.out.println( isPalindrome(121));
    }
    // Step 1: Recursive method to reverse the number
    static int reverseNumber(int num, int rev) {
        // Base Case: if num becomes 0, return the reversed number
        if (num == 0) {
            return rev;
        }
        // Extract last digit and build reversed number
        int lastDigit = num % 10;
        rev = rev * 10 + lastDigit;

        // Recursive call with reduced number
        return reverseNumber(num / 10, rev);
    }

    // Step 2: Check if the number is palindrome
    static boolean isPalindrome(int num) {
        int reversed = reverseNumber(num, 0);
        return num == reversed;
    }

}
