package bit;

import java.lang.reflect.Array;
import java.util.List;

public class BinaryBasic {
    public static void main(String[] args){

//        System.out.println("Most Value: " + findComplement(8));

    }

    /** 67. Add Binary*/
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) sum += a.charAt(i--) - '0'; // Convert char to int
            if (j >= 0) sum += b.charAt(j--) - '0';

            result.append(sum % 2); // Append the remainder (0 or 1)
            carry = sum / 2; // Carry for the next position
        }

        return result.reverse().toString(); // Reverse since we built from LSB to MSB
    }
    /** 190. Reverse Bits*/
    public int reverseBits(int n) {
        int ans = 0;
        for(int i = 0; i < 32; i++){
            int BitMaskValue = (n >> i) & 1;
            ans = ans | (BitMaskValue << 31 - i);
        }
        return ans;
    }
    /*public int[] countBits(int n) {
        int[] ans = new int[n +1];
        int count = 0;
        while (n > 0){
            if ((n & 1) != 0){
                count++;
            }
            n = n >> 1;
        }
        for ()

        return ans;
    }*/


    /** 342. Power of Four*/
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;

        if ((n & (n - 1)) != 0) return false;

        return (n & 0xAAAAAAAA) == 0;
        /*
        *public boolean isPowerOfFour(int n) {
        if (n==0) return false;
        while(n%4==0){
            n/=4;
        }
        if(n==1){
            return true;
        }else return false;
        }*/
    }
    /** 476. Number Complement*/

    public int findComplement(int num) {
        // highestOneBit return only last left 1's of this number all binary value in this bit.
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        return num ^ mask;
    }
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[nums.length -1];
        int pre = nums[0];
        ans[0] = pre;
        for (int i = 1; i < nums.length; i++){
            if (pre != nums[i]){
                ans[i-1] = nums[i];
            }
        }
        return ans;
    }
    /** 2859. Sum of Values at Indices With K Set Bits*/
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;

        for (int i = 0; i < nums.size(); i++) {
            int index = i;
            int count = 0;

            // Count the number of set bits in the index
            while (index > 0) {
                count += (index & 1); // If the last bit is set, increase count
                index >>= 1; // Right shift index
            }

            // If count of set bits equals k, add nums[i] to sum
            if (count == k) {
                sum += nums.get(i);
            }
        }

        return sum;
    }


}
