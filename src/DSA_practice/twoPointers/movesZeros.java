package DSA_practice.twoPointers;
import java.util.Arrays;
import java.util.Arrays;

public class movesZeros {

    public static void main(String[] args) {
        int[] arr = {0 , 1 , 2 , 0 , 5 , 8};
        hello(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void hello(int[] nums) {

        // j = slow pointer: marks the position where
        //     the next non-zero element should land
        int j = 0;

        // Phase 1: scan with i (fast pointer)
        // Copy every non-zero element to position j
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {
                // Place non-zero value at the front section
                nums[j] = nums[i];
                j++; // advance slow pointer
            }
            // if nums[i] == 0, do nothing — i moves on, j stays
        }

        // Phase 2: fill remaining positions (j to end) with zeros
        // Everything from j onward is now "leftover garbage"
        while (j < nums.length) {
            nums[j] = 0;
            j++;
        }
    }

}

