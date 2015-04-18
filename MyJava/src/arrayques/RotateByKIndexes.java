package arrayques;

import java.util.Arrays;

/**
 * Created by mdev on 4/18/15.
 */
public class RotateByKIndexes {
    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4,5,6,7,8};
        int k  = 2;
        print(input);
        rotate(input, 0, input.length);
        rotate(input,0, k);
        rotate(input,k,input.length);
        print(input);

    }

    public static void print(int[] input) {
        System.out.println();
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i]+" ");
        }
    }

    public static void rotate(int[] arr, int start, int end) {
        int mid = start  + (end - start)/2;
        int count = 0;
        for (int i = start; i < mid; i++) {
            int temp = arr[i];
            arr[i] = arr[end - count - 1];
            arr[end - count - 1] = temp;
            count++;
        }
    }
}
