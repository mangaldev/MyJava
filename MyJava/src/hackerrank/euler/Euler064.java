package hackerrank.euler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mdev on 7/21/16.
 */
public class Euler064 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N  = sc.nextInt();
        getRepeatSeq(N);
    }

    public static List<Integer> getRepeatSeq(int Num){
        List<Integer> result = new ArrayList<>();
        double N = Math.sqrt(Num);
        N = N - new Double(N).intValue();
        if(N==0.0)
            return result;
        int count = 100;
        while (count-- > 0){
            N = 1 / N;
            int num = new Double(N).intValue();
            result.add(num);
            N = N - num;
            if(N==0.0)
                return result;

        }
        System.out.println(result);
        return result;
    }

    public int countOfRepeatedIntegers(List<Integer> list){
        int maxRepeatCount = 3;
        return  0;

    }

}
