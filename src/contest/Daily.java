package contest;

import java.util.*;

public class Daily {
    public static void main(String[] args) {

        Daily daily = new Daily();
        int[] list = {9,12,5,10,14,3,10};
        daily.pivotArray(list, 10);
        System.out.println(Arrays.toString(list));
    }
    /** 2570. Merge Two 2D Arrays by Summing Values */
    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        HashMap<Integer, Integer> nums = new HashMap<>();

        for (int[] num : nums1) {
            nums.put(num[0], nums.getOrDefault(num[0], 0) + num[1]);
        }

        for (int[] num : nums2) {
            nums.put(num[0], nums.getOrDefault(num[0], 0) + num[1]);
        }

        int[][] result = new int[nums.size()][2];
        int index = 0;

        for (int key : new TreeSet<>(nums.keySet())) {
            result[index][0] = key;
            result[index][1] = nums.get(key);
            index++;
        }

        return result;
    }

    /** 2161. Partition Array According to Given Pivot*/
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> smaller = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        // Categorize elements
        for (int num : nums) {
            if (num < pivot) {
                smaller.add(num);
            } else if (num == pivot) {
                equal.add(num);
            } else {
                greater.add(num);
            }
        }

        // Combine the three lists
        int index = 0;
        for (int num : smaller) nums[index++] = num;
        for (int num : equal) nums[index++] = num;
        for (int num : greater) nums[index++] = num;

        return nums;

    }
    /// 1780. Check if the Number is a Sum of Powers of Three
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;

    }
    /// 2965. Find Missing and Repeated Values
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int size = grid.length;  // N (since the grid is N x N)
        int totalSum = (size * size) * (size * size + 1) / 2; // Correct total sum
        int[] ans = new int[2];  // ans[0] = repeated, ans[1] = missing

        HashSet<Integer> temp = new HashSet<>();
        int actualSum = 0;
        int repeatedValue = -1;

        // Collect values and detect repeated value
        for (int[] row : grid) {
            for (int num : row) {
                if (temp.contains(num)) {
                    repeatedValue = num;  // Found the repeated number
                }
                temp.add(num);
                actualSum += num;
            }
        }

        // Calculate missing value
        int missingValue = totalSum - (actualSum - repeatedValue);

        // Store the result
        ans[0] = repeatedValue;
        ans[1] = missingValue;

        return ans;
    }
    ///  2523. Closest Prime Numbers in Range.
    public int[] closestPrimes(int left, int right) {
        // Step 1: Use Sieve of Eratosthenes to find primes up to 'right'
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= right; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Step 2: Extract primes in the range [left, right]
        List<Integer> primes = new ArrayList<>();
        for (int i = Math.max(2, left); i <= right; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        // Step 3: Find the closest prime pair
        if (primes.size() < 2) {
            return new int[]{-1, -1};  // No valid pair
        }

        int minDiff = Integer.MAX_VALUE;
        int[] closestPair = new int[2];

        for (int i = 1; i < primes.size(); i++) {
            int diff = primes.get(i) - primes.get(i - 1);
            if (diff < minDiff) {
                minDiff = diff;
                closestPair[0] = primes.get(i - 1);
                closestPair[1] = primes.get(i);
            }
        }

        return closestPair;
    }

    /// 2. Add Two Numbers
    /*
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy; // Pointer List
        int cary = 0;

        while (l1 != null || l2 != null || cary != 0){
            int sum = cary;

            // add Sum and check the next node.
            if (l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            // Get carry
            cary = sum / 10;
            // Set current next value with new Node.
            current.next = new ListNode(sum % 10);
            // Change next current Node as Current Node.
            current = current.next;
        }
        return dummy.next; // Start with 2nd Node.
    }*/

    /// 2529. Maximum Count of Positive Integer and Negative Integer.
    public int maximumCount(int[] nums) {
        int pos = 0;
        int neg = 0;
        for(int num : nums){
            if (num < 0){
                neg++;
            }else if(num > 0){
                pos++;
            }
        }
        return (int)Math.max(pos,neg);
    }

}
