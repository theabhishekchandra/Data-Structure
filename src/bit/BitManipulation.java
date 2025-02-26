package bit;

public class BitManipulation {
    /** OPERATORS <p>
     * AND & <p>
     * OR | <p>
     * XOR ^ <p>
     * NOT: One's Complement ~ -> It changes the digit like if you provide 0 then it returns 1.<p>
     * Left Shift << <p>
     * Right Shift >> <p>
     * NOTE: (-1) = (~0); means all bits are 1.
     * */
    public static void main(String[] args){
//        System.out.println("AND : " + AND(0,1));
//        System.out.println("OR : " + OR(2,3));
//        System.out.println("XOR : " + XOR(2,3));
//        System.out.println("One's Complement : " + (~0));
//        System.out.println("Left Shift : " + leftShift(5,2));
//        System.out.println("Is Odd Or Even: " + isOdd(5));
//        System.out.println("Get Ith Bit: " + getIthBit(3, 2));
//        System.out.println("Set Ith Bit: " + setIthBit(10, 2));
//        System.out.println("Get Ith Bit: " + clearIthBit(10, 1));
//        System.out.println("Get Ith Bit: " + updateIthBit(10, 1, 0));
//        System.out.println("Get Ith Bit: " + clearLastIthBits(9, 1));
//        System.out.println("Bit Range is: " + clearRangeOfBits(10, 2,4));
//        System.out.println("Is Two Power: " + isPowOfTwo(5));
//        System.out.println("Count Set Bit: " + countSetBits(8));
//        System.out.println("Count Set Bit: " + fastExpo(8,2));
        swipeTwoNumber(9,4);

    }

    private static int AND(int a, int b){
        return a & b;
    }
    private static int OR(int a, int b){
        return a | b;
    }
    /** XOR -> Similar return 0 and different return 1.*/
    private static int XOR(int a, int b){
        return a ^ b;
    }
    /** Left Shift Formula -> a << b = a * b²
     * <p> a means binary value or integer value.
     * <p>b means number lines you what shift.
     * */
    private static int leftShift(int a, int b){
        return a << b;
    }

    /** Right Shift Formula -> a >> b = a / b²
     *<p> a means binary value or integer value.
     *<p>b means number lines you what shift.*/
    private static int rightShift(int a, int b){
        return a >> b;
    }

    private static Boolean isOdd(int a){
        return (a & 1) == 1;
    }

    /** OPERATIONS <p>
     * GET bit -> n & ( 1 << i)  <p>
     * SET bit -> <p>
     * CLEAR bit -> <p>
     * */

    private static int getIthBit(int n, int i){
        return (n & (1 << i));
    }

    private static int setIthBit(int n, int i){
        return (n | (1 << i));
    }
    private static int clearIthBit(int n, int i){
        int bitMask = ~(1 << i);
        return n & bitMask;
    }
    private static int updateIthBit(int n, int i, int newBit){
        // First approach
        /*if (newBit == 0){
            return clearIthBit(n,i);
        }else {
            return setIthBit(n,i);
        }*/

//        n = clearIthBit(n,i);
        int bitMask1 = ~(1<< i);
        n = n & bitMask1;

        int BitMask = newBit << i;
        return n | BitMask;
    }

    private static int clearLastIthBits(int n, int i){
//        int BitMask = -1; OR Use Another
        int BitMask = ~0 << i;
        return n &  BitMask;
    }

    private static int clearRangeOfBits(int n, int i, int j) {
        /*
        * 011 = 2²-1;
        * 0 N number of 1 = 2 pow N -1;
        */

        int leftMask = (-1 << (j + 1)); // All 1s before j, 0 s after
        int rightMask = (1 << i) - 1;   // All 1s before i, 0 s after
        int bitMask = leftMask | rightMask;
        return n & bitMask;
    }
    private static Boolean isPowOfTwo(int n){
        return (n & (n-1)) == 0;
    }
    private static int countSetBits(int n){
        int count = 0;
        while (n > 0){
            if ((n & 1) != 0){ // Check LSB
                count ++;
            }
            n = n >> 1; // DO the Right Shift.
        }
        return count;
    }
    /** FAST EXPONENTIATION*/

    private static int fastExpo(int a, int n){
        int ans = 1;
        while (n > 0){
            if ((n & 1) != 0){
                ans *= a;
            }
            a *= a;
            n = n >> 1;
        }
        return ans;
    }
    private static void swipeTwoNumber(int a, int b){
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a:" + a + "b:" + b);
    }


}

