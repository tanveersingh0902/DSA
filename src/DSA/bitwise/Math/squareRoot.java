package DSA.bitwise.Math;

public class squareRoot {
    public static void main(String[] args) {

        int n = 40;
        int p = 3;      // precision - how many decimal number

        System.out.println(sqrt(n , p));
        System.out.printf("%.3f" , sqrt(n , p));

    }

    static double sqrt(int n , int p){

        int s = 0;
        int e = n;

        double root = 0.0;

        // ✅ PHASE 1 : Binary Search for INTEGER part of square root

        while (s<=e){
            int m = s + (e-s) / 2;

            // Perfect square found → return immediately

            if(m*m == n){
                return m;
            }

            // m is too large → search left half

            if(m * m > n){
                e = m - 1;
            }

            // m is too small → search right half

            else {
                s = m + 1;
                root = m;
            }
        }
        // ✅ PHASE 2 : Extend decimal places one digit at a time

        double incr = 0.1;   // start with 1 decimal place

        // Keep adding incr until root*root exceeds n

        for(int i = 0; i< p; i++){
            while (root * root <=n){
                root += incr;
            }
            // We went one step too far → step back

            root -= incr;

            // Shrink increment for next decimal place
            incr /=10;
        }

        return root;

    }

}
