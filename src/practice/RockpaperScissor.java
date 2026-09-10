package practice;
import java.util.Scanner;
import java.util.Random;

public class RockpaperScissor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 0 for Rock\nEnter 1 for Paper\nEnter 2 for Scissor");
        int humanInput = sc.nextInt();


        Random ran = new Random();
        int computerInput = ran.nextInt(3);

        if (humanInput<=2) {
             System.out.println("Game starts");

            if (humanInput == computerInput) {
                System.out.println("Game draws");
            } else if (humanInput == 0 && computerInput == 2 ||
                    humanInput == 1 && computerInput == 0 ||
                    humanInput == 2 && computerInput == 1) {
                System.out.println("You win");
            } else {
                System.out.println("You lost");
            }
            System.out.println("Computer chose");
            switch (computerInput) {
                case 0 -> System.out.println("Rock");
                case 1 -> System.out.println("Paper");
                case 2 -> System.out.println("Scissor");
            }
        }
        else {
            System.out.println("Invalid user input");
        }
    }
}
