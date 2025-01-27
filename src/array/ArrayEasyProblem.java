package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ArrayEasyProblem {
    public static void main(String[] args){
//        int[] nums = {2,7,11,15};
//        int[] nums = {2,2,2,2,2,2,7,7,7,7,7,11,11,11,11,15,15,15,15,15,15};
//        int target = 9;
//        int[] nums = { 1, 3, 5, 6};
        int[] nums = {2,5,6,9,10};
        int[] index = {0,1,2,2,1};
        int target = 7;

        ArrayEasyProblem input = new ArrayEasyProblem();

//        System.out.println("Two Sum : " + Arrays.toString(input.twoSum(nums, target)));
//        System.out.println("Output : " + input.removeDuplicates(nums));
//        System.out.println("Output : " + input.searchInsert(nums, target));
        System.out.println("Output : " + input.findGCD(nums));
//        int[] temp = new int[5];
////        for (int j : temp){
////            System.out.println("Output : " + j);
////        }
////        System.out.println("Output : " + temp);

    }
    /** 1. Two Sum
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     *
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * You can return the answer in any order.*/
    public int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        for (int i =0; i<nums.length;i++){
            for (int j = i + 1; j< nums.length; j++){
                if ( target == nums[i] + nums[j]){
                    indices[0] = i;
                    indices[1] = j;
                    return indices;
                }
            }
        }
        return indices;
    }

    /**Remove Duplicates from Sorted Array
     *
     * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
     *
     * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
     *
     * Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
     * Return k.
     * */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        /*[0,0,1,1,1,1,2,3,3,4]*/
        /*[0,_,1,_,1,2,2,3,3,4]*/
        int unique = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != nums[unique -1]){
                nums[unique] = nums[i];
                unique++;
            }
        }
        return unique;
    }
    /** Search Insert Position
     * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
     *
     * You must write an algorithm with O(log n) runtime complexity.
     * */
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        while (start <= end){
            int mid = start + (end - start)/2;
            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] < target){
                start = mid + 1;
            } else {
                end = mid -1;

            }
        }
        return start;
    }
    /** 66. Plus One
     * */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--){
            if (digits[i] == 9){
                digits[i] = 0;
            }else {
                digits[i]++;
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
    /** 121. Best Time to Buy and Sell Stock
     * */
    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int minPrice = prices[0];
        for (int i = 1; i< prices.length; i++){
            int diff = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, diff);
            minPrice = Math.min(prices[i], minPrice);
        }
        return maxProfit;
    }

    /**
     * 169. Majority Element
     */
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == major) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    major = nums[i];
                    count = 1;
                }
            }
        }
        return major;
    }
    /** 1389. Create Target Array in the Given Order
     * */
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < index.length; i++) {
            arr.add(index[i],nums[i]);

        }
        int[] target = new int[nums.length];
        for (int i = 0; i < arr.size(); i++) {
            target[i] = arr.get(i);
        }
        return target;
    }
    /** GFG -> Array Subset */
    public boolean isSubset(int a[], int b[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : a) {
            set.add(num);
        }
        // Check if all elements of b[] are present in the set
        for (int num : b) {
            if (!set.contains(num)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 1991. Find the Middle Index in Array
     */
    public int findMiddleIndex(int[] nums) {
        int totalSum = 0, leftSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
    /** 1929. Concatenation of Array */
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n * 2];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }
        return ans;
    }

    /**
     * 1920. Build Array from Permutation
     */
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] + (nums[nums[i]] % n) * n;
        }
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] / n;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        return nums;
    }

    /**
     * 1979. Find Greatest Common Divisor of Array
     */
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i : nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        return gcd(max, min);
    }

    /** 1. **Euclidean Algorithm**:
     - The Euclidean Algorithm is based on the property that the GCD of two numbers does not change if the larger number is replaced by its remainder when divided by the smaller number.
     */

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}
