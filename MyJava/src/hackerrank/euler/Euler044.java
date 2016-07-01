package hackerrank.euler;

import java.util.Scanner;

/**
 * Created by mdev on 6/27/16.
 */
public class Euler044 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int K = sc.nextInt();
//        for (int i = 0; i < 20; i++) {
//            System.out.printf(" %d ",pentagonNumber(i));
//        }
        for (int N = K + 1; N < num; N++) {
            long Y1 = pentagonNumber(N) + pentagonNumber(N-K);
            long Y2 = pentagonNumber(N) - pentagonNumber(N-K);
            if (suchXPossible(2*Y1)) {
//                System.out.println(N + " " + pentagonNumber(N) + " is possible for + " + Y1);
                System.out.println(pentagonNumber(N));
                continue;
            }
            if (suchXPossible(2*Y2)) {
//                System.out.println(N + " " + pentagonNumber(N) + " is possible for - " + Y2);
                System.out.println(pentagonNumber(N));
            }
        }

    }

    private static boolean suchXPossible(long Y) {

        double a1 = 1 + Math.sqrt(1 + 12 * Y);
        double a2 = 1 - Math.sqrt(1 + 12 * Y);
//        System.out.printf("%f %f", a1, a2);
//        System.out.println();
        return (a1>0 && a1 % 6 == 0) || (a2 > 0 && a2 % 6 == 0);
    }

    private static long pentagonNumber(long n) {
        return n * (3 * n - 1) / 2;
    }
}
