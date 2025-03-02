package contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BiWeekly {
    public static void main(String[] args) {

    }
    public int[] transformArray(int[] nums) {
        List<Integer> temp = new ArrayList<Integer>();
        for (int num : nums) {
            if (num % 2 == 0) {
                temp.addFirst(0);
            } else {
                temp.addLast(1);
            }
        }
        for (int i = 0 ; i < temp.size() && i < nums.length; i++){
            nums[i] = temp.get(i);
        }
        return nums;

    }
    int[] helper(int[] nums, int idx){
        if (nums.length -1 == idx){
            return nums;
        }
        if (nums[idx] % 2 == 0){
            nums[idx] = 0;
        }else{
            nums[idx] = 0;
        }
        helper(nums,idx +1);

        return nums;
    }

}
