package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Prob417 {

    public static void main(String[] args) {
//        pacificAtlantic(new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}});
        pacificAtlantic(new int[][]{{1, 1}, {1, 1}, {1, 1}});
    }

    public static List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        Deque<int[]> bfs1 = new LinkedList<>();
        Deque<int[]> bfs2 = new LinkedList<>();
        int height = matrix.length;
        if (height == 0) {
            return result;
        }
        int width = matrix[0].length;
        int[][] mat1 = new int[height][width];
        int[][] mat2 = new int[height][width];
        for (int i = 0; i < height; i++) {
            mat1[i][0] = -1;
            mat2[i][width - 1] = -1;
            bfs1.addLast(new int[]{i,0});
            bfs2.addLast(new int[]{i,width-1});
        }
        for (int j = 0; j < width; j++) {
            mat1[0][j] = -1;
            mat2[height - 1][j] = -1;
            bfs1.addLast(new int[]{0,j});
            bfs2.addLast(new int[]{height-1,j});
        }
        while (bfs1.size() != 0){
            final int[] node = bfs1.removeFirst();
            if(mat1[node[0]][node[1]] == -1){

            }
        }
        return result;
    }


}
