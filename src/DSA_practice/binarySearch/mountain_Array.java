package DSA_practice.binarySearch;

public class mountain_Array {

    public static void main(String[] args) {

        // find in the mountain array
        // https://leetcode.com/problems/find-in-mountain-array/description/

        // step1. find the peak of mountain
        //step2. check in the increasing part
        // Step3. check in the decreasing part

        int[] arr = {1,2,3,4,5,3,1};
        int target = 3;
        int ans = search(arr , target);
        System.out.println(ans);
    }
    static int search(int[] arr , int target){
        int peak = peak(arr);
        int firstTry = orderBinarySearch(arr , target , 0 , peak);
        if(firstTry != -1){
            return firstTry;
        }
        return orderBinarySearch(arr , target , peak+1, arr.length-1);
    }
    static int peak(int[] arr ){
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(arr[mid] < arr[mid + 1]){
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }
    static int orderBinarySearch(int[] arr , int target , int left , int right){

        boolean isAscending = arr[left] < arr[right];

        while(left <= right){
            int mid = left + (right - left)/2;

            if(arr[mid] == target){
                return mid;
            }
            if(isAscending){
                if(arr[mid] < target){
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
            else {
                if (arr[mid] > target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
