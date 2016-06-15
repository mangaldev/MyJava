package dp;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by mdev on 6/10/16.
 */
public class PartitionProblem {
    public static void main(String[] args) {
        int[] input = {3, 1, 5, 9, 12};
        int half = IntStream.of(input).sum() / 2;
        if (isPartiaionPossible(half, half, 0, input))
            System.out.println("Possible");
    }

    public static boolean isPartiaionPossible(int sum1, int sum2, int index, int[] input) {
        if (sum1 == 0 && sum2 == 0) {
            return true;
        }
        for (int i = index; i < input.length; i++) {
            return isPartiaionPossible(sum1 - input[index], sum2, i + 1, input)
                    || isPartiaionPossible(sum1, sum2 - input[index], i + 1, input);
        }
        return false;
    }
}
