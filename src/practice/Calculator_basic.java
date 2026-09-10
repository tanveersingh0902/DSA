package practice;

import java.util.Scanner;

public class Calculator_basic {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

       char choice;
       do {

           System.out.println("Enter first number");
           long num1 = sc.nextInt();
           System.out.println("Enter second number");
           long num2 = sc.nextInt();
           System.out.println("Enter operator (+,-,*,/)");
           char operator = sc.next().charAt(0);

           switch (operator) {
               case '+' -> System.out.println("Result " + (num1 + num2));
               case '-' -> System.out.println("Result " + (num1 - num2));
               case '*' -> System.out.println("Result " + (num1 * num2));
               case '/' -> {
                   if (num2 != 0) {
                       System.out.println("Result  " + (num1 / num2));
                   } else {
                       System.out.println("Can not divide by 0");
                   }
               }
               default -> System.out.println("Invalid operator");
           }
           System.out.println("Do you want to perform another calculation (y/n): ");
           choice = sc.next().charAt(0);
       } while (choice =='y' || choice=='Y');

        System.out.println("Calculator closed thank you ");










    }
}
