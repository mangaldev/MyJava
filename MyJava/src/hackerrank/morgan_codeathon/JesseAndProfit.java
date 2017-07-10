package hackerrank.morgan_codeathon;

import java.util.*;

/**
 * Created by mdev on 8/7/16.
 */
public class JesseAndProfit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int D = sc.nextInt();
        int[] trades = new int[N];

        int count = 0;
        while (N-- > 0) {
            trades[count++] = sc.nextInt();
        }
        while (D-- > 0) {
            int profit = sc.nextInt();
            int min = Integer.MAX_VALUE;
            int minI = -1;
            int minJ = -1;

            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < trades.length; i++) {
                if (map.containsKey(trades[i])) {
                    map.get(trades[i]).add(i);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(trades[i], list);
                }
            }
            for (int i = 0; i < trades.length; i++) {
                int currentTrade = trades[i];
                int sellingTrade = profit + currentTrade;
                if (map.containsKey(sellingTrade)) {
                    List<Integer> sellingDays = map.get(sellingTrade);
                    for (int j = 0; j < sellingDays.size(); j++) {
                        if(sellingDays.get(j)>i){
                            int daysDiff = sellingDays.get(j) - i;
                            if (daysDiff < min) {
                                min = daysDiff;
                                minJ = sellingDays.get(j) + 1;
                                minI = i + 1;
                            }
                            break;
                        }
                    }
                }
            }
            if (minI != -1) {
                System.out.printf("%d %d\n", minI, minJ);
            } else
                System.out.println("-1");

        }
    }
}
