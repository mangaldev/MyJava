package leetcode;

public class Prob649 {

    public static void main(String[] args) {
        final String s = new Prob649().predictPartyVictory("RDD");
        System.out.println("s = " + s);
    }

    public static String removeNextChar(String test, Character c, int index) {
        for (int i = index + 1; i < test.length(); i++) {
            if (test.charAt(i) == c) {
                return test.substring(0, i) + test.substring(i + 1);
            }
        }
        return test;
    }

    public String predictPartyVictory(String senate) {
        int rCount = 0;
        int dCount = 0;
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R')
                rCount++;
            else
                dCount++;
        }
        int index = 0;
        while (rCount != 0 && dCount != 0) {
            if (index == senate.length()) {
                index = 0;
            }
            if (senate.charAt(index) == 'R') {
                senate = removeNextChar(senate, 'D', index);
                dCount--;
            }
            else {
                senate = removeNextChar(senate, 'R', index);
                rCount--;
            }
            index++;
        }
        if (dCount > 0) return "Dire";
        else return "Radiant";

    }

}
