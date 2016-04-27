package hackerrank.euler;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by mdev on 4/21/16.
 */
public class Euler005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while (cases-- != 0) {
            int num = sc.nextInt();
            IntStream.range(1, num + 1).reduce(Euler005::lcm).ifPresent(System.out::print);
        }
    }

    private static int lcm(int a, int b) {
        int lcm = 1;
        for (int i = 2; i <= a || i <= b; i++) {
            int aFactors = factors(a, i);
            int bFactors = factors(b, i);
            int max = Math.max(aFactors, bFactors);
            while (aFactors-- != 0)  a = a / i;
            while (bFactors-- != 0)  b = b / i;
            for (int i1 = 0; i1 < max; i1++) lcm *= i;
        }
        return lcm;
    }

    private static int factors(int num, int a) {
        int count = 0;
        while (num % a == 0) {
            count++;
            num /= a;
        }
        return count;
    }
}
