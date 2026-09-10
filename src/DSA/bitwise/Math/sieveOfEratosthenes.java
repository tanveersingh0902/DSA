package DSA.bitwise.Math;

public class sieveOfEratosthenes {
    public static void main(String[] args) {

        int n = 37;
        boolean[] primes = new boolean[n + 1];
        sieve(primes , n);
    }

    // false in array means number is prime
    // false → Prime  |  true → Composite (NOT prime)

    static void sieve(boolean[] primes , int n) {

        // Step 1: Outer loop runs from 2 to √n
        // No need to go beyond √n (same square root logic as before)

        for(int i = 2; i*i <=n; i++){

            // If primes[i] is false → i is PRIME
            // Mark all multiples of i as composite (true)

            if (!primes[i]){

                // Step 2: Inner loop starts from i*2 (not i*i)
                // Marks every multiple of i as true (composite)

                for(int j = i*2; j<=n ; j+=i){
                    primes[j] = true;
                }
            }
        }
        for(int i = 2; i<=n; i++){
            if(!primes[i]){
                System.out.print(i + " ");
            }
        }

    }
}
