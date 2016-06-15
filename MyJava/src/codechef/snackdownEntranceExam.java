package codechef;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class snackdownEntranceExam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        while (testcases-- != 0) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int E = sc.nextInt();
            long M = sc.nextLong();
            int lines = 0;
            List<Long> scores = new ArrayList<>();
            while (lines++ != N - 1) {
                long totalSum = 0;
                int exams = E;
                while (exams-- != 0) {
                    totalSum += sc.nextLong();
                }
                scores.add(totalSum);
            }
            Collections.sort(scores, Collections.reverseOrder());
            long curSum = 0;
            int exams = E - 1;
            while (exams-- != 0) {
                curSum += sc.nextLong();
            }
            long passingMarkTotal = scores.get(K - 1);
            if (curSum + M <= passingMarkTotal) {
                System.out.println("Impossible");
                continue;
            }
            long neededMarks = passingMarkTotal - curSum + 1;
            if (neededMarks > 0)
                System.out.println(neededMarks);
            else
                System.out.println(0);
        }
    }
}
