package arrayques;

/**
 * Created by mdev on 4/19/15.
 */
public class SheepCows {
    static int rows= 10;
    static int cols= 10;

    public static void main(String[] args) {

    }
    public int get(String[] grid, int rows, int cols){
        boolean[][] isVisited = new boolean[rows][cols];
        int result = 0;
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(!isVisited[i][j] && grid[i].charAt(j) == 'Y') {
                    isVisited[i][j] = true;
                    result++;
                    update(grid, i, j, isVisited);
                }
            }
        }
        return result;
    }

    public void update(String[] grid, int i , int j, boolean[][] isVisited){
        int rows = grid.length;
        int cols = grid[0].length();
        if((i + 1) < rows && !isVisited[i + 1][j] &&  grid[i + 1].charAt(j) == 'Y'){
            isVisited[i + 1][j] = true;
            update(grid, i + 1, j, isVisited);
        }
        if((i - 1) > 0 && !isVisited[i - 1][j] &&  grid[i - 1].charAt(j) == 'Y'){
            isVisited[i - 1][j] = true;
            update(grid, i - 1, j, isVisited);
        }
        if((j + 1) < cols && !isVisited[i][j + 1] &&  grid[i].charAt(j + 1) == 'Y'){
            isVisited[i][j + 1] = true;
            update(grid, i, j + 1, isVisited);
        }
        if((j - 1) > 0 && !isVisited[i][j - 1] &&  grid[i].charAt(j - 1) == 'Y'){
            isVisited[i][j - 1] = true;
            update(grid, i, j - 1, isVisited);
        }
    }

}
