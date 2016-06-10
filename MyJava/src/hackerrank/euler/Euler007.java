package hackerrank.euler;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.sun.tools.doclint.Entity.prime;

public class Euler007 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> prime = IntStream
                .range(2, 110001)
                .filter(Euler007::isPrime)
                .boxed()
                .collect(Collectors.toList());
        int testcases = scanner.nextInt();
        for (int i = 0; i < testcases; i++) {
            int num = scanner.nextInt();
            System.out.println(prime.get(num - 1));
        }

    }


    private static boolean isPrime(int num) {
        int index = 2;
        while (index < num) {
            if (num % index == 0)
                return false;
            index++;
        }
        return true;
    }


}
