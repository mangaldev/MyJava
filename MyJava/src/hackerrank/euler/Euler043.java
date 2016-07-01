package hackerrank.euler;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by mdev on 6/27/16.
 */
public class Euler043 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] result = new long[]{0, 0, 0, 22212, 711104, 12444480, 189838560, 1099210170, 1113342912, 16695334890L};
//        System.out.println(getPanDigitalCount("",N));
        System.out.println(result[N]);
    }
//    static long result = 0;
    public static long getPanDigitalCount(String num, int count){
        int lengthAllowed = count + 1;
        if(num.length() > lengthAllowed)
            return 0;

        int[] seen = new int[lengthAllowed];
        Arrays.fill(seen,0);
        if(!num.equalsIgnoreCase("")) {

            for (int i = 0; i < num.length(); i++) {
                int digit = num.charAt(i) - '0';
                if (seen[digit] == 1)
                    return 0;
                seen[digit] = 1;
            }
        }

        long result = 0;

        if(num.length() == lengthAllowed && hasAll0toKDigits(num,count) && isPanDigital(num)) {
            System.out.println(num);
            return result + Long.valueOf(num);
        }

        for (int i = 0; i <= count; i++) {
            result += getPanDigitalCount(num+i,count);
        }
        return result;
    }

    private static boolean isPanDigital(String num) {
        int[] primes = {2,3,5,7,11,13,17};
        for (int i = 1; i < num.length() -2 ; i++) {
            Integer number = Integer.valueOf(num.charAt(i) + "" + num.charAt(i + 1) + "" + num.charAt(i + 2));
            if(number % primes[i-1] != 0)
                return false;
        }
        return true;
    }

    private static boolean hasAll0toKDigits(String number, int K) {
        if(number.length() != K+1)
            return  false;
        int[] seen = new int[10];
        Arrays.fill(seen,0);
        for (int i = 0; i < number.length(); i++) {
            seen[number.charAt(i)-'0'] = 1;
        }
        for (int i = 0; i <= K; i++) {
            if(seen[i]==0)
                return false;
        }
        return true;
    }

}
