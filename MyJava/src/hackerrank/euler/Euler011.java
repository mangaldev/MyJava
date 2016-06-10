package hackerrank.euler;


import java.util.Scanner;

public class Euler011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] mat = new int[20][20];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (j < 17)
                    max = Integer.max(max, mat[i][j] * mat[i][j + 1] * mat[i][j + 2] * mat[i][j + 3]);
                if (i < 17)
                    max = Integer.max(max, mat[i][j] * mat[i + 1][j] * mat[i + 2][j] * mat[i + 3][j]);
                if (i < 17 && j < 17)
                    max = Integer.max(max, mat[i][j] * mat[i + 1][j + 1] * mat[i + 2][j + 2] * mat[i + 3][j + 3]);
                if (i < 17 && j >= 3)
                    max = Integer.max(max, mat[i][j] * mat[i + 1][j - 1] * mat[i + 2][j - 2] * mat[i + 3][j - 3]);
            }
        }
        System.out.println(max);
    }


}
