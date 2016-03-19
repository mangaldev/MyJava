package recursive;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by mdev on 5/9/15.
 */
public class BSBPortal {
    public static void main(String[] args) {
        System.out.println(Math.pow(2, 32));
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int cases = sc.nextInt();
        while(cases-- != 0){
            map.clear();
            long result = getMaxSum(sc.next(), 4);
            out.println(result == -1 ? "unlucky": result);
            //System.out.println("map = " + map);

        }
        out.close();
    }

    static HashMap<String, Long> map = new HashMap<>();
    public static long maxLimit = 1000000000000L;

    public static long getMaxSum(String str, int num) {

        if(str.length() == 0) return -1;
        if(str.equals("0") && num == 1) return 0;
        if(str.charAt(0) == '0' )
            return  getMaxSum(str.substring(1), num - 1);
        if (num == 1) {
            if(str.length()> 13) return -1;
            long x = Long.parseLong(str);
            if(x > maxLimit) return -1;
            else return x;
        }
        long sum = -1;
        for(int i= 0; i < str.length() - 1; i++) {
            if(i > 13) continue;
            long firstPart = Long.parseLong(str.substring(0, i+1));
            if(firstPart <= maxLimit) {
                String key = str.substring(i+1) + ":" + (num - 1);
                if(!map.containsKey(key)) {
                    long afterPart = getMaxSum(str.substring(i + 1), num - 1);
                    if(afterPart != -1) map.put(key, afterPart);
                }
                if(map.containsKey(key))
                    sum = Long.max(sum, firstPart + map.get(key));
            }
        }
        return sum;
    }
}
