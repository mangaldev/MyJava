package leetcode;

public class Prob73 {
    public static void main(String[] args) {
//        setZeroes(new int[][]{{0, 0, 0, 5}, {4, 3, 1, 4}, {0, 1, 1, 4}, {1, 2, 1, 3}, {0, 0, 1, 1}});
        setZeroes(new int[][]{{1, 1, 1}, {0, 1, 2}});
    }

    public static void setZeroes(int[][] matrix) {
        boolean toprow = false;
        boolean firstcol = false;
        int width = matrix[0].length;
        int height = matrix.length;
        for (int i = 0; i < width; i++) {
            if (matrix[0][i] == 0) {
                toprow = true;
                break;
            }
        }
        print(matrix);
        for (int i = 0; i < height; i++) {
            if (matrix[i][0] == 0) {
                firstcol = true;
                break;
            }
        }

        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        print(matrix);
        for (int i = 1; i < width; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < height; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        print(matrix);
        for (int i = 1; i < height; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < width; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (toprow) {
            for (int i = 0; i < width; i++) {
                matrix[0][i] = 0;
            }
        }
        if (firstcol) {
            for (int i = 0; i < height; i++) {
                matrix[i][0] = 0;
            }
        }
        print(matrix);
    }

    public static void print(int[][] matrix) {
        int width = matrix[0].length;
        int height = matrix.length;
        for (int i = 0; i < height; i++) {
            System.out.println();
            for (int j = 0; j < width; j++) {
                System.out.print(" " + matrix[i][j]);
            }
        }
        System.out.println();
    }
}
