package DSA_practice.binarySearch;

public class infiniteArray {
    public static void main(String[] args) {

        // find the position of an element in an infinite array
        // https://www.geeksforgeeks.org/dsa/find-position-element-sorted-array-infinite-numbers/


        int[] arr = {3,5,7,9,10,98,100,130,140,160,170};
        int target= 10;
        System.out.println(ans(arr, target));

    }
    static int ans(int[] arr , int target){
        // first find the range
        // first start with a box of size 2

        int start = 0;
        int end = 1;

        // condition for the target to lie in the range

        while(target > arr[end]){
            int newStart = end + 1;
            // double the box value
            // end = previous end + size of box * 2
            end = end + (end - start + 1) * 2;
            start = newStart;
        }
        return binarySearch(arr, target , start , end);


    }

    static int binarySearch(int[] arr, int target , int start ,int end){


        while(start<=end){
            int mid = start + (end - start)/2;

            if(arr[mid] == target){
                return mid;
            }
            else if (arr[mid] < target) {
                start = mid +1;
            }
            else{
                end = mid - 1;
            }
        }
        return -1;
    }
}
