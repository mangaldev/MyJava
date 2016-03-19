package hackerrank.codewhiz2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by mdev on 3/8/16.
 */
public class LambdaSolution {


    public static void main(String[] args) throws IOException {
        Math ob = new Math();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        performOperation op;
        int ret = 0;
        String ans = null;
        while (T-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.checkEvenOdd();
                ret = ob.checker(op, num);
                ans = (ret == 0) ? "EVEN" : "ODD";
            } else if (ch == 2) {
                op = ob.checkPrime();
                ret = ob.checker(op, num);
                ans = (ret == 0) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.checkPalindrome();
                ret = ob.checker(op, num);
                ans = (ret == 0) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }

}

interface performOperation {
    int check(int a);
}

class Math {
    public static int checker(performOperation p, int num) {
        return p.check(num);
    }

    public performOperation checkPrime() {
         class abc implements performOperation {
             @Override
             public int check(int a) {
                 if (a <= 1) return 0; // zero and one are not prime
                 for (int i=2; i*i<=a; i++) {
                     if (a % i == 0) return 1;
                 }
                 return 0;
             }

         }
        return new abc();
    }

    public performOperation checkEvenOdd() {
        class abc implements performOperation {

            @Override
            public int check(int a) {
                return a%2==0? 0 : 1;
            }
        }
        return new abc();
    }

    public performOperation checkPalindrome() {
        class abc implements performOperation {

            @Override
            public int check(int a) {
                int num = a;
                int rev = 0;
                while (num > 0)
                {
                    int dig = num % 10;
                    rev = rev * 10 + dig;
                    num = num / 10;
                }
                return num==rev? 0 : 1;
            }
        }
        return new abc();
    }
}
