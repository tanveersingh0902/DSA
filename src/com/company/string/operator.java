package com.company.string;


import java.util.ArrayList;

public class operator {
    public static void main(String[] args) {

        System.out.println('a' + 'b');

        System.out.println("a" + "b");

        System.out.println('a' + 3);

        System.out.println("a" + 1);   // integer will converted into its wrapper class that will call toString()

        System.out.println((char)('a' + 3));

        System.out.println("Tanveer" + new ArrayList<>());





    }
}
