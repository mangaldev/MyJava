package hackerrank;

import java.util.Scanner;

public class LeanardoAndString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        while (tests-- != 0) {
            String input = sc.next();
            long totalSittingArrangements = findTotalSittingArrangements(input);
            System.out.println(totalSittingArrangements);
        }
    }

    private static long findTotalSittingArrangements(String input) {
        long result = 0;
        long count = 1;
        for (int i = 0; i < input.length(); i++) {
            if (isNextCharacterIsSameAsCurrentCharacter(input, i))
                count++;
            else {
                result += (count * (count + 1)) / 2;
                count = 1;
            }
        }


        return result;
    }

    private static boolean isNextCharacterIsSameAsCurrentCharacter(String input, int i) {
        return isNextCharacterInBoundary(input, i) && input.charAt(i + 1) != input.charAt(i);
    }

    private static boolean isNextCharacterInBoundary(String input, int i) {
        return i + 1 < input.length();
    }
}
/*
Leonardo loves puzzles involving strings, but he's just found a problem that has him stumped! Help him solve the following challenge:

Given a binary string, SS, composed of only 00's and 11's, find and print the total number of substrings of SS which do not contain a 0000 or 1111.

Input Format

The first line contains an integer, TT (the number of test cases).
The TT subsequent lines of test cases each contain a string, SS, composed only of 00's and 11's.

Constraints

1≤T≤1001≤T≤100
1≤|S|≤1051≤|S|≤105
Output Format

For each test case, print the total number of substrings of SS having no consecutive zeroes or ones (i.e.: not containing 0000 or 1111).

Sample Input

4
1010
100
0000
11111
Sample Output

10
4
4
5
Explanation

Test Case 0: S0=1010S0=1010
Our set of substrings ={{1},{0},{1},{0},{10},{01},{10},{101},{010},{1010}}={{1},{0},{1},{0},{10},{01},{10},{101},{010},{1010}}
There are 1010 possible substrings, none of which have consecutive 00's or 11's. Thus, we print 1010 on a new line.

Test Case 1: S1=100S1=100
Our set of substrings ={{1},{0},{0},{10},{00},{100}}={{1},{0},{0},{10},{00},{100}}
There are 66 possible substrings, but 22 of them ({00}{00} and {100}{100}) have consecutive zeroes. Thus, we print the result of 6−26−2, which is 44, on a new line.

Submissions: 600
Max Score: 20
Difficulty: Easy
More
Current Buffer (saved locally, editable)

Java 8

 */
