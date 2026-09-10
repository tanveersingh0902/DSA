package DSA.bitwise.Math;

public class newtonRaphson   {

    public static void main(String[] args) {
        System.out.println(sqrt(40));
    }

    static double sqrt(double n){

        // Step 1 : Start with initial guess = n itself
        // Why n? Because √n always lies between 1 and n
        // So n is a valid (though far) starting point
        // Any positive number works — closer the guess, fewer iterations

        double x = n;
        double root;
        while(true){

            // Step 2 : Apply Newton-Raphson formula
            // root = 0.5 * (x + n/x)
            // This is same as → (x + n/x) / 2
            // It averages x and n/x to get a better guess

            // WHY does this work?
            // If x > √n → n/x < √n → their average is CLOSER to √n
            // If x < √n → n/x > √n → their average is CLOSER to √n
            // ALWAYS moves toward √n no matter what! ✅

             root = 0.5 * (x + (n/x));

            // Step 3 : Check stopping condition
            // Math.abs() handles both cases:
            //   root > x → difference is positive
            //   root < x → difference is negative
            // If gap between new root and old x is less than 0.000001
            // → We have converged → answer is precise enough → STOP

            if(Math.abs(root - x) < 1e-6){     // ie-6 == 0.000001
                break;
            }

            // Step 4 : New root becomes next guess
            // Keep improving until precision is achieved
            x = root;
        }
        return root;
    }

}
