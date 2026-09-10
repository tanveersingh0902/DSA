package DSA.bitwise.Bitwise;

public class magicNumber {
    public static void main(String[] args) {

        int n = 6;

        int ans = 0;   // This will store our final magic number
        int base = 5;  // Start with base = 5

        // Process each bit of n from right to left
        // Continue until all bits are processed (n becomes 0)

        while (n > 0){

            // Step 1: Extract the rightmost bit of n
            // (n & 1) gives 1 if last bit is set, 0 if not set
            // This tells us whether to include current power of 5

            int lastDigit = n & 1;

            // Step 2: Right shift n by 1 position
            // This removes the rightmost bit and prepares next bit for processing
            // Example: 110 >> 1 = 11, then 11 >> 1 = 1, then 1 >> 1 = 0

            n = n>>1;

            // Step 3: Add to answer if bit is 1
            // lastDigit is either 0 or 1
            // If 1: adds current power of 5 (base)
            // If 0: adds 0 (doesn't contribute)

            ans += lastDigit * base;


            // Step 4: Move to next power of 5
            // 5 → 25 → 125 → 625 → ...
            // (5^1 → 5^2 → 5^3 → 5^4 → ...)

            base = base * 5;
        }

        System.out.println(ans);
    }
}
//
//Visual Breakdown for n = 6
//        ```
//n = 6 (Binary: 110)
//
//Position:     2    1    0   (bit positions from right)
//Binary:       1    1    0
//Power of 5:   5³   5²   5¹
//Value:       125   25    5
//Multiply:     1×   1×   0×
//        125 + 25 +  0  = 150
//
//Reading from RIGHT to LEFT:
//Bit 0: 0 → 0 × 5¹  = 0 × 5   = 0
//Bit 1: 1 → 1 × 5²  = 1 × 25  = 25
//Bit 2: 1 → 1 × 5³  = 1 × 125 = 125
//        ----
//Total:                         150
//
