package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Prob76 {
    public static void main(String[] args) {
//        final String s = new Prob76().minWindow("ADOBECODEBANC", "ABC");
        final String s = new Prob76().minWindow("aa", "aa");
        System.out.println("s = " + s);
    }
    public String minWindow(String sentence, String word) {
        int result = Integer.MAX_VALUE;
        int minIndex = -1, maxIndex = -1;
        Map<Character, PriorityQueue<Integer>> map = new HashMap<>();
        Map<Character, Integer> requiredCount = new HashMap<>();
        int wordCount = word.length();
        for (int i = 0; i < word.length(); i++) {
            map.put(word.charAt(i), new PriorityQueue<>());
            requiredCount.put(word.charAt(i), requiredCount.getOrDefault(word.charAt(i), 0) + 1);
        }
        int found = 0;
        for (int i = 0; i < sentence.length(); i++) {
            Character c = sentence.charAt(i);
            if (map.containsKey(c)) {
                found++;
                PriorityQueue<Integer> indexQueue = map.get(c);
                indexQueue.add(i);
                if (indexQueue.size() > requiredCount.get(c)) {
                    indexQueue.poll();
                    found--;
                }
            }
            if (found == wordCount) {
                int max = getMax(map);
                int min = getMin(map);
                int length = max - min;
                if (length < result) {
                    result = length;
                    maxIndex = max;
                    minIndex = min;
                }
            }
        }
        if(minIndex!=-1 && maxIndex!=-1)
        return sentence.substring(minIndex, maxIndex+1);
        return "";
    }

    private int getMin(Map<Character, PriorityQueue<Integer>> map) {
        int min = Integer.MAX_VALUE;
        for (Character character : map.keySet()) {
            if (map.get(character).peek() < min)
                min = map.get(character).peek();
        }
        return min;
    }

    private int getMax(Map<Character, PriorityQueue<Integer>> map) {
        int max = Integer.MIN_VALUE;
        for (Character character : map.keySet()) {
            final PriorityQueue<Integer> integers = map.get(character);
            for (Integer integer : integers) {
                if(integer > max)
                    max = integer;
            }
        }
        return max;
    }
}
