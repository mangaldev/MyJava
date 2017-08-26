package leetcode;

public class Prob415 {
    public String addStrings(String num1, String num2) {
        int i = num1.length(), j = num2.length();
        int carry = 0;
        String result = "";
        for (; i > 0 && j > 0; i--, j--) {
            result = ((num1.charAt(i) + num2.charAt(j) + carry) % 10) + result;
            carry = (num1.charAt(i) + num2.charAt(j) + carry) / 10;
        }
        if (i > 0) {

        }
        return "";
    }
}
