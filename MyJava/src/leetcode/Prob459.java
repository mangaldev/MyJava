package leetcode;

public class Prob459 {

    public static void main(String[] args) {
        final boolean abab = repeatedSubstringPattern("aabaaba");
        System.out.println("abab = " + abab);

    }

    public static boolean repeatedSubstringPattern(String word) {
        for (int i = 1; i <= word.length() / 2; i++) {
            String lastString = null;
            boolean possible = true;
            if(word.length() % i != 0) continue;
            for (int j = 0; j < word.length(); j = j + i) {

                if ((j + i) > word.length()) {
                    possible = false;
                    break;
                }
                final String substring = word.substring(j, j + i);
                if (lastString == null) {
                    lastString = substring;
                    continue;
                }
                if (!lastString.equalsIgnoreCase(substring)) {
                    possible = false;
                    break;
                }
            }
            if (possible)
                return true;
        }
        return false;
    }
}
