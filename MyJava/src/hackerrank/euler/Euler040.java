package hackerrank.euler;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by mdev on 6/26/16.
 */
public class Euler040 {

    static Map<Integer,Long> map = new TreeMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long count = 10;
        map.put(0,0L);
        map.put(1,9L);
        for (int i = 2; i < 18; i++) {
            map.put(i, map.get(i-1)+ 9*i*count);
            count *= 10;
        }
//        System.out.println("map = " + map);
        int cases = sc.nextInt();
        while (cases-- > 0){
            int result = 1;
            for (int i = 0; i < 7; i++) {
                result *= getCharacterAtPosition(sc.nextLong());
            }
            System.out.println(result);
        }
    }

    private static Integer getCharacterAtPosition(long position) {
        int rangeKey = 18;
        for(int key : map.keySet()){
            if(map.get(key)>=position) {
                rangeKey = key;
                break;
            }
        }
        position = position - map.get(rangeKey-1);
        long l = (position - 1) / rangeKey;
        long num = (long) (Math.pow(10,rangeKey-1) + l);
        System.out.println("num = " + num);
        int charPositionInNum = (int) ((position-1)%rangeKey);
        char c = (num+"").charAt(charPositionInNum);
        return c - '0';
    }
}
