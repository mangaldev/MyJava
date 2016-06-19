package hackerrank.euler;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by mdev on 6/17/16.
 */
public class Euler025 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        List<Integer> a = Collections.singletonList(1);
        List<Integer> b = Collections.singletonList(1);
        Map<Integer,Integer> cache = new HashMap<>();
        cache.put(1,1);
        int len = 2;
        int count = 2;
        while(len <= 5000){
            count++;
            List<Integer> c = add(a,b);
            a = b;
            b = c;
            if(b.size() == len) {
                cache.put(len++, count);
            }
        }

        while(cases-- != 0){
            int input = sc.nextInt();
            System.out.println(cache.get(input));
        }
    }

    public static List<Integer> add(List<Integer> a, List<Integer> b){
        Collections.reverse(a);
        Collections.reverse(b);
        List<Integer> result = new ArrayList<>();
        int carry = 0;
        int indexa =0,indexb = 0;
        while (indexa< a.size() && indexb<b.size()){
            Integer num = a.get(indexa++) + b.get(indexb++) + carry;
            result.add(num%10);
            carry = num/10;
        }
        if(a.size() == indexa){
            while (indexb<b.size()) {
                Integer num = b.get(indexb++) + carry;
                result.add(num % 10);
                carry = num / 10;
            }
        }
        if(b.size() == indexb){
            while (indexa<a.size()) {
                Integer num = a.get(indexa++) + carry;
                result.add(num % 10);
                carry = num / 10;
            }
        }
        while(carry>0){
            result.add(carry%10);
            carry = carry/10;
        }
        Collections.reverse(result);
        Collections.reverse(a);
        Collections.reverse(b);
        return result;

    }


}
