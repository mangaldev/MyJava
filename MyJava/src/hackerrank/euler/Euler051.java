package hackerrank.euler;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by mdev on 7/14/16.
 */
public class Euler051 {
    private static int max = 9999999;
    private static int[] primeList = new int[max];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int L = sc.nextInt();
        int firstNum = (int) Math.pow(10, N - 1);
        int lastNum = (int) Math.pow(10, N) - 1;
        for (int i = firstNum; i < lastNum; i++) {
        }
    }



    private static boolean isPrime(int num) {
        return primeList[num] == 1;
    }

    public boolean equalToNLength(int num, int N) {
        return num + "".length() == N;
    }

    public static long changeDigitToKAtLocationL(long num, int K, int L) {
        long divisor = (long) Math.pow(10, L - 1);
        long divisor1 = (long) Math.pow(10, L );
        long remainder = num % divisor;
        return ((num/divisor1)*10 + K)*divisor + remainder;
    }

    public static void sieve() {
        Arrays.fill(primeList, 1);
        primeList[1] = 0;
        primeList[0] = 0;
        primeList[2] = 1;
        for (int k = 2; k * k < max; k++) {
            for (int j = 2 * k; j < max; j = j + k) {
                primeList[j] = 0;
            }
        }
    }
}
