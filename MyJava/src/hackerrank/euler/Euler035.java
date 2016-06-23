package hackerrank.euler;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by mdev on 6/23/16.
 */
public class Euler035 {

    public static void main(String[] args) {
        int[] sieve = new int[1000007];
        Arrays.fill(sieve,1);
        sieve[0] = 0;
        sieve[1] = 0;
        sieve[2] = 1;
        for (int i = 2; i < 1000007; i++) {
            if(sieve[i]==0)
                continue;
            for (int j = 2*i; j < 1000007; j=j+i) {
                    sieve[j] = 0;
            }
        }
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long total = 0;
        for (int i = 2; i < N; i++) {
            boolean allPrime = true;
            int rotations = (i +"").length();
            int multiplication = (int) Math.pow(10,rotations-1);
            int num  = i;
            for (int j = 0; j < rotations; j++) {
                if(j != 0) {
                    int lastDigit = num % 10;
                    num = num / 10;
                    num =  multiplication * lastDigit + num;
                }
                if(sieve[num] != 1){
                    allPrime = false;
                    break;
                }
            }
            if(allPrime) total =total+ i;
        }
        System.out.println(total);
    }

}
