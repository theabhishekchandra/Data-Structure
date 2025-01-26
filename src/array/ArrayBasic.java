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
        int[] stock = {7,1,5,3,6,4};
        /*if ((arrayBasic.linearSearch(number, 6))) {
            System.out.println("Yes it is.");
        } else {
            System.out.println("No it is.");
        }*/
//        System.out.println(arrayBasic.largestArray(number));
//        arrayBasic.pairInArray(number);
//        arrayBasic.maxSubArraySub();
//        arrayBasic.kadanes();
//        arrayBasic.trappingRainwater();
        System.out.println("Profit : " + arrayBasic.buyAndSellStocks(stock));

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
    /** BASIC METHOD*/
    /*private void maxSubArraySub(){
        int[] a = {1, -2, 6, -1, 3};
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;

        for (int i = 0; i < a.length;i++){
            for (int j = 0; j< a.length; j++){
                curSum = 0;
                for (int k = i; k <= j; k++){
                    curSum += a[k];
                }
                if (curSum> maxSum){
                    maxSum = curSum;
                }

            }
        }
        System.out.println("Max Number: "+ maxSum);

    }*/

    private void maxSubArraySub(){
        int[] a = {1, -2, 6, -1, 3};
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;

        for (int i = 0; i < a.length;i++){
            for (int j = 0; j< a.length; j++){
                curSum = 0;
                for (int k = i; k <= j; k++){
                    curSum += a[k];
                }
                if (curSum> maxSum){
                    maxSum = curSum;
                }

            }
        }
        System.out.println("Max Number: "+ maxSum);
    }
    /** Get maximum Sub Of Array SubArray by Using Kadanes Algorithm*/
    private void kadanes(){
        int[] a = {1, -2, 6, -1, 3};
        int maxSub = Integer.MIN_VALUE;
        int curSum = 0;
        for (int j : a) {
            curSum += j;
            if (curSum < 0){
                curSum = 0;
            }
            maxSub = Math.max(curSum, maxSub);
        }
        System.out.println("Max sum is : "+ maxSub);
    }
    /** @URI https://leetcode.com/problems/trapping-rain-water/description/
     * 42. Trapping Rain Water
     * Given n non-negative integers representing an elevation map where the width of each bar is 1,
     * compute how much water it can trap after raining.
     * */
    private void trappingRainwater(){
        int[] a = {4,2,0,6,3,2,5};
        int h = a.length;
        int trapWater = 0;
        // left Max bar
        int[] leftMax = new int[h];
        leftMax[0] = a[0];
        for (int i = 1; i< h; i++){
            leftMax[i] = Math.max(a[i], leftMax[i-1]);
        }

        // Right Max bar
        int[] rightMax = new int[h];
        rightMax[h-1] = a[h-1];
        for (int i = h-2; i>= 0; i--){
            rightMax[i] = Math.max(a[i], rightMax[i+1]);
        }

        for (int i = 0; i< h;i++){
            int waterLevel = Math.min(rightMax[i], leftMax[i]);
            trapWater += Math.abs(waterLevel - a[i]);
        }
        System.out.println("Trap Water: " + trapWater);

    }

    private int buyAndSellStocks(int[] price){
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int j : price) {
            if (buyPrice < j) {
                int profit = j - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = j;
            }
        }
        return maxProfit;
    }
}
