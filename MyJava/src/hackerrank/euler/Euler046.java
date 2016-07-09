package hackerrank.euler;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by mdev on 7/8/16.
 */
public class Euler046 {
    private static int max = 500007;;
    static int[] primes = new int[max];

    public static void main(String[] args) {
        sieve();
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        while (tests-- > 0){
            int num = sc.nextInt();
            int count = 0;
            for (int i = 0; i < num; i++) {
                if(primes[i]==1){
                    double rem = Math.sqrt((num - i)/2.0);
                    int i1 = (int) rem;
                    if(Math.ceil(rem) == i1){
                        count++;
//                        System.out.printf("%d = %d + 2 * %fsq",num,i,rem);
//                        System.out.println();
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void sieve(){
        Arrays.fill(primes,1);
        primes[0] = 0;
        primes[1] = 0;
        primes[2] = 1;
        int i = 2;
        for (; i*i < max ; i++) {
            for (int j = 2*i; j < max; j=j+i) {
                primes[j] = 0;
            }
        }
//        for (int j = 0; j < max; j++) {
//            if(primes[j]==1)
//                System.out.printf(" %d ",j);
//        }
    }
}
