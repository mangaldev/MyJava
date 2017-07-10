package hackerrank.euler;

import java.util.Scanner;

/**
 * Created by mdev on 7/20/16.
 */
public class Euler059 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        for (int i = 32; i < 124; i++) {
//            System.out.printf("%d %c\n", i, i);
//        }
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int a = 97;
        int b = 97;
        int c = 97;//till 122
        for (int i = 0; i < N && a < 123; i = i + 3) {
            int xor = arr[i] ^ a;
//            System.out.printf(" %c ", xor);
            if (unApprovedCharacter(xor)) {
                a++;
                i = -3;
            }
        }
//        System.out.println("\nProcessing B");

        for (int i = 1; i < N && b < 123; i = i + 3) {
            int xor = arr[i] ^ b;
//            System.out.printf(" %c,%c ", xor, arr[i]^98);
            if (unApprovedCharacter(xor)) {
//                System.out.println();
//                System.out.println("Didnt work with "+b);
                b++;
                i = -2;
            }
        }
//        System.out.println("Processing C");
        for (int i = 2; i < N && c < 123; i = i + 3) {
            int xor = arr[i] ^ c;
//            System.out.printf(" %c ", xor);
            if (unApprovedCharacter(xor)) {
                c++;
                i = -1;
            }
        }

        System.out.printf("%c%c%c", a, b, c);
    }

    public static boolean unApprovedCharacter(int xor) {
        if (xor >= 97 && xor <= 122)
            return false;
        if (xor >= 65 && xor <= 90)
            return false;
        if (xor >= 48 && xor <= 57)
            return false;
        if (xor == ')' || xor == '(' || xor == ' ' || xor == ';' || xor == '-' || xor == '!' ||
                xor == ':' || xor == ',' || xor == '.' ||  xor == '\'' || xor == '?')
            return false;
        return true;
    }
}
