package DSA.Recursion;

public class numberExampleRecursion {

    public static void main(String[] args) {


        // Write a function that takes in a number and prints it
        // print first 5 numbers: 1 2 3 4 5

        print(1);
    }

    static void print(int n){
        // Base condition
        if(n==5){
            System.out.println(5);
            return;
        }
        System.out.println(n);

        // recursive call
        // if you are calling a function again and again, you can treat it as a separate call in the stack

        // This is called tail recursion
        // This is the last function call
        print(n + 1);      // function calling itself
    }
}
