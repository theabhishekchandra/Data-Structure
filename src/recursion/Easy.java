package recursion;

public class Easy {

    public static void main(String[] args) {
        Easy easy = new Easy();

        System.out.println("Is Power of Three:" + easy.myPow(2.00000,10) );
    }

    public boolean isPowerOfThree(int n) {
        if (n == 1) return true;
        if (n <= 0 || n % 3 != 0) return false;
        return isPowerOfThree(n / 3);
    }

    public int fib(int n) {
        if (n == 1 || n == 0){
            return n;
        }
        return fib(n -1) + fib(n -2);
    }

    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        long power = n;  // Convert to long to avoid overflow
        if (power < 0) {
            x = 1 / x;
            power = -power;
        }
        return fastPow(x, power);
    }

    private double fastPow(double x, long n) {
        if (n == 0) return 1.0;
        double half = fastPow(x, n / 2);
        return (n % 2 == 0) ? half * half : half * half * x;
    }

}
