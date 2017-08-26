package leetcode;

/**
 * Created by mdev on 7/23/17.
 * .
 */
public class Prob5 {
    public static void main(String[] args) {
        final String babad = longestPalindrome("ccc");
        System.out.println("babad = " + babad);
    }

    public static String longestPalindrome(String s) {
        int maxPalindrome = -1;
        String result = null;
        for (int i = 0; i < s.length(); i++) {
            int palindromLength = 1;
            int left = i - 1;
            int right = i + 1;
            while (left >=0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right))
                    palindromLength += 2;
                else
                    break;
                left--;
                right++;
            }
            if (palindromLength > maxPalindrome) {
                maxPalindrome = palindromLength;
                result = s.substring(left + 1, right);
            }
        }
        for (int i = 0; i < s.length() - 1; i++) {
            int palindromLength = 2;
            int center1 = i;
            int center2 = i + 1;
            if (s.charAt(center1) != s.charAt(center2))
                continue;
            int left = center1 - 1;
            int right = center2 + 1;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right))
                    palindromLength += 2;
                else
                    break;
                left--;
                right++;
            }
            if (palindromLength > maxPalindrome) {
                maxPalindrome = palindromLength;
                result = s.substring(left + 1, right);
            }
        }
        return result;
    }
}
