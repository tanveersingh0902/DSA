package DSA.bitwise.Bitwise;

public class singleNumber {


//    every number is appearing 3 times and 1 number is appearing once find that number from bit manipulation
//    * Finds the number that appears once when all other numbers appear 3 times
//     * Uses bit manipulation to solve in O(n) time and O(1) space

    public static int findSingleNumber(int[] nums){

        int result = 0;  // This will store our final answer

        // check each bit position (0 to 31 for 32-bit integer)
        for(int i = 0; i< 32; i++){
            int count = 0;    //  count how many number numbers have bit i set to 1

            for(int num: nums) {

               // Check if bit at position 'i' is set in current number
                // (num & (1 << i)) creates a mask with 1 at position i
                // If the result is non-zero, bit i is set in num

                if((num & (1 << i)) !=0){
                    count++;
                }
            }

            // if count is not divisible by 3
            // the unique number has this bit set

            if(count % 3 != 0){

                // Set bit 'i' in result using OR operation
                // (1 << i) creates a number with only bit i set
                // result |= sets that bit in our answer

                result |= (1 << i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr ={2 ,2, 3, 2, 7, 7, 8, 7, 8, 8};
        System.out.println(findSingleNumber(arr));
    }

   }
