package game;

/**
 * Created by mdev on 3/25/15.
 */

public class SudokuSolver {

    public boolean isSafeHorizontally(int[][] board, int row, int column){
        for (int i = 0; i < 9; i++) {
            if(i != column){
                if(board[row][i] == board[row][column])
                    return false;
            }
        }
        return true;
    }

    public boolean isSafeVertically(int[][] board, int row, int column){
        for (int i = 0; i < 9; i++) {
            if(i != row){
                if(board[i][column] == board[row][column])
                    return false;
            }
        }
        return true;
    }

    public boolean isSafeInBox(int[][] board, int row, int column){
        int x = row/3;
        int y = column/3;
        for (int i = x*3; i < x*3 + 3; i++) {
            for (int j = y*3; j < y*3+3; j++) {
                if(i != row && j!=column){
                    if(board[i][j] == board[row][column])
                        return false;
                }
            }
        }
        return true;
    }

    public void printBoard(int[][] board){
        System.out.println("");
        System.out.println("===============================================");
        for (int i = 0; i < 9; i++) {
            System.out.println();
            for (int j = 0; j < 9; j++) {
                System.out.printf(" %d ",board[i][j]);
            }
        }
    }

    public int findBlankPosition(int[][] board){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] == 0)
                    return i*10 + j;
            }
        }
        return -1;
    }

    public void solve(int[][] board) {
        int position = findBlankPosition(board);
        if ( position == -1) {
            printBoard(board);
            return;
        }
        int i = position/10;
        int j = position%10;
        for (int k = 1; k <= 9; k++) {
            board[i][j] = k;
            if (isSafeHorizontally(board, i, j) && isSafeVertically(board, i, j) && isSafeInBox(board, i, j)) {
                solve(board);
            }
        }
        board[i][j] = 0;
    }


    public static void main(String... args) {
        SudokuSolver prob = new SudokuSolver();
        int[][] board = {   {3, 0, 6, 5, 0, 8, 4, 0, 0},
                            {5, 2, 0, 0, 0, 0, 0, 0, 0},
                            {0, 8, 7, 0, 0, 0, 0, 3, 1},
                            {0, 0, 3, 0, 1, 0, 0, 8, 0},
                            {9, 0, 0, 8, 6, 3, 0, 0, 5},
                            {0, 5, 0, 0, 9, 0, 6, 0, 0},
                            {1, 3, 0, 0, 0, 0, 2, 5, 0},
                            {0, 0, 0, 0, 0, 0, 0, 7, 4},
                            {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        prob.solve(board);
    }

}
