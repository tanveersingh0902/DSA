package practice;

import java.util.Scanner;

public class Area {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

        System.out.println("Choose a shape to calculate area");
        System.out.println("1 : Rectangle");
        System.out.println("2 : Square");
        System.out.println("3 : Circle");
        System.out.println("4 : Triangle");
        System.out.println("Enter your choice (1-4)");
        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.println("Enter the length of rectangle");
                double length = sc.nextDouble();
                System.out.println("Enter the breath of rectangle");
                double breadth = sc.nextDouble();
                double area = length * breadth;
                System.out.println("Area of rectangle: " + area);
            }

            case 2 -> {
                System.out.println("Enter the side of Square");
                double side = sc.nextDouble();
                double area = side * side;
                System.out.println("Area of square: " + area);
            }

            case 3 -> {
                System.out.println("Enter the radius of circle");
                double radius = sc.nextDouble();
                double area = Math.PI * radius * radius;
                System.out.println("Area of circle: " + area);
            }

            case 4 -> {
                System.out.println("Enter the height of triangle");
                double height = sc.nextDouble();
                System.out.println("Enter the base of triangle");
                double base = sc.nextDouble();
                double area = 0.5 * base * height;
                System.out.println("Area of triangle: " + area);
            }
            default -> System.out.println("Invalid choice");
        }





    }
}
