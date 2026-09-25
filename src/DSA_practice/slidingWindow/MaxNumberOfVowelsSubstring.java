package DSA_practice.slidingWindow;

public class MaxNumberOfVowelsSubstring {
    public int maxVowels(String s, int k) {

        int n = s.length();

        // ✅ OPTIMIZATION 1: Convert to char array ONCE
        // chars[i] is faster than s.charAt(i) because:
        // charAt() does internal bounds checking every call
        // Array access is direct memory lookup — no overhead
        char[] chars = s.toCharArray();

        // ✅ OPTIMIZATION 2: boolean array for vowel lookup
        // Size 128 covers all ASCII characters
        // Direct index lookup: isVowel['a'] → O(1), no hashing, no comparison
        // Faster than: HashSet | String.indexOf() | switch | if-else chain
        boolean[] isVowel = new boolean[128];
        isVowel['a'] = true;
        isVowel['e'] = true;
        isVowel['i'] = true;
        isVowel['o'] = true;
        isVowel['u'] = true;

        // Phase 1: Count vowels in first window [0...k-1]
        int windowVowels = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel[chars[i]]) {
                windowVowels++;
            }
        }

        int maxVowels = windowVowels;

        // ✅ OPTIMIZATION 3: Early Termination
        // k vowels in k characters = 100% vowels = MAXIMUM POSSIBLE
        // No need to check further → return immediately!
        if (maxVowels == k) return k;

        // Phase 2: Slide window from index k to n-1
        for (int i = k; i < n; i++) {

            // Add incoming character (right side of window)
            if (isVowel[chars[i]]) windowVowels++;

            // Remove outgoing character (left side of window)
            if (isVowel[chars[i - k]]) windowVowels--;

            // ✅ OPTIMIZATION 4: Direct if instead of Math.max()
            // Saves method call overhead × n iterations
            if (windowVowels > maxVowels) {
                maxVowels = windowVowels;
            }

            // ✅ OPTIMIZATION 3 (again): Early Termination inside loop
            // If we hit k vowels mid-slide, return immediately
            if (maxVowels == k) return k;
        }

        return maxVowels;
    }
}
