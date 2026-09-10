package DSA.bitwise.Bitwise;

public class bitOperations {

    // Get ith bit (0-indexed from right)
    public static int getBit(int num, int i) {
        return (num >> i) & 1;
    }

    // Set ith bit to 1
    public static int setBit(int num, int i) {
        return num | (1 << i);
    }

    // Clear ith bit (set to 0)
    public static int clearBit(int num, int i) {
        return num & ~(1 << i);
    }

    // Toggle ith bit (flip it)
    public static int toggleBit(int num, int i) {
        return num ^ (1 << i);
    }

    // Update ith bit to given value (0 or 1)
    public static int updateBit(int num, int i, int value) {
        // First clear the bit, then set it to value
        int clearMask = ~(1 << i);
        return (num & clearMask) | (value << i);
    }

    // Print binary representation
    public static void printBinary(int num) {
        System.out.println(Integer.toBinaryString(num));
    }

    public static void main(String[] args) {
        int num = 12;  // Binary: 1100

        System.out.println("Original number: " + num);
        System.out.print("Binary: ");
        printBinary(num);
        System.out.println();

        // Get bits
        System.out.println("Bit at position 0: " + getBit(num, 0));  // 0
        System.out.println("Bit at position 2: " + getBit(num, 2));  // 1
        System.out.println("Bit at position 3: " + getBit(num, 3));  // 1
        System.out.println();

        // Set bit
        int result1 = setBit(num, 1);
        System.out.println("After setting bit 1: " + result1);  // 14
        System.out.print("Binary: ");
        printBinary(result1);
        System.out.println();

        // Clear bit
        int result2 = clearBit(num, 2);
        System.out.println("After clearing bit 2: " + result2);  // 8
        System.out.print("Binary: ");
        printBinary(result2);
        System.out.println();

        // Toggle bit
        int result3 = toggleBit(num, 0);
        System.out.println("After toggling bit 0: " + result3);  // 13
        System.out.print("Binary: ");
        printBinary(result3);
        System.out.println();

        // Update bit
        int result4 = updateBit(num, 1, 1);
        System.out.println("After updating bit 1 to 1: " + result4);  // 14
        System.out.print("Binary: ");
        printBinary(result4);
    }
}
