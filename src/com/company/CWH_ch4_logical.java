package com.company;

public class CWH_ch4_logical {
    public static void main(String[] args) {

        // Logical And
        boolean a = true;
        boolean b = false;
        if (a && b){
            System.out.println("Y");
        }
        else{
            System.out.println("N");
        }

        // Logical or
        boolean a1 = true;
        boolean b1 = false;
        if (a1 || b1){
            System.out.println("Y");
        }
        else{
            System.out.println("N");
        }

        // Logical Not
        boolean a2 = true;
        boolean b2 = false;
        System.out.print("Not(a2) is ");
        System.out.println(!a2);
        System.out.print("Not(b2) is ");
        System.out.println(!b2);




    }
}
