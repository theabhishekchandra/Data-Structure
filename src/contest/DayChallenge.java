package contest;

public class DayChallenge {
    public static void main(String[] args) {
//        System.out.println(convertBinaryToInteger("-1011"));
//        System.out.println(GCD(48,18));
        System.out.println(GCD(56,98));

    }
    public static Boolean isSquare(int num){
        int i = num / 2;
        while (i >= 2){
            if (i * i == num){
                return true;
            }

            i --;

        }
        return false;
    }
    public static int convertBinaryToInteger(String s){
        int result = 0;
        boolean isNegative = false;
        if (s.charAt(0) =='-'){
            isNegative = true;
            s = s.substring(1,s.length()-1);
        }
        for (int i = s.length() -1; i >= 0 ; i--) {
            if (s.charAt(i) == '1'){
                result += (int) Math.pow(2,i);
            }

        }
        if (isNegative){
            result *= -1;
        }
        return result;
    }

    static int GCD(int n , int m){
        int div = Math.min(n, m);
        while (div >= 0){
            if (n % div == 0 && m % div == 0){
                return div;
            }
            div--;
        }

        return -1;
    }

    public static String convertIntToBinary(int num){
        StringBuilder result = new StringBuilder();
        if (num < 0) {
            num *= -1;
            result.append("-");
        } else if (num == 0) {
            result.append(num);

        }
        while (num > 0){
            int val = num % 2;
            result.append(val);
            num /= 2;
        }
        return result.toString();
    }


    /// Day 1: Day of the Week.
    public static String dayOfTheWeek(int day, int month, int year) {
        // Days of the week starting from Sunday
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        // Month table for Zeller's Congruence-like logic
        int[] t = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};

        // Adjust year for January and February
        if (month < 3) {
            year--;
        }

        int value = (year + year / 4 - year / 100 + year / 400 + t[month - 1] + day) % 7;
        return days[value];
    }
}
