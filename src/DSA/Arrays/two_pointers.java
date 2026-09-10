package DSA.Arrays;

public class  two_pointers {

    /**
     * PATTERN 1: Opposite Direction (Two Ends)
     * Use when: Array is sorted, finding pairs/triplets
     * Time: O(n), Space: O(1)
     */
//    public void oppositeDirectionPointers(int[] arr) {
//        int left = 0;
//        int right = arr.length - 1;
//
//        while (left < right) {
//            // Process current elements
//            // arr[left] and arr[right]
//
//            // Move pointers based on condition
//            if ( some condition ) {
//                left++;
//            } else if ( some other condition ) {
//                right--;
//            } else {
//                // Both pointers can move
//                left++;
//                right--;
//            }
//        }
//    }

    /**
     * PATTERN 2: Same Direction (Fast & Slow)
     * Use when: In-place operations, removing/replacing elements
     * Time: O(n), Space: O(1)
     */
/*    public int sameDirectionTemplate(int[] arr) {
        int slow = 0;

        for (int fast = 0; fast < arr.length; fast++) {
            if ( condition to keep element) {
                arr[slow] = arr[fast];
                slow++;
            }
        }

        return slow; // New length

 */
    }



