package client;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrimeNumbers {
    static int boundary = 10000000;
    static int boundary1 = 100000000;
    static boolean[] primeNums = new boolean[boundary + 1];
    static boolean[] result = new boolean[boundary1 + 1];

    public static void main(String... args) {
        primeNums[0] = true;
        primeNums[1] = true;
        for (int i = 2; i <= Math.sqrt(boundary); i = i + 1) {
            if (!primeNums[i]) {
                for (int j = 2*i; j <= boundary; j += i) {
                    primeNums[j] = true;
                }
            }
        }
//        for (int i = 1; i < primeNums.length; i++) {
//            System.out.print(s" "+primeNums[i]+" ");
//        }
        long start = 100000000000000L;
        long end = 100000000000000L + 100000000L;
        for (int i = 2; i < boundary; i++) {//i ==7
            if (!primeNums[i]) {
                long k = start / i;//k == 14
                long l = end / i;// 28
                for (long j = 2*i; j <= l; j++) { // 50
                    long u = j * i - k;
                    result[(int) u] = true;//
                }
            }

        }
        for (int i = 1; i < primeNums.length; i++) {
//            System.out.print(s" " + primeNums[i] + " ");
        }
    }

}
