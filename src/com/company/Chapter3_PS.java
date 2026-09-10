package com.company;

public class Chapter3_PS {
    public static void main(String[] args) {

        // Question 1
        String name = "SAHIB";
        name = name.toLowerCase();
        System.out.println(name);

        // Question 2
        String text = "Hello my name is sahib";
        System.out.println(text.replace(" ","_"));

        // Question3
        String letter = "Dear <|name|>, Thanks a lot ";
        letter = letter.replace("<|name|>", "Sahib");
        System.out.println(letter);

        // Question 4
        String space = "This string contain   double and triple  space";
        System.out.println(space.indexOf("  "));
        System.out.println(space.indexOf("   "));

        // Question 5
        String myLetter = "Dear Harry,\n\tThis java course is nice.\n\tThanks";
        System.out.println(myLetter);




    }
}
