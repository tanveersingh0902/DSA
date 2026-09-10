package practice;

import java.util.Scanner;

// Approach
// 1 - Number of lines = Number of rows = Number of times outer loop will run
// 2 - Identify for every row number , how many column are there , types of element in column
// 3 - What do you need to print

public class Pattern_Printing {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Rectangle pattern

//        System.out.println("Enter the rows");
//        int n = sc.nextInt();
//        System.out.println("Enter the columns");
//        int m = sc.nextInt();
//
//        for (int i = 0; i<n; i++){
//            for (int j=0; j<m; j++) {
//                System.out.print("* ");
//            }
//            System.out.println();
//        }



        // Number square

    /*    System.out.println("Enter n");
        int n = sc.nextInt();

        for (int i = 1; i<=n; i++){
            for (int j = 1; j<=n; j++){
                System.out.print( j+ " " );
            }
            System.out.println();
        }

     */


        // Alphabet square

     /*   int n = sc.nextInt();

        for (int i = 1 ; i<=n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print((char)(i + 64) + " ");
            }
            System.out.println();
        }

      */


        // Star triangle
//
//         int n = sc.nextInt();
//
//        for (int i = 1; i<=n; i++){
//            for (int j = 1; j<=i; j++){
//                System.out.print( "* " );
//            }
//            System.out.println();
//        }


        // Star triangle flip

        int n = sc.nextInt();
        for (int i = 1; i<=n; i++) {
            for (int j = 1; j <= n+1-i; j++) {
                System.out.print( "* ");
            }
            System.out.println();
        }



        // Number triangle

//         int n = sc.nextInt();
//
//        for (int i = 1; i<=n; i++){
//            for (int j = 1; j<=i; j++){
//                System.out.print( j + " "  );
//            }
//            System.out.println();
//        }



        // number and alphabet triangle

    /*    int n = sc.nextInt();
        for (int i = 1; i<=n; i++){
            for (int j = 1; j<=i; j++){
                if (i%2!=0){
                    System.out.print(j + " ");
                }
                else {
                    System.out.print((char)(j + 64) + " ");
                }
            }
            System.out.println();
        }

     */


            // number and alphabet flip

    /*    int n = sc.nextInt();
        for (int i = 1; i<=n; i++) {
            for (int j = 1; j <= n + 1 - i; j++) {
                if ((n+1-i)%2!=0){
                    System.out.print((char)(i+64) + " ");
                }
                else {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }

     */

        // odd number triangle

    /*    int n = sc.nextInt();
        for (int i = 1; i<=n; i++){
            for (int j = 1; j<=i; j++){
                System.out.print(2*j-1 + " ");

            }
            System.out.println();
        }

     */

        // floyd triangle

     /*   int n = sc.nextInt();
        int a = 1;
        for (int i = 1; i<=n; i++){
            for (int j = 1; j<=i; j++){
                System.out.print(a + " ");
                a++;
            }
            System.out.println();
        }

      */



        // zero one triangle

    /*    int n = sc.nextInt();
        for (int i = 1; i<=n; i++){
            for (int j = 1; j<=i; j++){
                if ((i+j)%2==0){
                    System.out.print(1+" ");
                }
                else {
                        System.out.print(0+" ");
                }
            }
            System.out.println();
        }

     */

        // starplus

    /*    int n = sc.nextInt();
        int mid = n/2 +1;
        for (int i = 1; i<=n; i++){
            for (int j = 1; j<=n; j++){
                if (i== mid|| j==mid) {
                    System.out.print("*"+ " ");
                }
                else {
                    System.out.print(" "+" ");
                }
            }
            System.out.println();
        }

     */

        // Hollow rectangle

    /*    int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 1; i<=n; i++){
            for (int j = 1; j<=m; j++){
                if (i==1 || i==n || j==1 || j==m){
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

     */

      // Star cross

    /*    int n = sc.nextInt();
        for (int i = 1; i<=n; i++){
            for (int j = 1; j<=n; j++){
                if (j==i || j==n+1-i){
                    System.out.print("*" +" ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
 */

        // star triangle reverse

    /*    int n = sc.nextInt();
        for (int i = 1; i<=n; i++){
            for (int j = 1; j<=n; j++) {
                if (i+j<=n) {
                    System.out.print("  ");
                }
                else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }

     */
        // method 2

   /*     int n = sc.nextInt();
        for (int i =1; i<=n; i++){
            for (int j = 1; j<=n-i; j++){    // for spaces loop
                System.out.print(" "+" ");
            }
            for (int j = 1; j<=i; j++){
                System.out.print("*"+" ");
            }
            System.out.println();
        }

    */



        // alphabet triangle reverse

    /*    int n = sc.nextInt();
        for (int i = 1; i<=n; i++){
            for (int j = 1; j<=n-i; j++){
                System.out.print(" "+" ");
            }
            for (int j = 1; j<=i; j++){
                System.out.print((char)(j+64)+" ");
            }
            System.out.println();
        }

     */

        // rhombus
//
//        int n = sc.nextInt();
//        for (int i = 1; i<=n; i++){
//            for (int j = 1; j<=n-i; j++){
//                System.out.print(" "+" ");
//            }
//            for (int j = 1; j<=n; j++){
//                System.out.print("*"+" ");
//            }
//            System.out.println();
//        }



        // Star pyramid
//
//        int n = sc.nextInt();
//        for (int i = 1; i<=n; i++){
//            for (int j = 1; j<=n-i; j++){
//                System.out.print(" "+" ");
//            }
//            for (int j = 1; j<=2*i-1; j++){
//                System.out.print("*"+" ");
//            }
//            System.out.println();
//        }


        // method 2

    /*    int n = sc.nextInt();
        int nsp = n-1, nst =1;
        for (int i = 1; i<=n; i++){
            for (int j = 1; j<=nsp; j++){
                System.out.print(" "+" ");
            }
            for (int j =1; j<=nst; j++){
                System.out.print("*"+" ");
            }
            nsp--;
            nst+=2;
            System.out.println();
        }
    */



//        int n = sc.nextInt();
//        int nsp = n-1, nst = 1;
//        for (int i = 1; i<=n; i++) {
//            for (int j = 1; j <= nsp; j++) {
//                System.out.print(" " + " ");
//            }
//            for (int j = 1; j <= nst; j++) {
//                System.out.print("*" + " ");
//            }
//            nsp--;
//            nst += 2;
//            System.out.println();
//        }
//         nsp = 1;
//    nst = nst - 4;
//        for (int i = 1; i<=n; i++) {
//            for (int j = 1; j <= nsp; j++) {
//                System.out.print(" " + " ");
//            }
//            for (int j = 1; j <= nst; j++) {
//                System.out.print("*" + " ");
//            }
//            nsp++;
//            nst -= 2;
//            System.out.println();
//        }




        //    *
        //    **
        //    ***
        //    ****
        //    *****
        //    ****
        //    ***
        //    **
        //    *

//        int n = sc.nextInt();
//
//        for (int i = 0; i < 2 * n; i++){
//            int z = i > n ? 2 * n - i: i;
//            for (int j = 0; j<z; j++){
//                System.out.print(  "* "  );
//            }
//            System.out.println();
//        }


        // Diamond

//        int n = sc.nextInt();
//
//        for (int i = 0; i < 2 * n; i++){
//            int z = i > n ? 2 * n - i: i;
//            int spaces = n - z;
//
//            for(int a = 0; a<spaces; a++){
//                System.out.print(" ");
//            }
//
//            for (int j = 0; j<z; j++){
//                System.out.print(  "* "  );
//            }
//            System.out.println();
//        }







































    }

}
