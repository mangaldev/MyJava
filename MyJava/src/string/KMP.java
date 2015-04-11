package string;

import java.util.Arrays;

/**
 * Created by mdev on 4/12/15.
 */
public class KMP {

    public static void main(String[] args) {
        System.out.println(Arrays.toString( PiTable("abababca")));
        System.out.println(Arrays.toString( PiTable("acacagt")));
    }

    public static int[] PiTable(String pattern){
        int[] pi = new int[pattern.length()];
        for (int i = 1; i < pattern.length(); i++) {
            if(pattern.charAt(i) == pattern.charAt(pi[i-1]))
                pi[i] = pi[i-1] + 1;
            else
                pi[i] = 0;
        }
        return pi;
    }
}
