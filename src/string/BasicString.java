package string;

import solid.srp.FileManager;

import java.util.Arrays;
import java.util.Scanner;

public class BasicString {
    /** String is Immutable.
     * Interning
     * Why Sting is Immutable. -> They Store data in Heep and Stack then every String store new memory location.
     *
     * String Builder ->
     * */



    public static void main(String[] args){
//        System.out.println("Enter String Number: ");
//        Scanner sc = new Scanner(System.in);
//        String value = sc.nextLine();
        String s = "0P";
        System.out.println(new BasicString().isPalindrome(s));




        /* SOLID - Single Responsibility of a class.
        FileManager fileManager = new FileManager(1,2);
        fileManager.openFile();*/

    }

    static String noData(){
        return "ASWER";

    }

    static void hideStingLast(String number){

        for (int i = 4; i< number.length(); i++){
            System.out.print(number.charAt(i));
        }
    }

    static Boolean palindrome(String input){
        int start = 0;
        int last = input.length()-1;
        while (start < last){
            if (input.charAt(last) == input.charAt(start)){
                start++;
                last--;
            }else {
                return false;
            }
        }
        return true;
    }
    /** Given a route containing 4 direction (E, W, N, S), find the shortest path reach destination.
     * formulas : distance = SQR of x*x + y*y
     * */

    static float findShortestPath(String path) {
        int x = 0, y = 0;
        for (int i = 0; i < path.length(); i++) {
            switch (path.charAt(i)) {
                case 'W': x--; break;
                case 'N': y++; break;
                case 'S': y--; break;
                case 'E': x++; break;
            }
        }
        return (float) Math.sqrt(x * x + y * y);
    }
    /** toUpperCase in String*/

    static String upperCase(String a){
        StringBuilder temp = new StringBuilder();

        temp.append(Character.toUpperCase(a.charAt(0)));

        for (int i =0; i<a.length() - 1; i++){
            if(a.charAt(i) == ' '){
                temp.append(a.charAt(i));
                i++;
                temp.append(Character.toUpperCase(a.charAt(i)));
            }else{
                temp.append(a.charAt(i));
            }
        }

        return temp.toString();
    }

    /** String Compression*/

    static void compression(String a){

    }

    /** 13. Roman to Integer*/
    public static int romanToInt(String s) {
        int total = 0;
        int pre = 0;
        for (int i = s.length() -1 ; i>= 0;i--){
            int cur = getValue(s.charAt(i));
            if (cur < pre){
                total -= cur;
            }else {
                total += cur;
            }

            pre =cur;
        }

        return total;
    }
    private static int getValue(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

    /** 14. Longest Common Prefix. */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
    /// 125. Valid Palindrome
    public boolean isPalindrome(String s) {
        String str = s.replaceAll("[^a-zA-Z]","");
        str = str.toLowerCase();
        int start = 0;
        int end = str.length() -1;

        while (start < end){

            if (str.charAt(start) == str.charAt(end)){
                start++;
                end--;
            }else {
                return false;
            }
        }
        return true;
    }

}
