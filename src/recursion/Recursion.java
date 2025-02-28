package recursion;

public class Recursion {
    /** RECURSION: A function calls it self. Recursion is a method of solving a computational problem where the solution depends on a solution to smaller instance of same problems (similar problem).  */
    public static void main(String[] args){
//        System.out.println("Fac: " + factorial(4));
        System.out.println("Sum of N Natural: " + friendPairing(3));
    }

    static void printDec(int n){
        if (n == 1){
            System.out.println("Number: " + n);
            return;
        }
        System.out.println("Number: " + n);
        printDec(n - 1);

    }
    static int factorial(int n){
        if (n == 0){
            return 1;
        }
        return n * factorial(n -1);
    }
    static int sumOfN(int n){
        if (n < 0) return 0;
        if (n == 1) return 1;
        return n + sumOfN(n -1);
    }
    static int fibonacci(int n){
        if (n == 1 || n == 0) return n;
        return factorial(n -1) + factorial(n - 2);
    }

    static Boolean isSorted(int[] arr, int k){
        if (k == arr.length -1) return  true;
        if (arr[k] > arr[k + 1]){
            return false;
        }
        return isSorted(arr, k + 1);
    }
    static int powOfX(int n, int x){
        if(x == 0){
            return 1;
        }
        return n * powOfX(n,x - 1);

    }

    static int tiling(int n){
        if (n == 0 || n == 1){
            return 1;
        }
        // vertically
        int v = tiling(n-1);
        // horizontally
        int h = tiling(n -2);
        return h + v;
    }

    static void removeDuplicate(String str, int idx, StringBuilder newStr, Boolean[] map){
        if (idx == str.length()){
            System.out.println(newStr);
            return;
        }
        char currChar = str.charAt(idx);
        if (map[currChar - 'a']){
            removeDuplicate(str, idx + 1, newStr, map);
        }else {
            map[currChar - 'a'] = true;
            removeDuplicate(str, idx+1,newStr.append(currChar),map);
        }
    }

    static int friendPairing(int n){
        if (n == 1 || n == 2){
            return n;
        }

        int singleWay = friendPairing(n -1);

        int pairing = friendPairing(n -2);
        int pairingWay = (n -1) * pairing;
        return singleWay + pairingWay;
    }
}
