/*
 * Given a string, find the minimum number of characters to be inserted to convert it to palindrome.

Before we go further, let us understand with few examples:
    ab: Number of insertions required is 1. bab
    aa: Number of insertions required is 0. aa
    abcd: Number of insertions required is 3. dcbabcd
    abcda: Number of insertions required is 2. adcbcda which is same as number of insertions in the substring bcd(Why?).
    abcde: Number of insertions required is 4. edcbabcde
 */

package client;

import java.util.Scanner;

public class MinInsertionPalindrome {
    static Scanner s;

    public MinInsertionPalindrome() {
        super();
    }

    public static void main(String args[]) {
        s = new Scanner(System.in);
        System.out.println("Enter INput");
        String strInput = "abcda";
        System.out.println("INput taken as " + strInput);
        int iResult = findMinNoOfInsertions(strInput);
        System.out.println(iResult);
    }

    public static int findMinNoOfInsertions(String strInput) {
        if (strInput.length() == 1)
            return 0;
        if (strInput.length() == 2) {
            if (strInput.charAt(0) == strInput.charAt(1)) {
                return 0;
            } else
                return 1;
        }
        if (strInput.charAt(0) == strInput.charAt(strInput.length() - 1)) {
            return findMinNoOfInsertions(strInput.substring(1, strInput.length() - 1));
        } else {
            return Math.min(findMinNoOfInsertions(strInput.substring(0, strInput.length() - 1)),
                            findMinNoOfInsertions(strInput.substring(1, strInput.length()    ))
                            ) + 1;
        }

    }
}
