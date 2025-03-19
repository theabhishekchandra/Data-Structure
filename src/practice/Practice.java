package practice;

public class Practice {
    public static void main(String[] args) {


    }

    /// 7. Reverse Integer.
    public int reverse(int x) {
        int rev = 0;

        while (x != 0) {
            int digit = x % 10; // Extract last digit
            x /= 10; // Remove last digit

            // Check overflow before adding the digit
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && digit > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && digit < -8)) return 0;

            rev = rev * 10 + digit; // Append digit
        }
        return rev;
    }

    /// 9. Palindrome Number
    public boolean isPalindrome(int x) {
        int rev = 0;
        int cor = x;
        while (cor != 0){
            int digit = cor % 10;
            cor /= 10;
            rev = rev *10 + digit;
        }
        while (x != 0 && rev != 0){
            int digit = x % 10;
            int digit1 = rev % 10;
            if (digit1 != digit) return false;
            x /= 10;
            rev /= 10;
        }
        return true;
    }
}
