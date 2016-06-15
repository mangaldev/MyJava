package hackerrank.euler;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by mdev on 6/12/16.
 */
public class Euler016 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        while(tests-- !=0){
            Long result = 0L;
            result = (long) new BigInteger("1").shiftLeft(sc.nextInt()).toString().chars().map(Character::getNumericValue).sum();
            System.out.println(result);
        }
    }
}
