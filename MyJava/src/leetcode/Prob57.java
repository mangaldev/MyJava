package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob57 {
    public static void main(String[] args) {
        insert(Arrays.asList(new Interval(1, 5)), new Interval(6, 8));
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        List<Interval> result = new ArrayList<>();
        if(intervals.size() == 0){
            result.add(newInterval);
            return result;
        }
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end <= newInterval.start) {
            result.add(intervals.get(i));
            i++;
        }
        result.add(newInterval);
        if (i< intervals.size() && intervals.get(i).start <= newInterval.start) {
            newInterval.start = intervals.get(i).start;
        }
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            i++;
        }
        if (i - 1 >= 0) {
            if (intervals.get(i - 1).end >= newInterval.end) {
                newInterval.end = intervals.get(i - 1).end;
            }
        }
        while (i < intervals.size()) {
            result.add(intervals.get(i));
            i++;
        }
        return result;
    }

//    public Interval[] findInterval(List<Interval> intervals, Interval root) {
//        Interval[] result = new Interval[2];
//        for (Interval interval : intervals) {
//            if (interval.start <= root.start && interval.end >= root.start) {
//                result[0] = interval;
//            }
//            if (interval.start <= root.end && interval.end >= root.end) {
//                result[1] = interval;
//            }
//        }
//    }

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
