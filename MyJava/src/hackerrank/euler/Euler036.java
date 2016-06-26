package hackerrank.euler;

import java.util.Scanner;

/**
 * Created by mdev on 6/25/16.
 */
public class Euler036 {
    public static void main(String[] args) {
        boolean[] palindromes = new boolean[1000007];
        for (int i = 0; i < palindromes.length; i++) {
            palindromes[i] = isPalindrome(i+"");
        }
        Scanner sc  = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        long result = 0;
        for (int i = 1; i < N; i++) {
            if(palindromes[i] && isPalindrome( Integer.toString(i,K))){
                result += i;
            }
        }
        System.out.println(result);
    }

    static boolean isPalindrome(String n) {
        return new StringBuilder(n).reverse().toString().equals(n +"");
    }
}
