package leetcode;

public class Prob31 {

    public static void main(String[] args) {
        final int[] nums = {1,2,3};
        nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(" "+nums[i]);
        }

    }
    public static void reverse(int[] nums,int start, int end) {
        for (int i = start, j = end; i <= j; i++,j--) {
            int temp = nums[i];
            nums[i] = nums[j ];
            nums[j] = temp;
        }
    }

    public static void nextPermutation(int[] nums) {
        int lastNum = nums[nums.length - 1];
        int replacedIndex = -1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < lastNum) {
                replacedIndex = i;
                break;
            }
            lastNum = nums[i];
        }
        if(replacedIndex != -1) {
            int indexToBeReplacedWith = -1;

            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > nums[replacedIndex]) {
                    indexToBeReplacedWith = i;
                    break;
                }
            }

            int temp = nums[indexToBeReplacedWith];
            nums[indexToBeReplacedWith] = nums[replacedIndex];
            nums[replacedIndex] = temp;
        }
        reverse(nums,replacedIndex+1,nums.length -1);
    }

}
