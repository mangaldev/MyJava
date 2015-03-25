package greedy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mdev on 3/14/15.
 */
public class EightPuzzle {
    private final int getHeuristic(int[][] arr) {
        int count = 0;
        int[] result = new int[8];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int current = arr[i][j];
                if (current == 0)
                    continue;
                result[current - 1] = 1;
                int temp = 0;
                for (int k = 0; k < 8; k++) {
                    if (result[k] != 1 && k < current)
                        temp++;
                }
                count = count + temp;
            }
        }
        return count;
    }

    public void print(int[][] arr) {
        for (int i = 0; i < 3; i++) {
            System.out.println();
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + arr[i][j]);
            }
        }
        System.out.println();
    }

    Set<String> cache = new HashSet<>();
    Deque<String> directions = new ArrayDeque<>();

    public boolean solve(int[][] arr, int i, int j, String lastDir) {
        if (cache.contains(getHash(arr)))
            return false;
        else
            cache.add(getHash(arr));
        System.out.println();
        System.out.println("Sovling for i : " + i + " j : " + j + " Dir : " + lastDir);
        print(arr);
        int h = getHeuristic(arr);
        System.out.println("h = " + h);
        directions.addLast(lastDir);
        if (h == 0 && "123456780".equalsIgnoreCase(getHash(arr))) {
            System.out.println("SOLVED");
            return true;
        }

        if (i - 1 >= 0 && !"DOWN".equalsIgnoreCase(lastDir)) {
            arr[i][j] = arr[i - 1][j];
            arr[i - 1][j] = 0;
            int h1 = getHeuristic(arr);
            System.out.println("h1 = " + h1);

            if (h1 <= h) {
                if (solve(arr, i - 1, j, "UP"))
                    return true;

            }

            arr[i - 1][j] = arr[i][j];
            arr[i][j] = 0;
        }

        if (i + 1 <= 2 && !"UP".equalsIgnoreCase(lastDir)) {
            arr[i][j] = arr[i + 1][j];
            arr[i + 1][j] = 0;
            int h2 = getHeuristic(arr);
            System.out.println("h2 = " + h2);
            if (h2 <= h) {
                if (solve(arr, i + 1, j, "DOWN"))
                    return true;
            }
            arr[i + 1][j] = arr[i][j];
            arr[i][j] = 0;
        }

        if (j - 1 >= 0 && !"RIGHT".equalsIgnoreCase(lastDir)) {
            arr[i][j] = arr[i][j - 1];
            arr[i][j - 1] = 0;
            int h3 = getHeuristic(arr);
            System.out.println("h3 = " + h3);
            if (h3 <= h) {
                if (solve(arr, i, j - 1, "LEFT"))
                    return true;
            }
            arr[i][j - 1] = arr[i][j];
            arr[i][j] = 0;
        }

        if (j + 1 <= 2 && !"LEFT".equalsIgnoreCase(lastDir)) {
            arr[i][j] = arr[i][j + 1];
            arr[i][j + 1] = 0;
            int h4 = getHeuristic(arr);
            System.out.println("h4 = " + h4);
            if (h4 <= h) {
                if (solve(arr, i, j + 1, "RIGHT"))
                    return true;

            }
            arr[i][j + 1] = arr[i][j];
            arr[i][j] = 0;
        }
        directions.removeLast();
        return false;

    }

    public static void main(String... args) {
//        int[][] input = {{7, 2, 4}, {5, 0, 6}, {8, 3, 1}};
//        int[][] input = {{1,2,3},{4,8,5},{7,0,6}};
//        int[][] input = {{1,2,3},{8,0,5},{4,7,6}};//Change position of 0 too
        int[][] input = {{1, 5, 0}, {8, 3, 2}, {4, 7, 6}};

        EightPuzzle puzzle = new EightPuzzle();
        int heuristic = puzzle.getHeuristic(input);
        if (heuristic % 2 == 0) {
            puzzle.solve(input, 0, 2, "");
            System.out.println(puzzle.directions.toString());
        } else {
            System.out.println("Not Solvable");
        }
        System.out.println("END");
    }

    private String getHash(int[][] arr) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(arr[i][j]);
            }
        }
        return sb.toString();

    }
}
