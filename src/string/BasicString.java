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
        System.out.println("Enter String Number: ");
        Scanner sc = new Scanner(System.in);
        String value = sc.nextLine();
        System.out.println(upperCase(value));




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

}
