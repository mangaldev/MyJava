package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mdev on 7/23/17.
 * Point to Notice. : Sort/2Sum/Skip Same Numbers ...
 */
public class Prob15 {

    public static void main(String[] args) {
        int[] input = new int[]{-2, 0, 0, 2, 2};
        final List<List<Integer>> lists = threeSum(input);
        System.out.println("lists = " + lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int lastNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == lastNum)
                continue;
            else
                lastNum = nums[i];
            final List<Pair> pairs = getSumPair(nums, i + 1, nums[i] * -1);
            for (Pair pair : pairs) {
                List<Integer> oneSet = new ArrayList<>();
                oneSet.add(nums[pair.i]);
                oneSet.add(nums[pair.j]);
                oneSet.add(nums[i]);
                result.add(oneSet);
            }
        }
        return result;
    }

    public static List<Pair> getSumPair(int[] nums, int start, int desiredSum) {
        List<Pair> result = new ArrayList<>();
        if (start >= nums.length - 1)
            return result;
        int last = nums.length - 1;
        while (start < last) {
            final int firstNum = nums[start];
            final int secondNum = nums[last];
            if (firstNum + secondNum == desiredSum) {
                result.add(new Pair(start, last));
                start++;
                last--;
                while (last >= 0 && secondNum == nums[last]) {
                    last--;
                }
                while (start < nums.length && firstNum == nums[start]) {
                    start++;
                }
            } else if (firstNum + secondNum > desiredSum) {
                last--;
                while (last >= 0 && secondNum == nums[last]) {
                    last--;
                }
            } else {
                start++;
                while (start < nums.length && firstNum == nums[start]) {
                    start++;
                }
            }

        }
        return result;
    }

    static class Pair {
        int i, j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
