package hackerrank.euler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.text.Collator.getInstance;
import static java.util.Collections.sort;

/**
 * Created by mdev on 6/15/16.
 */
public class Euler022 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int words = sc.nextInt();
        List<String> list = new ArrayList<>();
        while (words-- != 0)
            list.add(sc.next());
        sort(list, getInstance());
        int queries = sc.nextInt();
        while(queries-- != 0){
            String word = sc.next();
            int index = list.indexOf(word) + 1;
            int sum = word.chars().map((codePoint) -> codePoint - 64).sum();
            int result = sum * index;
            System.out.println(result);
        }

    }
}
