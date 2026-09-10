package DSA.bitwise.Bitwise;

public class powerOf2 {
    public static void main(String[] args) {

//   Check if a number is a power of 2 using bit manipulation
//   Key Concept:
//   A power of 2 has exactly ONE bit set in binary
//   When we do n & (n-1), it removes the rightmost set bit
//   If n is a power of 2, removing that one bit gives 0

        int n = 8;
        boolean ans = (n > 0) && (n  & (n-1)) == 0;
        System.out.println(ans);
    }
}
