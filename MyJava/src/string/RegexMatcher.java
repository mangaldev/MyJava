package string;

/**
 * Created by mdev on 3/27/15.
 */
public class RegexMatcher {

    public static boolean _match(String pat, String text) {
        if (pat.charAt(0) == '^')
            return match(pat.substring(1), text);
        else {
            for (int i = 0; i < text.length(); i++) {
                if (match(pat, text.substring(i)))
                    return true;
            }
        }
        return false;
    }

    public static boolean match(String pat, String text) {
        if (pat == null || pat.length() == 0) {
            if (text.length() > 0)
                return false;
            else
                return true;
        }
        if (text == null || text.length() == 0) {
            if (pat.length() == 1 && pat.charAt(0) == '*')
                return true;
            else
                return false;
        }

        if (pat.charAt(0) == '^')
            return false;
        else if (pat.charAt(0) == '$') {
            if (pat.length() > 1 || text.length() != 0)
                return false;
            else
                return true;
        } else if (pat.charAt(0) == '.')
            return match(pat.substring(1), text.substring(1));
        else if (pat.charAt(0) == '*') {
            boolean b1 = false;
            if (text.length() > 0)
                b1 = match(pat, text.substring(1)) || match(pat.substring(1), text.substring(1));
            boolean b2 = match(pat.substring(1), text);
            return b1 || b2;
        } else if (text.charAt(0) == pat.charAt(0))
            return match(pat.substring(1), text.substring(1));
        else
            return false;

    }

    static {
        boolean b = _match("a.*cd", "abcd");
        System.out.println("b = " + b);

    }

    public static void main(String[] args) {

    }
}
