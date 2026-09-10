package com.company.string;

import java.util.Arrays;

public class CWH_ch3_stringMethod {
    public static void main(String[] args) {


        String name = "Tanveer";
        System.out.println(name);

        System.out.println(Arrays.toString(name.toCharArray()));

        int value = name.length();
        System.out.println(value);

        String lString = name.toLowerCase();
        System.out.println(lString);

        String uString = name.toUpperCase();
        System.out.println(uString);

        String nonTrimmedString = "    Tanveer      ";
        System.out.println(nonTrimmedString);
        String trimmedString = nonTrimmedString.trim();
        System.out.println(trimmedString);

        System.out.println(name.substring(2));
        System.out.println(name.substring(1,4));

        System.out.println(name.replace('e','o'));
        System.out.println(name.replace("veer","heer"));

        System.out.println(name.startsWith("Ta"));
        System.out.println(name.endsWith("r"));

        System.out.println(name.charAt(2));

        String modifiedName = "Tanveereereer";
        System.out.println(modifiedName.indexOf("eer"));
        System.out.println(modifiedName.indexOf("eer",4));
        System.out.println(modifiedName.lastIndexOf("er", 9));

        System.out.println(name.equals("Tanveer"));
        System.out.println(name.equalsIgnoreCase("tanVEer"));

        // Escape sequence character
        System.out.println("I am escape sequence\tdouble quote");    // \t for tab space
        System.out.println("I am escape sequence\ndouble quote");    // \n for new line
        System.out.println("I am escape sequence\'double quote");    // \' for singe quote
        System.out.println("I am escape sequence\\double quote");    // \\ for backlash







    }
}
