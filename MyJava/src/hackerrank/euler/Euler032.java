package hackerrank.euler;

import java.util.*;

/**
 * Created by mdev on 6/21/16.
 */
public class Euler032 {
    public static void main(String[] args) {
        Map<Integer,Integer> result = new HashMap<>();
        result.put(4,12);
        result.put(5,52);
        result.put(6,162);
        result.put(7,0);
        result.put(8,13458);
        result.put(9,45228);
        Scanner sc = new Scanner(System.in);
//        int cases = sc.nextInt();
//        while (cases-- > 0) {

//            long total = 0;
            int i = sc.nextInt();
            System.out.println(result.get(i));
//            int limit = 100000000;
//            for (long j = 1; j < limit; j++) {
//                if (!isNumberHasUniqueDigits(j + "", i))
//                    continue;
//                for (long k = j; k < limit; k++) {
//                    if (!isNumberHasUniqueDigits(k + "", i))
//                        continue;
//                    String num = j + "" + k + "" + j * k;
//                    if (num.length() != i)
//                        continue;
//                    if (!isNumberHasUniqueDigits(num, i))
//                        continue;
//                    System.out.printf("%d * %d = %d", j, k, j * k);
//                    System.out.println();
//                    total += j * k;
//                }
//            }
//            System.out.println(total);
//            4->12 5-> 52, 6-> 162, 7->0 , 8-> 13458,
        }
//    }

    private static boolean isNumberHasUniqueDigits(String num, int limit) {
        int[] seen = new int[limit + 1];
        Arrays.fill(seen, 0);
        int watched = 0;
        for (int i = 0; i < num.length(); i++) {
            char o = num.charAt(i);
            int n = o - '0';
            if (n == 0 || n > limit) return false;
            if (seen[n] == 1) return false;
            seen[n] = 1;
            watched++;
        }
//        if (watched == limit)
//            return true;
        return true;
    }
}
