package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Prob542 {

    public int[][] updateMatrix(int[][] matrix) {
        Deque<int[]> queue = new LinkedList<>();
        int height = matrix.length;
        int width = matrix[0].length;
        int[][] distance = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while (!queue.isEmpty()) {
            final int[] poll = queue.poll();
            int i = poll[0];
            int j = poll[1];
            if (i - 1 >= 0 && matrix[i - 1][j] == 1 && distance[i - 1][j] > distance[i][j] + 1) {
                distance[i - 1][j] = distance[i][j] + 1;
                queue.offer(new int[]{i - 1, j});
            }
            if (i + 1 < height && matrix[i + 1][j] == 1 && distance[i + 1][j] > distance[i][j] + 1) {
                distance[i + 1][j] = distance[i][j] + 1;
                queue.offer(new int[]{i + 1, j});
            }
            if (j - 1 >= 0 && matrix[i][j - 1] == 1 && distance[i][j - 1] > distance[i][j] + 1) {
                distance[i][j - 1] = distance[i][j] + 1;
                queue.offer(new int[]{i, j - 1});
            }
            if (j + 1 < width && matrix[i][j + 1] == 1 && distance[i][j + 1] > distance[i][j] + 1) {
                distance[i][j + 1] = distance[i][j] + 1;
                queue.offer(new int[]{i, j + 1});
            }
        }
        return distance;
    }
}
