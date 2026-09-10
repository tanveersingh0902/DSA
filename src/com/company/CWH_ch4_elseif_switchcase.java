package com.company;
import java.util.Scanner;
public class CWH_ch4_elseif_switchcase {
    public static void main(String[] args) {
        System.out.println("Enter Your Age");
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();

      /*  if (age>56){
            System.out.println("You are experienced");
        }
        else if(age>46){
            System.out.println("You are semi-experienced");
        }
        else if(age>36){
            System.out.println("You are semi-semi-experienced");
        }
        else{
            System.out.println("You are not experienced");
        } */

        switch (age) {
            case 18:
                System.out.println("You are going to become an adult");
                break;
            case 23:
                System.out.println("You are going to join a job");
                break;
            case 60:
                System.out.println("You are going to get retired");
                break;
            default:
                System.out.println("Enjoy your life");
                break;
        }







    }
}
