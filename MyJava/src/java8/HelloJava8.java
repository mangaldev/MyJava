package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by mdev on 6/11/16.
 */
public class HelloJava8 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        Stream<Integer> integerStream = numbers.stream().filter(num -> num % 2 == 0);
        numbers.stream().map(num -> giveZero()).count();
        numbers.stream().map(HelloJava8::doubleMe).count();
    }

    private static int giveZero(){
        return 0;
    }

    public static int doubleMe(int a){
        return a*2;
    }
}
