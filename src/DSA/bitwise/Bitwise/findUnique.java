package DSA.bitwise.Bitwise;

public class findUnique {

    public static void main(String[] args) {

        int[] arr = {2,3,2,2,7,7,8,7,8,8};
        System.out.println(ans(arr));
    }

    private static int ans(int[] arr){

        int unique = 0;

        for(int n:arr){
            unique ^= n;
        }
        return unique;
    }

}
