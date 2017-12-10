package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob638 {

    Map<List<Integer>, Integer> needsCache = new HashMap<>();

    public static void main(String[] args) {

    }

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (needsCache.containsKey(needs))
            return needsCache.get(needs);
        int finaPrize = 0;
        for (int i = 0; i < needs.size(); i++) {
            if (needs.get(i) > 0) {
                List<Integer> tempNeeds = new ArrayList<>(needs);
                tempNeeds.set(i, tempNeeds.get(i) - 1);
                finaPrize = price.get(i) + shoppingOffers(price, special, tempNeeds);
            }
        }
        return finaPrize;
    }

    public void recursive() {

    }


}
