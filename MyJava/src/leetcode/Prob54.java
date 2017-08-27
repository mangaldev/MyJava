package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Prob54 {
    public static void main(String[] args) {
//        new Prob54().spiralOrder(new int{{1,2,3},{4,5,6},{7,8,9}});
        new Prob54().spiralOrder(new int[][]{{1},{2}});
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0)
            return result;
        int height = matrix.length;
        int width = matrix[0].length;
        int total = height * width;
        int count = 0;
        int top = 0;
        int left = 0;
        int bottom = height - 1;
        int right = width - 1;
        while(true){
            for(int i = left ; i <= right; i++){
                result.add(matrix[top][i]);
                count++;
            }
            top++;
            if(count >= total) break;
            for(int i = top ; i <= bottom  ; i++){
                result.add(matrix[i][right]);
                count++;
            }
            right--;
            if(count >= total) break;
            for(int i = right ; i >= left ; i--){
                result.add(matrix[bottom][i]);
                count++;
            }
            bottom--;
            if(count >= total) break;
            for(int i = bottom ; i>= top;i--){
                result.add(matrix[i][left]);
                count++;
            }
            left++;
            if(count >= total) break;
        }

        return result;
    }
}
