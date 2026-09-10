package practice;

public class LoopsQuestion {
    public static void main(String[] args) {

    //    Scanner sc = new Scanner(System.in);
    //    int n = sc.nextInt();

    // AP

    //    int a =3, d =4;
    //    for (int i =1; i<=n; i++){
    //        System.out.println(a+" ");
    //        a+=d;
    //    }

    // GP

    //    int b= 1, c= 2;
    //    for(int j =1; j<=n; j++){
    //        System.out.println(b);
    //        b*=c;
    //    }

    // Highest factor

    //    int hf =1;
    //    for (int i = n-1; i>=1; i--) {
    //        if (n % i == 0) {
    //            hf = i;
    //            break;
    //        }
    //    }
    //    System.out.println(hf);

        // composite number

    //    for ( int i =2; i<n; i++){
     //       if(n %i==0){
    //            System.out.println("composite number");
    //            break;
    //        }
    //    }

    // count

    //    int count = 0;
    //    while (n!=0){
    //        n = n / 10;
    //        count++;
    //    }
    //    System.out.println(count);

        // sum of digits of a number


    //    int sum = 0;
    //    while (n!=0){
    //        int lastDigit = n % 10;
    //        sum += lastDigit;
    //        n = n/10;
    //    }
    //    System.out.println(sum);


        // Sum of original and its reverse

    /*   int reverse = 0;
       int originalNum = n;
       for (int i = 1; n!=0; i++){
           int lastDigit = n%10;
           reverse = reverse * 10 + lastDigit;
           n = n / 10;
       }
        int sum = originalNum + reverse;
        System.out.println("Original NUmber:" + originalNum);
        System.out.println("Reverse Number:" + reverse);
        System.out.println("Sum:" + sum);   */


        for (int i = 65; i<=90; i++){
            System.out.println(i +" " + (char)i);
        }






















    }
}
