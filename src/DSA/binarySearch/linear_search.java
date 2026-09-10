package DSA.binarySearch;

public class linear_search {
    public static void main(String[] args) {

        int[] arr={1,3,2,4,5,7,6,9,8,10,25,12};
        int target = 5;
        int ans = linearSearch(arr,target);
        System.out.println(ans);


    }


    // Search in the array , return the index if item found
    // otherwise if not found return -1

    static int linearSearch(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)  {
                return i;
            }
        }
        return -1;
    }
}
