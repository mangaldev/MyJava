package codechef;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MaximumProduct {
    public static void main(String[] args) {
        BigInteger mod = new BigInteger("1000000007");
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        while (tests-- != 0){
            int N = sc.nextInt();
            int K = sc.nextInt();
            List<Integer> input = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                input.add(sc.nextInt());
            }
            for (int i = 0; i < K - 1; i++) {
                input.add(input.get(i));
            }
            BigInteger init = new BigInteger("1");
            for (int i = 0; i < K; i++) {
                init = init.multiply(new BigInteger(input.get(i).toString()));
            }
            BigInteger maxProd = new BigInteger(init.toString());
            BigInteger currentProd = new BigInteger(init.toString());
            for (int i = K; i < input.size(); i++) {
                if(input.get(i)==0){
                    currentProd = new BigInteger("0");
                    int last = i + K - 1;
                    for (int j = i+1; j <= last && last< input.size(); j++) {
                        if(input.get(j) == 0){
                            last = j + K - 1;
                        }
                    }
                    i = last;
                }
                else if(input.get(i-K)==0){
                    int start = i-K+1;
                    currentProd  = new BigInteger("1");
                    for (int j = 0; j < K; j++) {
                        currentProd = currentProd.multiply(new BigInteger(input.get(start+j).toString()));
                    }
                }
                else
                    currentProd = currentProd.multiply(new BigInteger(input.get(i).toString())).divide(new BigInteger(input.get(i-K).toString()));
                maxProd = maxProd.max(currentProd);
            }
            System.out.println(maxProd.mod(mod));
        }
    }
}
