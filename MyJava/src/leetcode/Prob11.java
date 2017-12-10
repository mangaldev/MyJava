package leetcode;

public class Prob11 {
    public int maxArea(int[] height) {
        if (height.length == 0)
            return 0;
        int f = 0;
        int b = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (f < b) {
            int vol = 0;
            if (height[f] < height[b]) {
                vol = (b - f) * height[f];
                f++;
            } else {
                vol = (b - f) * height[b];
                b--;
            }
            if (vol > max) {
                max = vol;
            }
        }
        return max;
    }
}
