package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mdev on 3/18/16.
 */

public class ServiceLane {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numSegments = sc.nextInt();
        int testcases = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        while (numSegments-- != 0) {
            list.add(sc.nextInt());
        }
        while (testcases-- != 0) {
            Integer result = list.subList(sc.nextInt(),sc.nextInt()+1).stream().min(Integer::compare).get();
            System.out.println(result);
        }
    }
}
