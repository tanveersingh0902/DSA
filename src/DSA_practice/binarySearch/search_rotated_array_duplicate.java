package DSA_practice.binarySearch;

// Search in rotated array with duplicates elements

public class search_rotated_array_duplicate {


        public static void main(String[] args) {
            int[] nums = {2, 5, 6, 0, 0, 1, 2};
            int target = 2;
            boolean ans = search(nums, target);
            System.out.println(ans);
        }

        static boolean search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                // Target found
                if (nums[mid] == target) {
                    return true;
                }

                // CORRECTED: Check before skipping!
                if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                    // Check left boundary before skipping
                    if (nums[left] == target) {
                        return true;
                    }
                    // Check right boundary before skipping
                    if (nums[right] == target) {
                        return true;
                    }
                    // Now safe to skip
                    left++;
                    right--;
                    continue;
                }

                // Check if left half is sorted
                if (nums[left] <= nums[mid]) {
                    if (target >= nums[left] && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                // Right half is sorted
                else {
                    if (target > nums[mid] && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }

            return false;
        }
    }




