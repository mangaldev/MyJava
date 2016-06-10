package hackerrank.euler;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by mdev on 5/5/16.
 */
public class Euler013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num  = sc.nextInt();
        BigInteger result = new BigInteger("0");
        while(num-- != 0){
            result = result.add(new BigInteger(sc.next()));
        }
        System.out.println(result.toString().substring(0,10));
    }
}
