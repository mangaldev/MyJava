package hackerrank.euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mdev on 7/9/16.
 */
public class Euler049 {
    private static int max = 1000007;
    private static int[] primes = new int[max];

    public static void main(String[] args) {
        sieve();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        for (int i = 1487; i < N; i++) {
            if (primes[i] == 1) {
                List<Integer> ps = new ArrayList<>();
                ps.add(i);
                int num = i;
                while (true) {
                    num = nextBigNum(num);
                    if (num == -1)
                        break;
                    if (primes[num] == 1) {
                        ps.add(num);
                    }
                }
                if (K == 3) {
                    ifAPFor3(ps);
                } else
                    ifAPFor4(ps);
            }
        }
    }

    private static void ifAPFor4(List<Integer> ps) {
        for (int i = 1; i < ps.size(); i++) {
            for (int j = i; j < ps.size(); j++) {
                for (int k = j + 1; k < ps.size(); k++) {
                    if (ps.get(k) - ps.get(j) == ps.get(j) - ps.get(i) && ps.get(j) - ps.get(i) == ps.get(i) - ps.get(0)) {
                        System.out.println(ps.get(0) + "" + ps.get(i) + "" + ps.get(j) + "" + ps.get(k));
                    }
                }
            }
        }
    }

    private static void ifAPFor3(List<Integer> ps) {
        for (int j = 1; j < ps.size(); j++) {
            for (int k = j + 1; k < ps.size(); k++) {
                if (ps.get(k) - ps.get(j) == ps.get(j) - ps.get(0)) {
                    System.out.println(ps.get(0) + "" + ps.get(j) + "" + ps.get(k));
                }
            }
        }
    }

    public static int nextBigNum(int num) {//3942 -> 4239
        String result = "-1";
        String number = num + "";
        int lastDigit = 0;
        int breakingPoint = number.length() - 1;
        int breakingPointDigit = -1;

        while (num > 0) {
            int digit = num % 10;
            if (digit < lastDigit) {
                breakingPointDigit = digit;
                break;
            }
            breakingPoint--;
            lastDigit = digit;
            num = num / 10;

        }
        char breakingPointChar = Character.forDigit(breakingPointDigit, 10);//1 => i = 2  breakingpiont = 0 length = 3 totlalength = 4
        if (breakingPointDigit != -1) {
            for (int i = number.length() - 1, count = 1; i > breakingPoint; i--, count++) {
                int currentDigit = number.charAt(i) - '0';
                if (currentDigit > breakingPointDigit) {
                    StringBuilder rest = new StringBuilder(number.substring(breakingPoint + 1));
                    rest.setCharAt(rest.length() - count, breakingPointChar);
                    result = number.substring(0, breakingPoint) + currentDigit + rest.reverse().toString();
                    break;
                }
            }
        }
        return Integer.valueOf(result);

    }

    public static void sieve() {
        Arrays.fill(primes, 1);
        primes[1] = 0;
        primes[0] = 0;
        primes[2] = 1;
        int k = 2;
        for (; k * k < max; k++) {
            for (int j = 2 * k; j < max; j = j + k) {
                primes[j] = 0;
            }
        }
    }
}
