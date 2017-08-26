package leetcode;

public class Prob43 {
    public static void main(String[] args) {
        System.out.println(multiply("0", "0"));
    }

    public static String multiply(String num1, String num2) {
        String result = "";
        for (int i = num1.length() - 1,j = 0; i >= 0; i--,j++) {
            int dig = num1.charAt(i) - '0';
            String multipliedByDigit = mul(num2, dig);
            for (int k = 0; k < j; k++) {
                multipliedByDigit = multipliedByDigit+"0";
            }
            result = sum(result, multipliedByDigit);
        }
        if(isAllZeroes(result))
            return "0";
        return result;
    }

    public static boolean isAllZeroes(String num){
        for (int i = 0; i < num.length(); i++) {
            if(num.charAt(i)!= '0')
                return false;
        }
        return true;
    }

    public static String sum(String num1, String num2) {
        int carry = 0;
        int i, j;
        String result = "";
        for (i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int m = carry;
            if (i >= 0)
                m += (num1.charAt(i) - '0');
            if (j >= 0)
                m += (num2.charAt(j) - '0');
            result = m % 10 + result;
            carry = m / 10;
        }
        if (carry != 0) {
            result = carry + result;
        }
        return result;
    }

    public static String mul(String num, int dig) {
        int carry = 0;
        String result = "";
        for (int i = num.length() - 1; i >= 0; i--) {
            int m = dig * (num.charAt(i) - '0') + carry;
            result = (m % 10) + result;
            carry = m / 10;
        }
        if (carry != 0) {
            result = carry + result;
        }
        return result;
    }
}
