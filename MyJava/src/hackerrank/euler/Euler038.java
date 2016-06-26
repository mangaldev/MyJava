package hackerrank.euler;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by mdev on 6/25/16.
 */
public class Euler038 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        for (int i = 2; i < N; i++) {
            String number = "";

            for (int j = 1; ; j++) {
                if(number.length()>K) {
                    number = "";
                    break;
                }
                if(number.length() == K)
                    break;
                number = number + i*j;
            }
            if(number.length() == K && hasAllOnetoKDigits(number,K)){
                System.out.println(i);
            }
        }
    }

    private static boolean hasAllOnetoKDigits(String number, int K) {
        int[] seen = new int[10];
        Arrays.fill(seen,0);
        for (int i = 0; i < number.length(); i++) {
            if(number.charAt(i)=='0')
                return false;
            seen[number.charAt(i)-'0'] = 1;
        }
        for (int i = 1; i <= K; i++) {
            if(seen[i]==0)
                return false;
        }
        return true;
    }
}
