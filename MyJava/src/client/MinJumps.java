package client;

import java.io.BufferedWriter;
import java.util.Scanner;

/**
 * Created by mdev on 4/14/15.
 */
public class MinJumps {
    public static void main(String[] args){
        int arr[] = {1, 3, 6, 1, 0, 9};
        int result = minJumps(arr);
        System.out.println("result = " + result);
    }
    static int minJumps(int[] arr) {
        int[] jumps = new int[arr.length];
        jumps[0] = 0;
        for (int i = 1; i <arr.length; i++) {
            jumps[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if(j + arr[j] >= i && jumps[j]!=Integer.MAX_VALUE){
                    jumps[i] = Math.min(jumps[i],jumps[j]+1);
                }
            }
        }
        return jumps[arr.length - 1];

    }

}
