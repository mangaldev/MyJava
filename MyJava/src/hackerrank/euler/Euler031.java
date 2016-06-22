package hackerrank.euler;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by mdev on 6/21/16.
 */
public class Euler031 {
    static int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
    static int[] arr = new int[100007];

    public static void main(String[] args) {
        waysDP(100000);
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while (cases-- > 0) {
            int paise = sc.nextInt();
            System.out.println(arr[paise] % 1000000007);
        }
    }

    private static void waysDP(int paise) {
        Arrays.fill(arr, 0);
        arr[0] = 1;
        for (int coinI = 0; coinI < coins.length; coinI++) {
            for (int i = 0; i <= paise; i++) {
                int prevPaise = i - coins[coinI];
                if (prevPaise >= 0) arr[i] = (arr[i] + arr[prevPaise]) % 1000000007;
            }
        }

    }

    public static long ways(int paise, int index) {
        if (paise == 0)
            return 1;
        long sum = 0;
        for (int i = index; i < coins.length; i++) {
            if (paise - coins[i] >= 0)
                sum += ways(paise - coins[i], i);
        }
        return sum;
    }
}
