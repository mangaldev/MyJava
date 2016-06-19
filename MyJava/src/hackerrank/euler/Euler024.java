package hackerrank.euler;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by mdev on 6/16/16.
 */
public class Euler024 {
    static List<Long> list = IntStream.rangeClosed(1, 15).mapToObj(Euler024::fact).collect(Collectors.toList());

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = "abcdefghijklm";
        int cases = sc.nextInt();
        while (cases-- != 0){
            long N = sc.nextLong();
            System.out.println(calculateWordOnRank(word,N-1));
        }
    }

    private static String calculateWordOnRank(String word, long N) {
        if(N == 0) return word;
        if(word.equals(""))
            return "";
        int len = word.length();
        int index = 0;
        while(list.get(len-2) <= N){
            N = N - list.get(len -2);
            index++;
        }
        return word.charAt(index) + calculateWordOnRank(new StringBuilder(word).deleteCharAt(index).toString(),N);

    }

    static Long fact(int n) {
        return IntStream.rangeClosed(1,n).mapToObj(Long::new).reduce((x, y) -> x*y).get();
    }
}
