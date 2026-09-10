package com.company;

public class CWH_ch7_Methods {

    static int logic(int x , int y){
        int z;
        if(x>y){
            z =x+y;
        }
        else {
            z = (x + y) * 5;
        }
        return z;
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 6;
        int c;
        c = logic(a ,b);
        System.out.println(c);


        // method calling by making an object
        // CWH_ch7_Methods obj = new CWH_ch7_Methods();
        //c = obj.logic(a , b);

        int a1 = 2;
        int b1 = 1;
        int c1;
        c1 = logic(a1 , b1);
        System.out.println(c1);

        int d = logic(4, 5);
        System.out.println(d);
    }
}
