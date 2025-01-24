package basic;

import java.util.Scanner;

public class StartPrinting {
    public static void main(String[] args) {
        StartPrinting startPrinting = new StartPrinting();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int a = scanner.nextInt();
//        startPrinting.trianglePrintStart1(a);
//        startPrinting.invertedPrintStart1(a);
//        startPrinting.printHalfPyramid(a);
        startPrinting.printCharacter(a);


    }


    /**
     * Prints a pattern of asterisks where the number of rows is determined by the input.
     * Each row contains an incremental number of asterisks starting from 0 up to the provided number.
     *
     *          *
     *          **
     *          ***
     *          ****
     *          *****
     *
     * @param i the number of rows to print in the pattern
     */
    private void trianglePrintStart1(int i) {
        for (int j = 0; j <= i; j++) {
            for (int k = 0; k < j; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    /**
     * Prints an inverted pattern of asterisks where the number of rows is determined by the input.
     * The first row contains the maximum number of asterisks, decreasing by one in each subsequent row.
     *
     *          *****
     *          ****
     *          ***
     *          **
     *          *
     * @param i the number of rows minus one for the inverted asterisk pattern
     */
    private void invertedPrintStart1(int i){
        for (int j = 0; j <= i; j++) {
            for (int k = 0; k < i - j; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * Prints a half pyramid pattern of numbers where the number of rows is determined
     * by the input. Each row contains consecutive integers starting from 1 up to the
     * current row number.
     * 1
     * 12
     * 123
     * 1234
     * 12345
     *
     * @param a the number of rows in the half pyramid pattern
     */
    private void printHalfPyramid(int a){
        for (int i = 0;i <=a;i++){
            for (int j = 1; j <= i ; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    /**
     * Prints a character pattern where each row starts with 'A' and
     * increments the characters sequentially. The number of rows
     * corresponds to the input value, with each row printing an
     * increasing number of characters.
     *
     * A
     * BC
     * DEF
     * GHIJ
     * KLMNO
     *
     * @param a the number of rows to be printed in the character pattern
     */
    private void printCharacter(int a){
        char ch = 'A';
        for (int i =0 ; i<=a;i++){
            for (int j = 0; j < i; j++){
                System.out.print(ch);
                ch++;
            }
            System.out.println();
        }
    }

}
