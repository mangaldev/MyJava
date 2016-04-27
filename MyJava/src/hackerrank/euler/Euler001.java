package hackerrank.euler;

import java.util.Scanner;

public class Euler001 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        while (testCases-- != 0) {
            long n = scanner.nextLong();
            System.out.println(sum(3, n) + sum(5, n) - sum(15, n));
        }

    }

    public static long sum(long a, long k) {
        long n = (k-1) / a;
        return (n * (n + 1) * a) / 2;
    }
}

