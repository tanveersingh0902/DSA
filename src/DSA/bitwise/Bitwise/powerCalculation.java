package DSA.bitwise.Bitwise;

public class powerCalculation {

    public static int Power(int base , int power) {

        int ans = 1;

        // process each bit of power from right to left
        // Continue until all bits are processed (power becomes 0)

        while (power > 0) {

            // Check if the rightmost bit of power is 1
            // (power & 1) extracts the last bit
            // If last bit is 1, we need to multiply ans by current base

            if ((power & 1) == 1) {
                ans *= base;
            }

            // Square the base for the next bit position
            // This prepares base for the next power of 2
            // base → base^2 → base^4 → base^8 → ...

            base *= base;

            // Right shift power by 1 to process the next bit
            // This is equivalent to power = power / 2
            // Removes the rightmost bit we just processed

            power = power >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {

        int result = Power(3 , 6);
        System.out.println(result);
    }
}
