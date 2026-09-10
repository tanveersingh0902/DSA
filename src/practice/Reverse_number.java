package practice;

import java.util.Scanner;

public class Reverse_number {
    public static void main(String[] args) {

        System.out.println("Enter the number");
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int reverse = 0;
        while (num != 0) {

            int lastDigit = num % 10;
            reverse = reverse * 10 + lastDigit;
            num = num / 10;
        }
        System.out.println("The reversed number is: " + reverse);

    }
}
