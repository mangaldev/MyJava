package hackerrank.euler;

import java.util.Scanner;

/**
 * Created by mdev on 4/17/16.
 */
public class Euler002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- != 0 ){
            long N = sc.nextLong();
            long a = 1;
            long b = 1;
            long sum = 0;
            while(b<=N){
                if(b%2 == 0){
                    sum += b;
                }
                b = a + b;
                a = b - a ;
            }
            System.out.println(sum);
        }
    }
}
