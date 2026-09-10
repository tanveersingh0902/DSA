package com.company;
import java.util.Scanner;

public class P_1_percentcalculate {
    public static void main(String[] args) {
        int TotalMarks = 100;
        Scanner sc = new Scanner(System.in);
        System.out.println("Marks in English");
        int a = sc.nextInt();
        System.out.println("Marks in Maths");
        int b = sc.nextInt();
        System.out.println("Marks in Science");
        int c = sc.nextInt();
        System.out.println("Marks in Hindi");
        int d = sc.nextInt();
        System.out.println("Marks in Sst");
        int e = sc.nextInt();
        double percentage = (a+b+c+d+e)/5.0;
        System.out.println("The Percentage of all subject");
        System.out.println(percentage);










    }
}
