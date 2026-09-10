package DSA.bitwise.Math;

import java.util.ArrayList;

public class factors {
    public static void main(String[] args) {

        factors3(20);
    }

    // o(N)
    static void factors1(int n){
        for(int i = 1; i<=n; i++){
            if(n % i == 0){
                System.out.println(i + " ");
            }
        }
    }

    // o (sqrt(n))
    static void factors2(int n){

        // loop only till square root of n
        for(int i = 1; i<=Math.sqrt(n); i++){

            // Check if i is a factor of n

            if(n % i == 0){

                // If i equals n/i, (perfect square case
                // Print it only once to avoid duplication

                if(n/i == i){
                    System.out.println(i + " ");
                }
                else{

                    // Print both i and its complementary factor n/i
                    System.out.print(i + " " + n/i + " ");
                }

            }
        }
    }

    // Both time and space will be o (sqrt(n))
    static void factors3(int n){

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i<=Math.sqrt(n); i++){
            if(n % i == 0){
                if(n/i == i){

                    // If i equals n/i (perfect square case)

                    System.out.println(i + " ");
                }
                else{
                    System.out.print(i + " ");

                    // Store larger factor (n/i) in list for later
                    list.add(n/i);
                }
            }
        }

        // Print larger factors in descending order
        // This ensures overall ascending order of all factors
        for(int i = list.size() - 1; i>=0; i--){
            System.out.print(list.get(i) + " ");
        }

    }
}
