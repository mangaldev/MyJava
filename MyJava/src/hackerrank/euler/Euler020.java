package hackerrank.euler;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by mdev on 6/14/16.
 */
public class Euler020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while (cases-- != 0) {
            int num = sc.nextInt();
            Stream<BigInteger> bigIntegerStream = IntStream.rangeClosed(1, num).parallel().mapToObj(Euler020::toBigInt);
            BigInteger factorial = bigIntegerStream.reduce(toBigInt(1), BigInteger::multiply);
            int sum = factorial.toString().chars().map(Character::getNumericValue).sum();
            System.out.println(sum);
        }
    }

    private static BigInteger toBigInt(int i) {
        return new BigInteger(i+"");
    }
}
