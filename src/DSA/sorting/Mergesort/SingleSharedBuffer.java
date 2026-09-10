package DSA.sorting.Mergesort;

import java.util.Arrays;

public class SingleSharedBuffer {

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sortArray(int[] nums) {
        // Allocate the auxiliary buffer ONCE, here, not inside recursion.
        // This is what keeps total extra space at O(n) instead of
        // O(n) allocations happening repeatedly across every merge call.
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
    }

    // ----- Recursive divide step -----
    private static void mergeSort(int[] arr, int low, int high, int[] temp) {
        // Base case: a subarray of size 0 or 1 is already sorted.
        // low >= high covers both low == high (1 element) and
        // low > high (shouldn't normally happen, but safe).
        if (low >= high) {
            return;
        }
        // Avoid (low + high) / 2 to prevent integer overflow on large arrays.
        int mid = low + (high - low) / 2;

        mergeSort(arr, low, mid, temp);             // sort left half [low, mid]
        mergeSort(arr, mid + 1, high, temp);     // sort right half [mid+1, high]

        merge(arr, low, mid, high, temp);           // combine the two sorted halves
    }


    // ----- Merge step: combines two sorted halves into one sorted range -----
    private static void merge(int[] arr, int low, int mid, int high, int[] temp) {
        int i = low;        // pointer into left half  [low, mid]
        int j = mid + 1;     // pointer into right half [mid+1, high]
        int k = low;           // write pointer into temp — starts at "low" so temp
                                // lines up with arr's real indices (no offset math needed later)

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= high) {
            temp[k++] = arr[j++];
        }
        // Copy the merged, sorted range back into the original array.
         for (int l = low; l <= high; l++) {
            arr[l] = temp[l];
        }
    }
}
