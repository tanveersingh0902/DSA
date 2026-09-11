package DSA_practice.twoPointers;

public class isSubsequense {
    public static void main(String[] args) {

    }
    public static boolean hii(String s , String t){


        // i tracks how many characters of s we have matched so far
        int i = 0;

        // j scans every character of t
        int j = 0;

        // Walk through t until we either exhaust t or fully match s
        while (i < s.length() && j < t.length()) {

            if (s.charAt(i) == t.charAt(j)) {
                // Characters match — move s pointer forward
                i++;
            }

            // Always advance t pointer regardless of match or not
            j++;
        }

        // If i reached s.length(), all characters of s were matched in order
        return i == s.length();
    }

}
