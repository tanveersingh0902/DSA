package DSA.Arrays;

import java.util.Scanner;
import java.util.ArrayList;

public class arrayList {

    public static void main(String[] args){

        // An ArrayList in Java is a resizable array —
        //that means it behaves like a normal array, but it can grow or shrink in size automatically when you add or remove elements.

        Scanner sc = new Scanner(System.in);

        // syntax
    /*    ArrayList<Integer> list = new ArrayList<>(10);

        list.add(85);
        list.add(23);
        list.add(45);
        list.add(31);
        list.add(20);
        list.add(5);


        System.out.println(list);



        //some use of this
        System.out.println(list.contains(85));

        list.set(1, 100);
        System.out.println(list);
        
        list.remove(4);
        System.out.println(list);



        // input
        for (int i=0; i<5; i++){
            list.add(sc.nextInt());
        }
        // output
        for(int i=0; i<5; i++){
            System.out.println(list.get(i));
        }


     */




        //multidimensional Array
        ArrayList<ArrayList<Integer>> list= new ArrayList<>();

        // Initialisation
        for (int i=0; i<3; i++) {
            list.add(new ArrayList<>());
        }

        // add elements
        for (int i=0; i<3; i++){
            for(int j = 0; j<3; j++){
                list.get(i).add(sc.nextInt());
            }
        }
        System.out.println(list);






        










    }
}
