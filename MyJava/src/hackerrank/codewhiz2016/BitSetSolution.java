package hackerrank.codewhiz2016;

import java.util.BitSet;
import java.util.Scanner;

/**
 * Created by mdev on 3/8/16.
 */
public class BitSetSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bits = sc.nextInt();
        int count = sc.nextInt();
        BitSet[] arr = new BitSet[3];
        arr[1] = new BitSet(bits);
        arr[2] = new BitSet(bits);
        while(count-- != 0){
            String operation = sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(operation.equals("AND")){
                 arr[a].and(arr[b]);
            }
            else if(operation.equals("SET")){
                arr[a].set(b);
            }
            else if(operation.equals("FLIP")){
                arr[a].flip(b);
            }
            else if(operation.equals("XOR")){
                arr[a].xor(arr[b]);
            }
            else
                arr[a].or(arr[b]);
            System.out.println(arr[1].cardinality()+" "+arr[2].cardinality());
        }
    }
}
