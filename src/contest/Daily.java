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
    /// 2560. House Robber IV.
    public int minCapability(int[] nums, int k) {
        int left = Arrays.stream(nums).min().getAsInt(); // Minimum house value
        int right = Arrays.stream(nums).max().getAsInt(); // Maximum house value
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Mid-point (candidate max rob amount)

            if (canRob(nums, k, mid)) {
                result = mid;  // Save the valid result
                right = mid - 1; // Try a smaller max robbery amount
            } else {
                left = mid + 1; // Increase min max robbery amount
            }
        }

        return result;
    }

    private boolean canRob(int[] nums, int k, int maxRob) {
        int count = 0;  // Number of houses robbed
        int i = 0;

        while (i < nums.length) {
            if (nums[i] <= maxRob) { // Can rob this house
                count++;
                i += 2; // Skip adjacent house
                if (count >= k) return true; // Already robbed `k` houses
            } else {
                i++;
            }
        }

        return false;
    }
    /// 2206. Divide Array Into Equal Pairs.
    public boolean divideArray(int[] nums) {
        int[] freq = new int[501]; // Constraint: 1 <= nums[i] <= 500
        for (int num : nums) {
            freq[num]++;
        }
        for (int count : freq) {
            if (count % 2 != 0) return false;
        }
        return true;
    }
    /// 2401. Longest Nice Subarray
    public int longestNiceSubarray(int[] nums) {
        int left = 0, maxLength = 0, bitMask = 0;

        for (int right = 0; right < nums.length; right++) {
            // Ensure the window remains "nice" by removing elements from the left
            while ((bitMask & nums[right]) != 0) {
                bitMask ^= nums[left]; // Remove nums[left] from bitMask
                left++;
            }

            // Add the current number to the bitMask
            bitMask |= nums[right];

            // Update max length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    /// 3191. Minimum Operations to Make Binary Array Elements Equal to One I. eg -> nums = [0,1,1,1,0,0]
    public int minOperations(int[] nums) {
        int flipCount = 0;
        int size = nums.length;

        for (int i = 0; i < nums.length -2; i++) {

            if (nums[i] == 0){
                for (int j = i; j < i + 2; j++){
                    nums[j] ^= nums[j];
                }
                flipCount++;
            }

        }
        // If the last two elements are not both 1s, it's impossible
        if (nums[size - 1] == 1 && (size == 1 || nums[size - 2] == 1)) {
            return flipCount;
        }

        return -1;

    }

}
