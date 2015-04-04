package client;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by mdev on 4/3/15.
 */
public class HackerRank2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        while (testcases != 0) {
            testcases--;
            int n = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            fun(n,a,b);
        }

    }
    public static String SetToString(Set<Integer> set) {
        Iterator<Integer> it = set.iterator();
        if (!it.hasNext())
            return "";

        StringBuilder sb = new StringBuilder();
        for (;;) {
            String e = it.next().toString();
            sb.append(e);
            if (! it.hasNext())
                return sb.toString();
            sb.append(' ');
        }
    }

    public static void fun(int N, int a, int b) {
        Set<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i< N; i++) {
            set.add(a * i + b * (N - i - 1));
        }
        System.out.println(SetToString(set));
    }
}
