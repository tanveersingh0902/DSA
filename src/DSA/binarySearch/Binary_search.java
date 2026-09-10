package DSA.binarySearch;

public class Binary_search {
    public static void main(String[] args) {


    }
    // Iterative approach
    static int binarySearch(int[] arr, int target){
        int left =0;
        int right = arr.length-1;

        while(left<=right){
            int mid = left + (right - left)/2;      // we have done this to avoid the integer overflow

            if(arr[mid] == target){
                return mid;           // target found
            }
            else if (arr[mid] < target) {
                left = mid +1;         // search right half
            }
            else{
                right = mid - 1;       // search left half
            }
        }
        return -1;     // Target not found
    }

    // Recursive Approach
    static int binarySearchRecursive(int[] arr, int target, int left, int right){
        if(left > right){
            return -1;
        }
        int mid = left + (right - left) / 2;

        if(arr[mid] == target){
            return mid;
        }
        else if(arr[mid] < target){
            return binarySearchRecursive(arr,target,mid +1,right);
        }
        else{
            return binarySearchRecursive(arr,target,left,mid-1);
        }
        }

    // Order Agostic Binary Search
    // works for both ascending and descending sorted arrays without knowing the sort order beforehand
    static int BinarySearch(int[] arr, int target){
        int left=0;
        int right= arr.length-1;

        boolean isAscending = arr[left] < arr[right];   // Determine if array is ascending or descending

        while(left <= right){
            int mid = left + (right - left)/2;

            if(arr[mid] == target){
                return mid;   // target found
            }
            if(isAscending){   // ascending order logic
                if(arr[mid] < target){
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
            else {                // descending order logic(reversed)
                if (arr[mid] > target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;  // not found

    }
}
