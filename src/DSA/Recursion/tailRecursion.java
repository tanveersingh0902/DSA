package DSA.Recursion;

public class tailRecursion {

    // Tail recursive version
    public static int factorialTail(int n, int accumulator) {
        if (n <= 1) {
            return accumulator;
        }
        return factorialTail(n - 1, n * accumulator);  // Last operation
    }

    // Non-tail recursive version (for comparison)
    public static int factorialNonTail(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorialNonTail(n - 1);  // Multiplication happens AFTER return
    }

    public static void main(String[] args) {
        System.out.println(factorialTail(5, 1));     // 120
        System.out.println(factorialNonTail(5));     // 120
    }
}
