package arrayques;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by mdev on 4/14/15.
 */
public class NextBiggerNumberInArray {
    public static void main(String[] args) {
//        int[] result = getNextBiggerArr(new int[]{1, 10, 9, 100, 8, 11, 2, 5, 20});
        int[] result1 = getNextBiggerArr1(new int[]{1,10,9,100,8,11,2,5,20});

//        THIS IS CORRECT APPROACH
        int[] result2 = getNextBiggerArr2(new int[]{1, 10, 9, 100, 8, 11, 2, 5, 20});

//        for (int i = 0; i < result.length; i++) {
//            System.out.printf(" %d ",result[i]);
//        }
        System.out.println();
        for (int i = 0; i < result1.length; i++) {
            System.out.printf(" %d ",result1[i]);
        }
        System.out.println();
        for (int i = 0; i < result2.length; i++) {
            System.out.printf(" %d ",result2[i]);
        }
    }

    public static int[] getNextBiggerArr(int[] input){
        for (int i = 0; i < input.length; i++) {
            for (int j = i+1; j < input.length; j++) {
                if(input[j] > input[i]){
                    while(i!=j) {
                        input[i] = input[j];
                        i++;
                    }
                }
            }
        }

        return input;
    }

    public static int[] getNextBiggerArr1(int[] input){
        int p1 = 0;
        int p2 = 1;
        while(p1 < input.length) {
            if(p2 == input.length)
                p2 = p1+1;
            while (p2 < input.length) {
                if (input[p2] > input[p1]) {
                    while (p1 != p2) {
                        input[p1] = input[p2];
                        p1++;
                    }
                }
                p2++;
            }
            input[p1] = -1;
            p1++;
        }
        if (p1 < input.length) {
            input[p1++] = -1;
        }
        return input;
    }

    public static int[] getNextBiggerArr2(int[] input){
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 1; i < input.length; i++) {
            while(true && !stack.isEmpty()){
                if(input[stack.peek()]<input[i]){
                    input[stack.pop()] = input[i];
                }
                else{
                    break;
                }
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            input[stack.pop()] = -1;
        }
        return input;
    }


}
