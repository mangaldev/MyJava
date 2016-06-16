package hackerrank.euler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by mdev on 5/11/16.
 */
public class Euler014 {
    private static long[] cache = new long[5000001];
    private static long[] result = new long[5000001];

    public static void main(String[] args) {
        Arrays.fill(cache,0);
        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 2;
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        Scanner sc = new Scanner(System.in);
        long max = Integer.MIN_VALUE;
        long maxSoFar = 1;
        for (int i = 2; i <=5000000 ; i++) {
            long chainLength = getChainLength(i);
            if (chainLength >= max) {
                max = chainLength;
                maxSoFar = i;
            }
            result[i] = maxSoFar;
        }
        int testCases = sc.nextInt();
        while (testCases-- != 0) {
            int input = sc.nextInt();
            System.out.println(result[input]);
        }
    }

    private static long getChainLength(long num) {
        long result;
        if (num<= 5000000 && cache[(int) num] != 0) {
            result = cache[(int) num];
        } else {
            if (num % 2 == 0) result = 1 + getChainLength(num >> 1);
            else result = 1 + getChainLength((num<<2) - num + 1);
            if(num<=5000000){
                cache[(int) num] = result;
            }
        }

        return result;
    }


}
