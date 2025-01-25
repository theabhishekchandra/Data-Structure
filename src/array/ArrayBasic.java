package array;


import java.util.Arrays;
import java.util.Scanner;

public class ArrayBasic {
    /**
     * Array -> List of element of the same type placed in a contiguous memory location.
     *
     * OPERATION :
     * CREATE ->
     * int mark []  = new int[5];
     * int number[] = {1,2,3};
     * String fruits[] = {"apple","banana","pineapple"};
     *
     * INPUTS ->
     * int num = mark[5];
     *
     * OUTPUT ->
     *
     * UPDATE ->
     *
     * */
    public static void main(String[] args) {
        ArrayBasic arrayBasic = new ArrayBasic();
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter a number: ");
//        int a = scanner.nextInt();
        int[] number = {1/*,2,3,4*/,4,0,7,8,1};
        int[] numberSorted = {1,2,3,4,5,6,7,8,9};
        /*if ((arrayBasic.linearSearch(number, 6))) {
            System.out.println("Yes it is.");
        } else {
            System.out.println("No it is.");
        }*/
//        System.out.println(arrayBasic.largestArray(number));
        arrayBasic.pairInArray(number);

    }

    private boolean linearSearch(int[] a, int key){
        for (int j : a) {
            if (j == key) {
                return true;
            }
        }
        /* Both same Loop
        for (int i = 0; i< a.length; i++){
            if (a[i] == key){
                return true;
            }
        }*/
        return false;
    }
    private int largestArray(int[] a){
        int temp = Integer.MIN_VALUE;
        for (int j : a) {
            if (j > temp) {
                temp = j;
            }
        }
//        for (int i =0; i < a.length ; i++){
//            if (a[i] > temp){
//                temp = a[i];
//            }
//        }
        return temp;
    }
    private int[] reversArray(int[] a){
        int start = 0;
        int end = a.length-1;
        int temp;
        while (start < end){
            temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
        return a;
    }
    private void pairInArray(int[] a){
        for ( int j : a){
            for (int k:a){
               System.out.print("("+ j +" "+ k + ")");
            }
            System.out.println();
        }
    }
}
