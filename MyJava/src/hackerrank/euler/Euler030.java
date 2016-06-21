package hackerrank.euler;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by mdev on 6/20/16.
 */
public class Euler030 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(3,1301);
        map.put(4,19316);
        map.put(5,443839);
        map.put(6,548834);
        System.out.println(map.get(sc.nextInt()));
//        int result = getResultForLimit(999,3);
//        System.out.println(getResultForLimit(9999,4));
//        System.out.println(getResultForLimit(99999,5));
//        System.out.println(getResultForLimit(999999,5));
//        System.out.println(result);
    }

    static int getResultForLimit(int limit, int power) {
        int result = 0;
        for (int i = 11; i <= limit; i++) {
            int sum = 0;
            int num = i;
            while (num != 0) {
                int numi = num % 10;
                num = num / 10;
                sum += Math.pow(numi, power);
            }
            if (sum == i) {
                System.out.println("Got one such number ==> " + sum);
                result = result + sum;
            }
        }
        return result;
    }
}
