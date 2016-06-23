package hackerrank.euler;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by mdev on 6/22/16.
 */
public class Euler034 {
    public static void main(String[] args) {
        int[] fact = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
//        int[] result = new int[100007];
//        Arrays.fill(result,0);
//        for (int i = 0; i < 100007; i++) {
//
//        }
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long result = 0;
        for (int i = 10; i < N; i++) {
            long total = 0;
            int num = i;
            while (num > 0) {
                total += fact[num % 10];
                num = num / 10;
            }
            if (total % i == 0)
                result += i;
        }
        System.out.println(result);
    }


}
