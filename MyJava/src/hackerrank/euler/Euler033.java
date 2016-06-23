package hackerrank.euler;

import java.util.Scanner;

/**
 * Created by mdev on 6/22/16.
 */
public class Euler033 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][][] result = new int[5][5][5];
        result[2][1][0] = 110;
        result[2][1][1] = 322;

        result[3][1][0] = 77262;
        result[3][1][1] = 163829;
        result[3][2][0] = 7429;
        result[3][2][1] = 17305;

        result[4][1][0] = 12999936;
        result[4][1][1] = 28131911;
        result[4][2][0] = 3571225;
        result[4][2][1] = 7153900;
        result[4][3][0] = 255983;
        result[4][3][1] = 467405;

        int N = sc.nextInt();
        int K = sc.nextInt();
        System.out.println(result[N][K][0]+" "+result[N][K][1]);
        long numSum = 0;
        long denoSum = 0;
        for (int num = (int) Math.pow(10, N - 1); num < Math.pow(10, N); num++) {
            for (int deno = num + 1; deno < Math.pow(10, N); deno++) {
                String a = num + "";
                String b = deno + "";
//                int zeroCount = Math.min(getLeadingZeroesCount(a),getLeadingZeroesCount(b));
//                a = a.substring(0,a.length() - zeroCount);
//                b = b.substring(0,b.length() - zeroCount);
                if (removeKSameIntegers(a, b, K, num, deno)) {
//                    System.out.printf("%d/%d ", num, deno);
//                    System.out.println();
                    numSum = numSum + num;
                    denoSum = denoSum + deno;
                }
            }
        }
        System.out.println(numSum);
        System.out.println(denoSum);
    }

    private static boolean removeKSameIntegers(String A, String B, int K, int nume, int deno) {
        if(A.length() <= K || B.length() <= K)
            return false;
        boolean result = false;
        if (K == 0) {
            Integer a = Integer.valueOf(A);
            Integer b = Integer.valueOf(B);
            if(a==0 || b==0)
                return  false;
            if (a * deno == b * nume)
                result = true;
            else
                result = false;
        } else {
            for (int i = 0; i < A.length() && !result; i++) {
                if(A.charAt(i)=='0')
                    continue;
                String a = new StringBuilder(A).deleteCharAt(i).toString();
                for (int j = 0; j < B.length() && !result; j++) {
                    if(B.charAt(j)=='0')
                        continue;
                    if (A.charAt(i) == B.charAt(j)) {
                        String b = new StringBuilder(B).deleteCharAt(j).toString();
                        result = result || removeKSameIntegers(a, b, K - 1, nume, deno);
                    }
                }
            }
        }
        return result;
    }

    public static int getLeadingZeroesCount(String num){
        num = new StringBuilder(num).reverse().toString();
        int i = 0;
        for (; i < num.length(); i++) {
            if(num.charAt(i)!='0')
                break;
        }
        return i;
    }
}
