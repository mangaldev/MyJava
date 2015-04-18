package arrayques;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mdev on 4/17/15.
 */
public class GetMaximalSubArrayWithZeroSum {

    public static void main(String[] args) {
//        System.out.println(getMaximaDiff(new int[]{4,  6,  3, -9, -5, 1, 3, 0, 2}));
        int[] given = {1,-2,300,4,5};
//        Arrays.sort(given,Collections.reverseOrder());
        Arrays.stream(given).forEach(e -> System.out.println( e));
    }

    public static int getMaximaDiff(int[] arr) {

        int temp[] = new int[arr.length];
        temp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {

            temp[i] = temp[i - 1] + arr[i];
        }

        int diff = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int d = -1;
            if (temp[i] == 0) {
                d = i + 1;
            } else {
                if (map.containsKey(temp[i])) {
                    int lastIndex = map.get(temp[i]);
                    d = i - lastIndex;
                } else
                    map.put(temp[i], i);
            }
            if (d > diff) {
                diff = d;
            }
        }

        return diff;
    }

}
