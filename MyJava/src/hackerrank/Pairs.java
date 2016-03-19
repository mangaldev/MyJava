package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by mdev on 5/10/15.
 */
public class Pairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int k = sc.nextInt();
        int[] input = new int[total];
        int count = 0;
        while(count !=total){
            input[count++] = sc.nextInt();
        }
        System.out.println(findPairs(input,k));
    }

    public static int findPairs(int[] input, int K){
        int count = 0;
        Arrays.sort(input);
        for (int i = 0; i < input.length - 1; i++) {
            int first = input[i];
            int second = Arrays.binarySearch(input,i+1,input.length,K + first);
            if(second>=0){
                count++;
            }
        }
        return count;
    }
}
