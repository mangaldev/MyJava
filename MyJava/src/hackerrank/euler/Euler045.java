package hackerrank.euler;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by mdev on 6/27/16.
 */
public class Euler045 {
    public static void main(String[] args) {
//        System.out.println(triangle(210));
//        System.out.println(pentagonal(210));
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        int a = sc.nextInt();
        int b = sc.nextInt();
        long indexA = 1;
        long indexB = 1;

        while (true) {
            BigInteger raceA = call(a,indexA);
            BigInteger raceB = call(b,indexB);
            if(raceA.compareTo(big(N)) > 0 || raceB.compareTo(big(N)) > 0)
                break;
            if(raceA.compareTo(raceB) > 0 )
                indexB++;
            else if(raceB.compareTo(raceA) > 0 )
                indexA++;
            else{
                System.out.println(raceA);
                indexA++;
                indexB++;
            }
        }

    }

    public static BigInteger call(int n, long N) {
        if (n == 3) return triangle(N);
        else if (n == 5) return pentagonal(N);
        else return hexagonal(N);
    }

    public static BigInteger triangle(long N) {
        return (big(N).multiply(big(N).add(big(1)))).divide(big(2));
    }

    public static BigInteger pentagonal(long N) {
        return big(N).multiply(big(N).multiply(big(3)).subtract(big(1))).divide(big(2));
    }

    public static BigInteger hexagonal(long N) {
        return big(N).multiply( big(N).multiply(big(2)).subtract(big(1)));
    }

    public static BigInteger big(long N){
        return new BigInteger(N+"");
    }
}
