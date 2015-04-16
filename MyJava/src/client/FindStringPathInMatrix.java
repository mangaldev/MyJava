package client;

/**
 * Created by mdev on 4/15/15.
 */
public class FindStringPathInMatrix {

    static int rows = 3;
    static int cols = 4;

    public static void main(String[] args) {
        char[][] mat = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        
        boolean result = false;
        String input = "BCCEDD";
        for (int i = 0; i < cols; i++) {
            if(!result)
                result = exists(mat, input, 0, i);
        }
        for (int i = 0; i < cols; i++) {
            if(!result)
                result = exists(mat,input, rows - 1, i);
        }
        for (int i = 0; i < rows; i++) {
            if(!result)
                result = exists(mat, input, i, 0);
        }
        for (int i = 0; i < rows; i++) {
            if(!result)
                result = exists(mat,input, i, cols-1);
        }
        System.out.println(result);

    }

    public static boolean exists(char[][] mat, String str, int i, int j) {
        if (i == rows || i < 0 || j == cols || j < 0)
            return false;

        if (str.length() == 0)
            return true;

        if (mat[i][j] != '0' && mat[i][j] == str.charAt(0)) {
            char temp = mat[i][j];
            mat[i][j] = '0';

            if (exists(mat, str.substring(1), i + 1, j))
                return true;

            if (exists(mat, str.substring(1), i - 1, j))
                return true;

            if (exists(mat, str.substring(1), i, j - 1))
                return true;

            if (exists(mat, str.substring(1), i, j + 1))
                return true;

            mat[i][j] = temp;
        }
        return false;
    }
}
