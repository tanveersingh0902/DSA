package DSA.bitwise.Bitwise;
//
//n & (n-1) removes the rightmost set bit
//     * Count how many times we can do this until n becomes 0
//        *
//        * Example: n = 13 (1101)
//        * Step 1: 1101 & 1100 = 1100 (removed rightmost 1)
//        * Step 2: 1100 & 1011 = 1000 (removed another 1)
//        * Step 3: 1000 & 0111 = 0000 (removed last 1)
//        * Count = 3

public class count_setBIt {
    public static void main(String[] args) {

        int n = 45;
        System.out.println(Integer.toBinaryString(n));    // convert into binary

        System.out.println(setBit(n));
        System.out.println(brian(n));

    }

    private static int setBit(int n) {

        int count = 0;

        while (n > 0) {
            count++;
            n -= (n & (-n));
        }
        return count;
    }

    // Brian Kernighan's Algorithm (BEST)
    private static int brian(int n){
        int count = 0;
        while( n > 0){
            n = n & (n-1);
            count++;
        }

        return count;
    }

}
