package hackerrank.euler;

import java.util.Scanner;

/**
 * Created by mdev on 7/8/16.
 */
public class Euler047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int count = 0;
        for (int i = 14; i < N+K; i++) {
            if(numHasDistinctKPrime(i,K)){
                count++;
                if(count >= K){
                    System.out.println(i-K+1);
                }
            }
            else
                count = 0;
        }
    }

    private static boolean numHasDistinctKPrime(int n, int k) {
        return numberOfDistinctFactors(n) == k;
    }

    private static int numberOfDistinctFactors(int n) {
        int num = n;
        int factors = 0;
        if(n%2==0)
            factors = 1;
        while(n%2 == 0){
            n = n/2;
        }
        for (int i = 3 ; i <= Math.sqrt(n); i=i+2) {
            if(n%i ==0)  factors++;
            while (n%i ==0 ){
                n = n/i;
            }
        }
        if(n>2)
            factors++;
//        System.out.printf("Factors of %d are %d",num,factors);
//        System.out.println();
        return factors;
    }
}
