package hackerrank.euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mdev on 6/18/16.
 */
public class Euler026 {

    public static void main(String[] args) {

        int[] precal = new int[10007];
        int[] result = new int[10007];
        precal[0] = 0;
        precal[1] = 0;
        for (int i = 2; i < 10007; i++) {
            precal[i] = cycle(i);
        }
//        for (int i = 0; i < 10; i++) {
//            System.out.println(precal[i]);
//        }
        int maxIndex = 0;
        for (int i = 1; i < 10007; i++) {
            result[i] = maxIndex;
            if(precal[i]> precal[maxIndex]) maxIndex  = i;
        }

//        for (int i = 0; i < 10; i++) {
//            System.out.println(result[i]);
//        }

        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while (cases-- > 0){
            int n = sc.nextInt();
            System.out.println(result[n]);
        }
    }

    private static int cycle(int deno) {
        int[] seen = new int[10007];
        Arrays.fill(seen,0);
        int num = 1,count = 0;
        while(num > 0){
            num = num *10;
            num = num  % deno;
            if(seen[num] == 1)
                break;
            else {
                count++;
                seen[num] = 1;
            }
        }
        return num>0 ? count : 0;
    }
}
