package hackerrank.codewhiz2016;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by mdev on 3/8/16.
 */
public class ProbablePrime {
    public static void main(String[] args) {

        // assign probablePrime result to bi using bitLength and rnd
        // static method is called using class name

        String str = "ProbablePrime of bitlength " + 100 + " is " + BigInteger.probablePrime(23, new Random());
        System.out.println("str = " + str);

        Scanner in = new Scanner(System.in);
        BigInteger num = in.nextBigInteger();
        if (num.isProbablePrime(1)) {
            System.out.println("prime");
        } else
            System.out.println("not prime");
        in.close();

    }
}
