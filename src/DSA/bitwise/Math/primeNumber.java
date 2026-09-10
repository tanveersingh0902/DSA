package DSA.bitwise.Math;

public class primeNumber {
    public static void main(String[] args) {
         int n = 20;
        for(int i = 1; i<=n; i++){
            System.out.println(i + " " + isPrime(i));
        }

    }

    static boolean isPrime(int n){
        if(n <= 1){
            return false;
        }

        int c = 2;
        while(c * c <= n){
            if(n % c == 0){
                return false;
            }
            c++;
        }
        return true;
    }
}


//| n  | √n  | We check up to |
//        |----|-----|----------------|
//        | 36 | 6   | c = 2,3,4,5,6  |
//        | 17 | ~4.1| c = 2,3,4      |