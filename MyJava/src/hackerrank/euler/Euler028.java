package hackerrank.euler;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by mdev on 6/19/16.
 */
public class Euler028 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while (cases-- > 0) {
            long N = sc.nextLong();
            BigInteger num = new BigInteger((N/2)+"");
            BigInteger nplus1 = BigInteger.ONE.add(num);
            BigInteger doublen = new BigInteger("2").multiply(num);
            BigInteger first = new BigInteger("8").multiply(num).multiply(nplus1).multiply(doublen.add(BigInteger.ONE)).divide(new BigInteger("3"));
            BigInteger second = doublen.multiply(nplus1);
            BigInteger doubledoublen = doublen.multiply(new BigInteger("2"));
            BigInteger sum = BigInteger.ONE.add(first).add(second).add(doubledoublen);
            System.out.println(sum.mod(new BigInteger("1000000007")));
        }
    }
}

//
//    private void sum(int N){
//        BigInteger current = new BigInteger("1");
//        BigInteger result = new BigInteger("1");
//        for (long count = 1; count <= N / 2;count++) {
//            for (int j = 0; j < 4; j++) {
//                current = current.add(new BigInteger("2").multiply(new BigInteger(count+"")));
//                result = result.add(current);
//            }
//        }
//        System.out.println(result.mod(new BigInteger("1000000007")));
//    }