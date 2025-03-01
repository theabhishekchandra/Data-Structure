package backtracking;

import java.util.Arrays;

public class BackTracking {
    /** TYPE OF BACKTRACKING <p>
     *  Decision
     *  Optimization
     *  Enumeration -> list of possible solutions.*/
    public static void main(String[] args) {
        /*int[] baseArray = new int[5];
        changeArray(baseArray,0,1);
        System.out.println("Array: " + Arrays.toString(baseArray));*/
        String string = "abc";
        printPermutation(string,"",0);
    }

    static void changeArray(int[] arr, int i, int val){
        if (i == arr.length) {
            System.out.println("Array: " + Arrays.toString(arr));
            return;
        }
        arr[i] = val;
        changeArray(arr, i+1, val+1);  // recursion
        arr[i] = arr[i] - 2; // Backtrack
    }

    static void findSubset(String str, String ans, int i){
        // Base Case
        if (i == str.length()){
            System.out.println(ans);
            return;
        }
        // yes
        findSubset(str, ans + str.charAt(i), i+1);

        // No
        findSubset(str,ans,i+1);

    }

    static void permutations(String str, String ans){
        // Base str = "abc"
        if (str.isEmpty()){
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            String newStr = str.substring(0,i) + str.substring(i);
            permutations(newStr, ans + curr);
        }
    }

    static void printPermutation(String str, String ans, int idx){
        if (str.isEmpty()){
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char curChar = str.charAt(i);
            String NewStr = str.substring(0,i) + str.substring(i + 1);
            printPermutation(NewStr,ans + curChar ,idx +1);
        }

    }
}
