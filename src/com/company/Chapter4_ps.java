package com.company;
import java.util.Scanner;

public class Chapter4_ps {
    public static void main(String[] args) {

        // question 1

    /*    int a = 10;
        if (a==11){
            System.out.println("I am 11");
        }
        else{
            System.out.println("I am not 11");
        } */

        // Question 2
    /*    Scanner sc = new Scanner(System.in);
        System.out.println("Marks in maths");
        int a = sc.nextInt();
        System.out.println("Marks in english");
        int b = sc.nextInt();
        System.out.println("Marks in science");
        int c = sc.nextInt();

        float percent =(a + b + c)/3.0f;
        System.out.println("Your overall percentage is:" + percent);

        if (percent>=40 && a>=33 && b>=33 && c>=33){
            System.out.println("You have been promoted");
        }
        else{
            System.out.println("Sorry, you have not been promoted");
        }

     */

        // Question 3

    /*     Scanner sc = new Scanner(System.in);
        double tax = 0;
        System.out.println("Enter your income");
        double income = sc.nextDouble();

        if (income<2.5){
            tax = tax + 0;
        }
        else if (income>=2.5 && income<=5) {
            tax = tax + 0.05 * (income - 2.5);
        }
        else if (income>5 && income<=10) {
            tax = tax + 0.05 * (5 - 2.5);
            tax = tax + 0.2 * ( income - 5);
        }
        else if (income>10){
            tax = tax + 0.05 * (5 - 2.5);
            tax = tax + 0.2 * (10-5);
            tax = tax + 0.3 * (income - 10);
        }
        System.out.println("Income tax paid by an employee:" + tax);

     */


        // Question 4

    /*    Scanner sc = new Scanner(System.in);
        System.out.println("Type your number");
        int day = sc.nextInt();

        switch (day) {
            case 1 -> System.out.println("Monday");
            case 2 -> System.out.println("Tuesday");
            case 3 -> System.out.println("Wednesday");
            case 4 -> System.out.println("Thursday");
            case 5 -> System.out.println("Friday");
            case 6 -> System.out.println("Saturday");
            case 7 -> System.out.println("Sunday");
        }

     */

        // Question 5

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the year");
        int year = sc.nextInt();

        if ((year % 4) == 0) {
            System.out.println("It is a leap year");
        }
        else {
            System.out.println("It is not a leap year");
        }



        // Question 6

    /*    Scanner sc = new Scanner(System.in);
        System.out.println("Enter the url");
        String website = sc.nextLine();

        if (website.endsWith(".com")) {
            System.out.println("This is a Commercial website");
        }
        else if (website.endsWith(".org")){
            System.out.println("This is an Organisation website");
        }
        else if (website.endsWith(".in")){
            System.out.println("This is an Indian website");
        }

     */



    }
}
