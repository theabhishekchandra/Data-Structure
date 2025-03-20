package algorithem;

import java.lang.reflect.Array;
import java.util.*;

public class Greedy {
    /** Greedy -> Greedy algorithm is the problem-solving technique
     * where we make the locally optimized choice at each stage and hope to achieve a global optimum */
    public static void main(String[] args) {

    }
    /** Q1. Activity Selection -> You are given n activity with their start and end times.
     * Select the maximum number of activities that can be performed by a single person,
     * assuming that a person can only work on a single activity at a time.
     * Activities are sorted according to end time. Start = [10,12,20], end = [20,25,30]<p>
     *
     *
     *  Q2. Fractional Knapsack -> Given the weight and values of N items, put these items in knapsack of capacity W to get the maximum
     * value in the knapsack<p>
     *  Q3. Min Absolute difference pair -> Give 2 array A and B of equal length n. Pair each element of array A to an element
     *  in array B, Such that sum S out of absolute difference of all the pairs is minimum.*/
    public static void minPairs(int[] a , int[] b){
        Arrays.sort(a);
        Arrays.sort(b);
        int minDif = 0;
        for (int i = 0; i < a.length; i++) {
            minDif += Math.abs(a[i] - b[i]);
        }

        System.out.println(minDif);
    }
    /** Indian Coin -> we are given infinity supply of denomination [1, 2, 5, 10, 20, 50, 100, 200, 500, 2000].
     * Find Min number of coin/note to make change for value V.*/
    public static int minCoinUse(int amount){
        int[] coin = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        Arrays.sort(coin);
        int coinCount = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < coin.length; i++){
            if (coin[i] <= amount){
                while (coin[i] <= amount){
                    coinCount++;
                    ans.add(coin[i]);
                    amount -= coin[i];
                }
            }
        }
        System.out.println(ans);
        return coinCount;
    }

    /** Q4.Job Sequencing Problem -> Give an array of jobs where every job has a deadline and profit if the job is finished before the deadline.
     * It is also given that every job takes a single unit of time, so the minimum possible deadline for any is 1. Maximize total profit if only
     * one job can be scheduled at a time.
     *
     * Q5. Chocolate problem ->
     * //TODO: Need to Read I Skip this Play List.*/


}
