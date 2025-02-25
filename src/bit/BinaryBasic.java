package bit;

public class BinaryBasic {
    public static void main(String[] args){

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

}
