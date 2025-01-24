package basic;

import java.util.Scanner;

public class BasicProgram {

    public static void main(String[] args) {
        BasicProgram basicProgram = new BasicProgram();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int a = scanner.nextInt();
//        System.out.println(basicProgram.isPrime(a));
        System.out.println(basicProgram.getFactorial(a));
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
