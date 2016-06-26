package hackerrank.euler;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by mdev on 6/25/16.
 */
public class Euler037 {

    public static void main(String[] args) {
        int[] sieve = sieve();
        Scanner  sc = new Scanner(System.in);
        int N = sc.nextInt();
        long result = 0;
        for (int i = 11; i < N; i++) {
            boolean trunctablePrime = true;
            String num = i+"";
            for (int j = 0; j < num.length() && trunctablePrime; j++) {
                String a = num.substring(j);
                if(!a.equals("") && sieve[Integer.valueOf(a)] != 1)
                    trunctablePrime = false;
                String b = num.substring(0,j);
                if(!b.equals("") && sieve[Integer.valueOf(b)] != 1)
                    trunctablePrime = false;
            }
            if(trunctablePrime) {
                System.out.println(i);
                result += i;
            }
        }
        System.out.println(result);
    }

    private static int[]  sieve(){
        int[] arr = new int[1000007];
        Arrays.fill(arr,1);
        arr[0] = 0;
        arr[1] = 0;
        for (int i = 2; i < 1000007/2; i++) {
            for (int j = 2*i; arr[i]==1 && j < 1000007/2; j=j+i) {
                arr[j] = 0;
            }
        }
        return arr;
    }
}
