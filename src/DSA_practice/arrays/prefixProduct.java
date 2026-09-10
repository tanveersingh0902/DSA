package DSA_practice.arrays;

// https://leetcode.com/problems/maximum-product-subarray/submissions/1883552447/

public class prefixProduct {

    // left to Right Pass: Calculate running product from left. If we hit 0, reset to 1.
    //This handles cases where the maximum product subarray is on the left side or includes an even number of negatives from the start.
    //Right to Left Pass: Calculate running product from right. If we hit 0, reset to 1.
    //This handles cases where the maximum product subarray is on the right side or when we need to exclude leading negatives.

    static int maxProduct(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }

        int n = arr.length;
        int maxProduct = Integer.MIN_VALUE;

        // left to right prefix product
        int prefixProduct = 1;
        for(int i =0; i< n; i++) {
            prefixProduct *= arr[i];
            maxProduct = Math.max(maxProduct, prefixProduct);

            // reset if we encounter 0
            if (prefixProduct == 0) {
                prefixProduct = 1;
            }
        }
            // Right to left prefix product
            int suffixProduct = 1;
            for (int i = n - 1; i >= 0; i--) {
                suffixProduct *= arr[i];
                maxProduct = Math.max(maxProduct, suffixProduct);

                // Reset if we encounter 0
                if (suffixProduct == 0) {
                    suffixProduct = 1;
                }
            }
            return maxProduct;


    }
}
