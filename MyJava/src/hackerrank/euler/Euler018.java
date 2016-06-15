package hackerrank.euler;

import java.util.Scanner;

/**
 * Created by mdev on 6/13/16.
 */
public class Euler018 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int tests = sc.nextInt();
        while (tests-- != 0) {
            execute();
        }
    }

    private static void execute() {
        int N = sc.nextInt();
        int[] prevRow = new int[0];
        for (int i = 0; i < N; i++) {
            int[] currentRow = new int[N];
            for (int j = 0; j <= i; j++) {
                if (i == 0)
                    currentRow[j] = sc.nextInt();
                else
                    currentRow[j] = sc.nextInt() + maximum(prevRow, j, N);

            }
            prevRow = currentRow;
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (max < prevRow[i]) max = prevRow[i];
        }
        System.out.println(max);
    }

    private static int maximum(int[] prevRow, int j, int N) {
        int a = 0;
        if (j - 1 >= 0)
            a = prevRow[j - 1];
        return Math.max(prevRow[j], a);
    }
}
