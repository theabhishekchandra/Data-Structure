package basic;

import java.util.Scanner;

public class BasicProgram {

    public static void main(String[] args) {
        /*BasicProgram basicProgram = new BasicProgram();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int a = scanner.nextInt();
//        System.out.println(basicProgram.isPrime(a));
        System.out.println(basicProgram.getFactorial(a));*/


//
//        Calculator calculator = new Calculator(2,3);
//        System.out.println(" Sum " + calculator.sum());

        String s1 = "Hello";
//        String s2 = "Hello";
//        String s3 = new String("Hello");
//
//        System.out.println("Start of P -> :" + s1.hashCode() + "  Mid of P -> :" + s2.hashCode() + "   End of P -> :" + s3.hashCode() );
//        System.out.println(s1 == s3);
//        System.out.println(s1.equals(s3));
        s1 = "He;;p";
        System.out.println(s1);
//
//        // Identify almost memory location (System Identify Location).
//        System.out.println(System.identityHashCode(s1));
//        System.out.println(System.identityHashCode(s2));
//        System.out.println(System.identityHashCode(s3));

//        Son son = new Son();
//        son.No();

    }
    /**
     * Determines whether a given integer is a prime number.
     *
     * @param a the integer to be checked
     * @return true if the integer is a prime number, false otherwise
     */
    public boolean isPrime(int a) {
        boolean isPrime = true;

        if (a <= 1) {
            isPrime = false;
        } else {
            for (int b = 2; b <= Math.sqrt(a); b++) {
                if (a % b == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        if (isPrime) {
            System.out.println("PRIME");
        } else {
            System.out.println("NOT PRIME");
        }
        return isPrime;
    }

    int getFactorial(int a){
        int temp = 1;
        for (int i = 1; i <= a;i++){
            temp = i * temp;
        }
        return temp;
    }
    /**
     * OverLoading
    * */
    private int sum(int a, int b){
        return a + b;
    }
    private int sum(int a, int b, int c){
        return a + b;
    }
}
