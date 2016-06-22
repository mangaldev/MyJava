package hackerrank.euler;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by mdev on 6/21/16.
 */
public class Euler031 {
    static int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
    static BigInteger[][] arr = new BigInteger[8][100001];

    public static void main(String[] args) {
        waysDP(100000);
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while (cases-- > 0) {
            int paise = sc.nextInt();
            System.out.println(arr[7][paise].mod(BigInteger.valueOf(1000000007)));
//            System.out.println(arr[7][paise]);
        }
    }

    public static void waysDP(int paise) {
        for (int i = 0; i <= paise; i++) {
            arr[0][i] = BigInteger.ONE;
        }
        for (int i = 0; i < coins.length; i++) {
            arr[i][0] = BigInteger.ZERO;
        }
        for (int coinI = 1; coinI < coins.length; coinI++) {
            for (int i = 1; i <= paise; i++) {
                arr[coinI][i] = arr[coinI - 1][i];
                int prevPaise = i - coins[coinI];
                if (prevPaise == 0)
                    arr[coinI][i] = arr[coinI][i].add(BigInteger.ONE);
                if (prevPaise > 0)
                    arr[coinI][i] = arr[coinI][i].add(arr[coinI][prevPaise]);
            }
        }
//        for (int i = 0; i < coins.length; i++) {
//            System.out.println();
//            System.out.print(" "+coins[i]+" ");
//            for (int j = 0; j <= paise; j++) {
//                System.out.print(" "+arr[i][j]);
//            }
//        }
//        System.out.println();
//        return arr[coins.length - 1][paise];
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
