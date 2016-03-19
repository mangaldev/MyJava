package hackerrank;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by mdev on 5/10/15.
 */
public class ZeroOneMultiple {

    public static void main(String[] args) {
        for(int i = 1; i <= 100000; i++) System.out.println(i + " = " + fun(i));
    }

    public static String fun(int N) {
        int i = 1;
        int count = 0;
        Map<Integer, BigInteger> map = new HashMap<>();
        while(true) {
            int remainder = i % N;
            BigInteger currentNumber = new BigInteger("10").pow(count);

            if(remainder == 0) return currentNumber.toString();

            if(map.containsKey(N - remainder))
                return currentNumber.add(map.get(N - remainder)).toString();

            if(!map.containsKey(remainder)) map.put(remainder, currentNumber);
            Map<Integer, BigInteger> temp = new HashMap<>();
            for(int key: map.keySet()) {
                if(!map.get(key).equals(currentNumber)) {
                    int remainder1 = (key + remainder) % N;
                    if (!map.containsKey(remainder1) && !temp.containsKey(remainder1))
                        temp.put(remainder1, new BigInteger("10").pow(count).add(map.get(key)));
                }
            }
            map.putAll(temp);
            i = remainder * 10;
            count++;
        }
    }
}
