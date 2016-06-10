package gauravbond;

import java.util.Scanner;

/**
 * Created by mdev on 4/30/16.
 */
public class PathFinderInMatrixWithSpecials {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int specialsCount = numberof1sinMatrix(matrix, rows, cols);
        int[][][] result = new int[rows][cols][specialsCount+1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 && j == 0) {
                    if (matrix[i][j] == 0)
                        result[i][j][0] = 1;
                    else
                        result[i][j][1] = 1;
                } else
                    transformResults(matrix, result, i, j, specialsCount);

            }
        }
        int[] finalResult = result[rows - 1][cols - 1];
        for (int i = 0; i < finalResult.length; i++) {
            System.out.println(i+" -> "+finalResult[i]);
        }

    }

    private static void transformResults(int[][] matrix, int[][][] result, int i, int j, int z) {
        result[i][j] = new int[z+1];
        int[] upperCellResult = new int[z+1];
        int[] leftCellResult = new int[z+1];
        if (i > 0)
            upperCellResult = result[i - 1][j];
        if (j > 0)
            leftCellResult = result[i][j - 1];

        if (matrix[i][j] == 0) {
            for (int k = 0; k <= z; k++)
                result[i][j][k] = upperCellResult[k] + leftCellResult[k];
        } else {
            for (int k = 1; k <= z; k++)
                result[i][j][k] = upperCellResult[k - 1] + leftCellResult[k - 1];
        }
    }


    private static int numberof1sinMatrix(int[][] matrix, int rows, int cols) {
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1)
                    count++;
            }
        }
        return count;
    }


}
