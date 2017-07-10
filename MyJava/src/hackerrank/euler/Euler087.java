package hackerrank.euler;

import java.util.*;

/**
 * Created by mdev on 7/16/16.
 */
public class Euler087 {
    private static int max = 10007;
    private static int[] primeList = new int[max];

    public static void main(String[] args) {
        sieve();
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while (cases-- > 0) {
            long count = 0;
            Set<Integer> result = new HashSet<>();
            long N = sc.nextLong();
            for (int i = 2; i * i * i * i < N && i < 100; i++) {
                if (primeList[i] == 0)
                    continue;
                for (int j = 2; i * i * i * i + j * j * j < N && j < 1000; j++) {
                    if (primeList[j] == 0)
                        continue;
                    for (int k = 2; i * i * i * i + j * j * j + k * k <= N && k < 10000; k++) {
                        if (primeList[k] == 1) {
//                            System.out.printf("%d %d %d\n", i, j, k);
                            result.add(i * i * i * i + j * j * j + k * k);
                        }
                    }
                }
            }
            System.out.println(result.size());
        }

    }

    public static void sieve() {
        Arrays.fill(primeList, 1);
        primeList[1] = 0;
        primeList[0] = 0;
        primeList[2] = 1;
        for (int k = 2; k * k < max; k++) {
            for (int j = k * k; j < max; j = j + k) {
                primeList[j] = 0;
            }
        }
    }
}
