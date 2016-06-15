package hackerrank.euler;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by mdev on 5/11/16.
 */
public class Euler014 {
    private static Map<Long, Long> cache = new HashMap<>();
    private static long[] result = new long[5000001];

    public static void main(String[] args) {
        cache.put(1L, 1L);
        cache.put(2L, 2L);
        result[0] = 0;
        result[1] = 1;

        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        long max = Integer.MIN_VALUE;
        long maxSoFar = 1;
        for (int i = 2; i <= 5000000; i++) {
            long chainLength = getChainLength(i);
            if (chainLength >= max) {
                max = chainLength;
                maxSoFar = i;
            }
            result[i] = maxSoFar;
        }
        while (testCases-- != 0) {
            int input = sc.nextInt();
            System.out.println(result[input]);
        }
    }

    private static long getChainLength(long num) {
        long result = 0;
        if (cache.containsKey(num)) {
            result = cache.get(num);
        } else {
            if (num % 2 == 0) result = 1 + getChainLength(num / 2);
            else result = 1 + getChainLength(num * 3 + 1);
            if (num < 5000001)
                cache.put(num, result);
        }
        return result;
    }
}
