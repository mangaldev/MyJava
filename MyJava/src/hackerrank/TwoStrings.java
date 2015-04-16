package hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by mdev on 4/13/15.
 */
public class TwoStrings {
    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        while(testcases-- != 0){
            String ans = count(sc.next(),sc.next());
            System.out.println(ans);
        }
    }

    public static String  count(String str1,String str2){
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str1.length(); i++) {
            set.add(str1.charAt(i));
        }
        for (int i = 0; i < str2.length(); i++) {
            if(set.contains(str2.charAt(i))) {
                return "YES";
            }
        }
        return "NO";

    }
}
