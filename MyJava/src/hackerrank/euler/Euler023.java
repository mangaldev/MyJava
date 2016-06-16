package hackerrank.euler;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by mdev on 6/15/16.
 */
public class Euler023 {


    private static int getDivisorsSum(int n){
        if(n == 1) return 0;
        int j = 2;
        int result = 1;
        for (; j*j < n ; j++) {
            if (n % j == 0) {
                result += j + n/j;
            }
        }
        if(j*j == n){
            result = result + j;
        }
        return result;
    }

    private static Map<Integer, Integer> getAbundantIntegerMap() {
         Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 1; i <= 100000; i++) {
            int divisorsSum = getDivisorsSum(i);
            if(divisorsSum > i)
                map.put(i, divisorsSum);
        }
        return map;
    }



    public static void main(String[] args) {
        Map<Integer, Integer> abundantIntegerMap = getAbundantIntegerMap();
        System.out.println("abundantIntegerMap = " + abundantIntegerMap);
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while(cases-- != 0){
            int num = sc.nextInt();
            for(Integer key : abundantIntegerMap.keySet()){
                if(key > num){
                    System.out.println("NO");
                    break;
                }
                if(abundantIntegerMap.containsKey(num-key)) {
                    System.out.println("YES");
                    break;
                }
            }
        }
    }
}
