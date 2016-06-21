package hackerrank.euler;

import java.util.Scanner;

/**
 * Created by mdev on 6/19/16.
 */
public class Euler027 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int besta = 0;
        int bestb = 0;
        int best = -1;
        for (int b = 0; b <= N; b++) {
            if (!isPrime(b)) continue;
            for (int a = -b; a <= N; a++) {
                for (int k = 0; ; k++) {
                    int num = calculateEquation(a, b, k);
                    if (!isPrime(num)) {
                        if(k>best) {
                            best = k;
                            besta = a;
                            bestb = b;
                        }
                        break;
                    }
                }
            }
        }
        System.out.printf("%d %d\n",besta,bestb);
    }



    private static int calculateEquation(int a, int b, int k) {
        return (k * k) + (a * k) + b;
    }

    private static boolean isPrime(int num) {
        if(num < 2) return false;
        if(num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i = i + 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
