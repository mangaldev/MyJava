package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Prob658 {
    public static void main(String[] args) {
        final List<Integer> closestElements = findClosestElements(Arrays.asList(0, 1, 2, 2, 2, 3, 6, 8, 8, 9), 5, 9);
        System.out.println("closestElements = " + closestElements);
    }

    public static List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        List<Integer> modifiedArray = new ArrayList<>();
        int lowestIndex = -1;
        int lowestNum = Integer.MAX_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            final int currentNum = x - arr.get(i);
            modifiedArray.add(currentNum);
            if (Math.abs(currentNum) < lowestNum) {
                lowestIndex = i;
                lowestNum = Math.abs(currentNum);
            }
        }
        result.add(arr.get(lowestIndex));
        int left = lowestIndex - 1;
        int right = lowestIndex + 1;
        for (int i = 1; i < k; i++) {
            if (left >= 0 && right < arr.size() && arr.get(left) <= arr.get(right)) {
                result.add(arr.get(left));
                left--;
            } else if (left >= 0 && right < arr.size() && arr.get(left) > arr.get(right)) {
                result.add(arr.get(right));
                right++;
            }
        }
        Collections.sort(result);
        return result;

    }
}
