package DSA.bitwise.Bitwise;

public class rangeXOR {
    public static void main(String[] args) {

        // range xor for a till b = xor(b) ^ xor(a-1)

        int a = 3;
        int b = 9;

        int ans = xor(b) ^ xor(a-1);
        System.out.println(ans);


        // only for check , will give time limit exceed for large numbers
        int ans2 = 0;
        for(int i = a; i<=b; i++){
            ans2 ^= i;
        }
        System.out.println(ans2);

    }
    // this will give xor from 0 to a
    static int xor(int a){
        if(a % 4 ==0){      // n % 4 ==0 -> result is n
            return a;
        }
        if(a % 4 == 1){     // n % 4 == 1 -> result is 1
            return 1;
        }
        if(a % 4 == 2){      // n % 4 == 2 -> result is n+1
            return a + 1;
        }
        return 0;             // n % 4 == 3 -> result is 0
    }
}
