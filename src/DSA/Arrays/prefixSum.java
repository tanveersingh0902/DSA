package DSA.Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class prefixSum {

    public static int[] prefixSum(int[] arr){
        int n = arr.length;

        // Create prefix sum array
        int[] prefix = new int[n];

        // First element is same as original array
        prefix[0] = arr[0];

        // Build prefix sum for remaining elements
        for(int i = 1; i < n; i++){
            // current prefix = previous prefix + current element
            prefix[i] = prefix[i-1] + arr[i];
        }
        return prefix;
    }

    public static int rangeSum(int[] prefix , int left , int right){
        // Sum from index left to index right (inclusive)

        if(left == 0){
            // If start form begining
            return prefix[right];
        }
        else {
            // sum[L to R] = sum[0 to R] - sum[0 to L-1]
            return prefix[right] - prefix[left - 1];
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2, 5};
        int[] prefix = prefixSum(arr);    // [ 3,4,8,10,15]

        // Find the sum from index 2 to 4 (elements: 4 ,2, 5)
        int sum = rangeSum(prefix , 2 , 4);
        // sum = prefix[4] - prefix[1] = 15 - 4 = 11
        System.out.println(sum);
    }
}
