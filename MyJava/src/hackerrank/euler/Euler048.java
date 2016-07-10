package hackerrank.euler;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by mdev on 7/9/16.
 */
public class Euler048 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        BigInteger mod = new BigInteger("10000000000");
        long result = 0;
        for (int i = 1; i <= N ; i++) {
            if(i%10 == 0)
                continue;
            BigInteger num = new BigInteger(i+"");
            result = (result + num.modPow(num,mod).longValue())%10000000000L;

        }
        System.out.println(result);
    }
}
