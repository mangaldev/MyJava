package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class Prob312 {

    private static Map<List<Integer>, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        final int recursive = recursive(asList(1, 1, 3, 5, 8, 1));
//        final int recursive = recursive(asList(1, 3, 5, 8, 1));
        System.out.println("recursive = " + recursive);
    }

    public static int recursive(List<Integer> list) {
        if (list.size() == 4) {
            return list.get(1) * list.get(2) + Math.max(list.get(1), list.get(2));
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < list.size() - 1; i++) {
            int result;
            List<Integer> listWithRemovedI = new ArrayList<>(list);
            listWithRemovedI.remove(i);
            if (cache.containsKey(listWithRemovedI)) {
                result = cache.get(listWithRemovedI);
            } else {
                result = recursive(listWithRemovedI) + list.get(i) * list.get(i - 1) * list.get(i + 1);
            }
            max = Math.max(max, result);
        }
        cache.put(list, max);
        return max;
    }
}
