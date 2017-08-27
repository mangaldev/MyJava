package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Prob560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> preSum = new HashMap<>();
        int sumSoFar = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            sumSoFar += nums[i];
            if(preSum.containsKey(sumSoFar - k))
                result = result + preSum.get(sumSoFar - k);
            preSum.put(sumSoFar,preSum.getOrDefault(sumSoFar,0)+1);
        }
        return result;
    }
}
