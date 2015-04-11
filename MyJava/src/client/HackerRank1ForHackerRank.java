package client;

import java.util.Scanner;

/**
 * Created by mdev on 4/11/15.
 */

public class HackerRank1ForHackerRank {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
         int[][] input = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                input[i][j] = 0;
            }
        }
        for (int i = 0; i < K; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            input[x][y] = 1;
        }
        System.out.println(count(input,N));
    }

    public  static int count(int[][] mat,int N){
        int count = 0;
        boolean result[][] = new boolean[N][N];
        for (int i = 0; i <N; i++) {
            for (int j = 0; j < N; j++) {
                if(mat[i][j] == 1)
                    result[i][j] = false;
                else
                    result[i][j] = true;
            }
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if(mat[i][j] == 1)
                    break;
                result[i][j] = false ;
            }

            for (int j = mat.length - 1; j >=0 ; j--) {
                if(mat[i][j] == 1)
                    break;
                result[i][j] = false ;
            }
        }


        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if(mat[j][i] == 1)
                    break;
                result[j][i] = false ;
            }

            for (int j = mat.length - 1; j >=0 ; j--) {
                if(mat[j][i] == 1)
                    break;
                result[j][i] = false ;
            }
        }

        for (int i = 1; i < N-1; i++) {
            for (int j = 1; j < N-1; j++) {
                if(result[i][j])
                {
                    count++;
                }
            }
        }
        return count;
    }




}
