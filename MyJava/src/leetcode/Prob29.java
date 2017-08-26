package leetcode;

/**
 * Created by mdev on 7/23/17.
 */
public class Prob29 {
    public static void main(String[] args) {
        final int divide = divide(-2147483648, -1);
        System.out.println("divide = " + divide);
    }
    public static int divide(int dividend, int divisor) {
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            return dividend * -1;
        }
        boolean isNegative1 = false;
        boolean isNegative2 = false;
        if (dividend < 0) {
            isNegative1 = true;
            dividend = dividend * -1;
        }
        if (divisor < 0) {
            isNegative2 = true;
            divisor = divisor * -1;
        }

        int count = 0;
        while (dividend - divisor >= 0) {
            count++;
            dividend = dividend - divisor;
        }
        if (isNegative1 && isNegative2) {
            return count;
        } else if (isNegative1 || isNegative2)
            return count * -1;
        else
            return count;
    }
}
