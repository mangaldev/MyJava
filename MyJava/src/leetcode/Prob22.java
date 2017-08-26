package leetcode;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Prob22 {
    Set<String> result = new LinkedHashSet<>();

    public static void main(String[] args) {
        Prob22 prob = new Prob22();
        final List<String> strings = prob.generateParenthesis(4);
        System.out.println("strings = " + strings);

    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        recursive("", n,0,0);
        list.addAll(result);
        return list;
    }

    private void recursive(String word, int n, int openCount, int closeCount) {
        if (word.length() == n * 2) {
            result.add(word);
            return;
        }
        if (openCount < n)
            recursive(word + "(", n, openCount+1, closeCount);
        if (closeCount < n && closeCount < openCount)
            recursive(word + ")", n, openCount, closeCount+1);
    }
}
