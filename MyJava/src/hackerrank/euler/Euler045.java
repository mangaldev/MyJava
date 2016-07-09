package hackerrank.euler;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by mdev on 6/27/16.
 */
public class Euler045 {
    public static void main(String[] args) {
//        System.out.println(triangle(210));
//        System.out.println(pentagonal(210));
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        int a = sc.nextInt();
        int b = sc.nextInt();
        long indexA = 1;
        long indexB = 1;
        long raceB = call(b, indexB);
        long raceA = call(a, indexA);
        while (true) {
            if (raceA > N || raceB > N)
                break;
            if (raceA > raceB) {
                indexB++;
                raceB = call(b, indexB);
            } else if (raceB > raceA) {
                indexA++;
                raceA = call(a, indexA);
            } else {
                System.out.println(raceA);
                indexA++;
                indexB++;
                raceA = call(a, indexA);
                raceB = call(b, indexB);
            }
        }
    }

    public static long call(int n, long N) {
        if (n == 3) return triangle(N);
        else if (n == 5) return pentagonal(N);
        else return hexagonal(N);
    }

    public static long triangle(long N) {
        return (N * (N + 1)) / 2;
    }

    public static long pentagonal(long N) {
        return N * (3 * N - 1) / 2;
    }

    public static long hexagonal(long N) {
        return N * (2 * N - 1);
    }
}
