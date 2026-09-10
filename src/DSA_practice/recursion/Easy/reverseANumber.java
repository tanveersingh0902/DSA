package DSA_practice.recursion.Easy;

public class reverseANumber {
    public static void main(String[] args) {

        rev1(1234);
        System.out.println(sum);
    }

    static int sum = 0;
    static void rev1(int n){
        if (n == 0){
            return;
        }
        int rem = n % 10;
        sum = sum * 10 + rem;
        rev1(n/10);
    }




}
