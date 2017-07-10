package hackerrank.euler;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by mdev on 7/10/16.
 */
public class Euler050 {
    private static int max = 10000007;
    private static int[] primes = new int[max];

    public static void main(String[] args) {
        sieve();
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while (cases-- > 0) {
            long num = sc.nextLong();
            long maxPrime = 0;
            long maxCount = 0;

            for (long i = 1; i <= num; i++) {
                if (!isPrime(i))
                    continue;
                long currentPrimeSum = i;
                long currentCount = 1;
                for (long j = i+1;j<=num && currentPrimeSum <= num; j++) {
                    if (!isPrime(j))
                        continue;
                    currentCount++;
                    currentPrimeSum += j;
                    if(currentPrimeSum > num)
                        break;
                    if (isPrime(currentPrimeSum)) {
                        if (currentCount > maxCount) {
                            maxCount = currentCount;
                            maxPrime = currentPrimeSum;
                        }
                    }
                }
            }
            System.out.printf("%d %d\n",maxPrime,maxCount);
        }

    }

    public static boolean isPrime(long N){
        if(N<2) return false;
        if(N==2) return true;
        if(N%2 == 0) return false;
        if(N < max)
            return primes[(int) N] == 1;
        else {
            for (int i = 2; i < max; i++) {
                if(primes[i]==1 && N%i==0)
                    return false;
            }
            return BigInteger.valueOf(N).isProbablePrime(100);
        }
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
