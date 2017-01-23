/**
 * Created by mdev on 4/26/16.
 */

import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Euler007 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> prime = IntStream.range(2, 110001)
                .filter(Euler007::isPrimeNew)
                .boxed()
                .collect(Collectors.toList());

        int testcases = scanner.nextInt();
        for (int i = 0; i < testcases; i++) {
            int num = scanner.nextInt();
            System.out.println(prime.get(num-1));
        }
    }

    private static boolean isPrimeNew(int i) {
        return IntStream.range(0, i).boxed().map(isPrime).reduce((a, b) -> a && b).isPresent();
    }


    private static Function<Integer, Boolean> isPrime = num -> {
        int index = 2;
        while(index < num){
            if(num % index == 0)
                return false;
            index++;
        }
        return true;
    };


}