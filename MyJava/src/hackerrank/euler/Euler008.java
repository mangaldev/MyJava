package hackerrank.euler;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by mdev on 4/28/16.
 */
public class Euler008 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        while (testCases-- != 0) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            String num = scanner.next();
            Long max = 0L;
            for (int i = 0; i < N - K + 1; i++) {
                Long result = 1L;
                for (int j = 0; j < K; j++) {
                    result *= Integer.parseInt(String.valueOf(num.charAt(i + j)));

                }
                max = Long.max(max, result);
            }
            System.out.println(max);
        }
    }
}
