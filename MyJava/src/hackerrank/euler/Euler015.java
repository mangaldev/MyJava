package hackerrank.euler;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by mdev on 6/11/16.
 */
public class Euler015 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        while(tests-- !=0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = Math.min(m,n);
//            m+nCk   (m+n)*(m+n-1)
            BigInteger num = new BigInteger("1");
            BigInteger den = new BigInteger("1");
            for (int i = 0; i < k; i++) {
                num = num.multiply(new BigInteger((m + n - i) + ""));
            }
            for (int i = k; i >0 ; i--) {
                den = den.multiply(new BigInteger(i+""));
            }
            BigInteger result = num.divide(den).mod(new BigInteger("1000000007"));
            System.out.println(result);
        }
    }
}
