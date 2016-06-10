package hackerrank.euler;

import java.util.Scanner;

public class Euler010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        int cap = 1000001;
        long[] primes = new long[cap];
        for (int i = 2; i < cap; i++) {
            if (primes[i] == 1)
                continue;
            for (int j = 2 * i; j < cap; j = j + i) {
                primes[j] = 1;
            }
        }
        long currentsum = 0;
        for (int i = 2; i < cap; i++) {
            if (primes[i] == 0)
                currentsum += i;
            primes[i] = currentsum;
        }
        while (testcases-- != 0) {
            System.out.println(primes[sc.nextInt()]);
        }
    }
}
