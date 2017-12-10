package leetcode;

public class Prob7 {

    public static void main(String[] args) {
        System.out.println(reverse(123));
    }

    public static int reverse(int x) {
        int result = 0;
        int multiplier = 1;
        boolean flag = false;
        while (x > 0){
            int rem = x %10;
            result += rem*multiplier;
            multiplier *= 10;
            x = x / 10;
        }
        return result;
    }
}
