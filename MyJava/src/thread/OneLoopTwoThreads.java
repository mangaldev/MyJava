package thread;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by mdev on 3/12/15.
 */
public class OneLoopTwoThreads {


    public static void main(String... args){
        ExecutorService service = Executors.newFixedThreadPool(2);
        int[] input = new int[200];
        input = Arrays.stream(input).map(num -> new Random().nextInt(1000)).toArray();
        OptionalInt max = Arrays.stream(input).max();
        System.out.println("max = " + max);
        OptionalInt min = Arrays.stream(input).min();
        System.out.println("min = " + min);
        Arrays.stream(input).forEach(num -> System.out.printf(" %d ", num));
//        service.submit(new Worker());
    }



    static class Worker extends Thread{

        public void run(){
            System.out.println();
        }
    }


}
