package DSA.bitwise.Math;

public class GCD_LCM {
    public static void main(String[] args) {

        System.out.println(gcd(54 , 24));

        System.out.println(lcm(54 , 24));

    }

    // using euclidean algorithm
//    The Euclidean Algorithm is an efficient method to find the GCD (Greatest Common Divisor) of two numbers.
//    It was described by Greek mathematician Euclid around 300 BC.
//    GCD Definition: The largest positive integer that divides both numbers without leaving a remainder.

    static int gcd(int a , int b){

        // Base case: if a becomes 0, return b

        if(a==0){
            return b;
        }
        // Recursive case: GCD(a, b) = GCD(b % a, a)
        // This swaps the parameters compared to traditional approach
        return gcd(b%a , a);
    }

    // LCM using GCD relationship
    static int lcm(int a, int b){

        // Formula: LCM(a, b) = (a × b) / GCD(a, b)

        return a * b / gcd(a,b);

        // return (a / gcd(a , b)) * b;   // prevents overflow error
    }
}

// ## 🔍 DRY RUN EXAMPLES
//
// ### **DRY RUN 1: GCD(54, 24)**
//        ```
// Call Stack Visualization:
//
// Call 1: gcd(54, 24)
// a = 54, b = 24
// a ≠ 0, so continue
// Calculate: b % a = 24 % 54 = 24
// Return gcd(24, 54)
//
// Call 2: gcd(24, 54)
// a = 24, b = 54
// a ≠ 0, so continue
// Calculate: b % a = 54 % 24 = 6
// Return gcd(6, 24)
//
// Call 3: gcd(6, 24)
// a = 6, b = 24
// a ≠ 0, so continue
// Calculate: b % a = 24 % 6 = 0
// Return gcd(0, 6)
//
// Call 4: gcd(0, 6)
// a = 0 ✅ BASE CASE!
// Return b = 6

//** Now calculate LCM:**
//        ```
// LCM(54, 24) = (54 × 24) / GCD(54, 24)
//            = 1296 / 6
//                    = 216
//
//                    ✅ RESULT: LCM(54, 24) = 216
//        ```
