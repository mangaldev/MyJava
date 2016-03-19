package greedy;

/**
 * Created by mdev on 4/28/15.
 */
public class Knapsack {


    public static void main(String[] args) {
        int[] input = {1,3,5,11};
        int boriyan = input.length;
        int sum = 15;
        int[][] result = new int[boriyan+1][sum+1];
        for (int i = 0; i <= 15; i++) {
            result[0][i] = i;
        }
        for (int i = 0; i <= boriyan; i++) {
            result[i][0] = 0;
        }
        for (int i = 1; i <= boriyan; i++) {
            for (int j = 1; j <= sum; j++) {
                int first = Integer.MAX_VALUE;
                if(j/input[i-1] != 0)
                 first = j/input[i-1]+result[i][j%input[i-1]];
                int second = result[i-1][j];
                result[i][j] = Math.min(first,second);
            }
        }
        for (int i = 0; i <= boriyan; i++) {
            System.out.println();
            for (int j = 0; j <= sum; j++) {
                System.out.printf(" %d ", result[i][j]);
            }
        }

    }
}
