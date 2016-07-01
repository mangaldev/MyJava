package hackerrank.euler;

import java.util.Scanner;

/**
 * Created by mdev on 6/26/16.
 */
public class Euler042 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while (cases-- > 0){
            long n = sc.nextLong();
            long squareRoot = (long) Math.sqrt(n*2);
            if(squareRoot * (squareRoot+1) == (n*2)){
                System.out.println(squareRoot);
            }
            else
                System.out.println(-1);
        }
    }
}
