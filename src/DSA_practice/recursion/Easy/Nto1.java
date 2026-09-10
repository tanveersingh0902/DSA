package DSA_practice.recursion.Easy;

public class Nto1 {
    public static void main(String[] args) {

        //funBoth(5);
        concept(5);
    }

    static void concept(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
       // concept(n--);   // n-- vs --n
        concept(--n);
    }

    static void fun(int n){      // for 5 to 1
        if(n == 0){
            return;
        }
        System.out.println(n);
        fun(n-1);
    }

    static void funcrev(int n){     // for 1 to 5
        if(n==0){
            return;
        }
        funcrev(n-1);
        System.out.println(n);
    }

    static  void funBoth(int n){     // for both order
        if(n==0){
            return;
        }

        System.out.println(n);
        funBoth(n-1);
        System.out.println(n);
    }
}
