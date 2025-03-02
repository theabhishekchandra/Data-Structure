package contest;

import java.util.HashMap;
import java.util.TreeSet;

public class Daily {
    public static void main(String[] args) {

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
}
