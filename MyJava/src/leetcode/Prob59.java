package leetcode;

public class Prob59 {
    public static void main(String[] args) {
        generateMatrix(4);
    }
    public static  int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        int count = 0;
        int top = 0;
        int bottom = n-1;
        int left  = 0;
        int right = n-1;
        while (count < n*n){
            for (int i = left; i <= right ; i++) {
                mat[top][i] = ++count;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                mat[i][right] = ++count;
            }
            right--;
            for (int i = right; i >= left; i--) {
                mat[bottom][i] = ++count;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                mat[i][left] = ++count;
            }
            left++;
        }
        print(mat);
        return mat;
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
