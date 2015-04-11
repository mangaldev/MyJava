package game;

import java.lang.Math;

/**
 * Created by mdev on 4/11/15.
 */
public class ChooseCoinsFromSide {

    public static int[] input = {1, -13, 2, 17};

    public static void main(String[] args) {
        int max = maxProfit(input, 0, input.length-1);
        System.out.println("max = " + max);
    }

    public static int maxProfit(int[] input, int start, int end) {

        if (Math.abs(end - start) == 1)
            return Math.max(input[start], input[end]);
        int first = input[start] + Math.min(maxProfit(input, start + 2, end), maxProfit(input, start + 1, end - 1));
        int second = input[end] + Math.min(maxProfit(input, start + 1, end - 1), maxProfit(input, start, end - 2));
        return Math.max(first, second);
    }
}
