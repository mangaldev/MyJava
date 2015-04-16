package hackerrank;

import java.util.Scanner;

/**
 * Created by mdev on 4/13/15.
 */
public class BiggerIsGreater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        while (testcases-- != 0) {
            String ans = lexico(sc.next());
            System.out.println(ans);
        }

    }

    public static String lexico(String str) {
        char[] input = str.toCharArray();
        char lastChar = '0';
        int i = input.length - 1;
        for (; i >= 0; i--) {
            if (lastChar == '0') {
                lastChar = input[i];
            } else {
                if (input[i] < lastChar) {
                    break;
                }
                lastChar = input[i];
            }
        }
        if (i == -1) {
            return "no answer";
        }
        for (int j = input.length - 1; j > i; j--) {
            if (input[j] > input[i]) {
                char temp = input[j];
                input[j] = input[i];
                input[i] = temp;
                break;
            }
        }
        int mid = (i + 1 +  input.length - 1) / 2;
        for (int j = i + 1; j <= mid; j++) {
            char temp = input[j];
            int k = input.length - 1 - (j -i - 1);
            input[j] = input[k];
            input[k] = temp;
        }
        return new String(input);
    }


}
