package hackerrank.euler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mdev on 4/20/16.
 */
public class Euler003 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- != 0) {
            long number = sc.nextLong();
            long currentPrime = 1,counter;
            for ( counter = 2; counter * counter <= number; counter++) {
                while (number % counter == 0) {
                    currentPrime = counter;
                    number = number / counter;
                }
            }
            if(number > 1){
                currentPrime = number;
            }
            System.out.println(currentPrime);
        }
    }
}
