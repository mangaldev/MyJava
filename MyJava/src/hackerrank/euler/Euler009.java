package hackerrank.euler;


import java.util.Scanner;

public class Euler009 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        while (testcases-- != 0) {
            int N = sc.nextInt();
            int max = -1;
            for (int i = 1; i <= N/2; i++) {
                for (int j = (N-i)/2; j < N-i && j < i; j++) {
                    int k = N - i -j;
                    if(k > j)
                        continue;
                    if (i * i == j * j + k * k)
                        max = Integer.max(max, i * j * k);

                }
            }
            System.out.println(max);
        }
    }
}
