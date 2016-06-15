package codechef;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mdev on 6/12/16.
 */
public class MaxProdSubSequence {
    public static void main(String[] args) {
        BigInteger mod = new BigInteger("1000000007");
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        while (tests-- != 0) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            List<Integer> posInput = new ArrayList<>();
            List<Integer> negInput = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if (sc.nextInt() >= 0)
                    posInput.add(sc.nextInt());
                else
                    negInput.add(sc.nextInt());
            }
            Collections.sort(posInput, Collections.reverseOrder());//bade se chota
            Collections.sort(negInput);//sabse chote se bada ....
            int resultIndex = 0;
            int posIndex = 0;
            int negIndex = 0;
            BigInteger result = new BigInteger("1");
            long multiply1 = getPostitiveNum(posInput, posIndex++) * getPostitiveNum(posInput, posIndex++);
            long multiply2 = getPostitiveNum(posInput, negIndex++) * getPostitiveNum(posInput, negIndex++);
            if(multiply1 > multiply2){

            }

        }


    }

    public static int getPostitiveNum(List<Integer> list, int index) {
        if (index < list.size())
            return list.get(index);
        else
            return 0;
    }

    public static int getNegativeNum(List<Integer> list, int index) {
        if (index < list.size())
            return list.get(index);
        else
            return 0;
    }

}



