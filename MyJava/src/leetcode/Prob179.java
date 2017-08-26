package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by mdev on 7/23/17.
 * .
 */
public class Prob179 {

    public String largestNumber(int[] nums) {
        if(hasAllZeroes(nums))
            return "0";
        StringBuilder builder = new StringBuilder();
        Integer[] input = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            input[i] = nums[i];
        }
        Arrays.sort(input, new MyComparator());
        for (Integer integer : input) {
            builder.append(integer);
        }
        return builder.toString();
    }

    private boolean hasAllZeroes(int[] nums) {
        for (int num : nums) {
            if (num != 0)
                return false;
        }
        return true;
    }

    public class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {

            if (Long.valueOf(o1 + "" + o2) > Long.valueOf(o2 + "" + o1))
                return -1;
            else
                return 1;
        }
    }
}
