package leetcode;

/**
 * Created by mdev on 7/23/17.
 */
public class Prob34 {


    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        final int i = lowerBound(nums, 8, 0, nums.length);
        System.out.println("i = " + i);
    }
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = lowerBound(nums, target, 0, nums.length-1);
        result[1] = upperBound(nums, target, 0, nums.length-1);
        return result;
    }

    public static int lowerBound(int[] nums, int target, int lower, int upper) {
        int middle = (lower + upper) / 2;
        if (lower > upper)
            return -1;
        if (nums[middle] == target) {
            if (middle - 1 >= 0 && nums[middle - 1] == target)
                return lowerBound(nums, target, lower, middle - 1);
            else {
                return middle;
            }
        } else if (nums[middle] < target) {
            return lowerBound(nums, target, middle + 1, upper);
        } else {
            return lowerBound(nums, target, lower, middle - 1);
        }
    }

    public int upperBound(int[] nums, int target, int lower, int upper) {
        int middle = (lower + upper) / 2;
        if (lower > upper)
            return -1;
        if (nums[middle] == target) {
            if (middle + 1 < nums.length && nums[middle + 1] == target)
                return upperBound(nums, target, middle + 1, upper);
            else {
                return middle;
            }
        } else if (nums[middle] < target) {
            return upperBound(nums, target, middle + 1, upper);
        } else {
            return upperBound(nums, target, lower, middle - 1);
        }
    }
}
