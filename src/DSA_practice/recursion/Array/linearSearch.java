package DSA_practice.recursion.Array;

import java.util.ArrayList;

public class linearSearch {
    public static void main(String[] args) {
        int[] arr = {1,4,5,6,8,8,9,6,14};
//        System.out.println(linear(arr, 1 , 0));
////
//        System.out.println(find(arr , 8 , 0));
////
//        findAll(arr,8, 0);
//        System.out.println(list);
//
        ArrayList<Integer> ans = findAllIndex(arr, 8 , 0 , new ArrayList<>());
        System.out.println(ans);

    }

    static boolean linear(int[] arr , int target , int index){

        if(index == arr.length){
            return false;
        }
        return arr[index] == target || linear(arr, target, index+1);
    }

    static int find(int[] arr , int target , int index){

        if(index == arr.length){
            return -1;
        }
        if(arr[index] == target){
            return index;
        }
        return find(arr ,target, index+1);
    }

    static ArrayList<Integer> list = new ArrayList<>();
    static void findAll(int[] arr , int target , int index){

        if(index == arr.length){
            return;
        }
        if(arr[index] == target){
            list.add(index);
        }
        findAll(arr , target , index+1);

    }

    static ArrayList<Integer> findAllIndex(int[] arr , int target, int index , ArrayList<Integer> list){
        if(index == arr.length){
            return list;
        }
        if(arr[index] == target){
            list.add(index);
        }
        return findAllIndex(arr , target , index+1 , list);
    }

}
