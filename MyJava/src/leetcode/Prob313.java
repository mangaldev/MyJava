package leetcode;

import java.util.PriorityQueue;

public class Prob313 {
    public static void main(String[] args) {
        final int i = new Prob313().nthSuperUglyNumber(2, new int[]{2, 3, 5});
        System.out.println("i = " + i);
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(1);
        int fetchCount = 0;
        int min = -1;
        while (fetchCount < n) {
            min = heap.poll();
            while (!heap.isEmpty() && heap.peek() == min) {
                heap.poll();
            }
            for (int prime : primes) {
                if (min < Integer.MAX_VALUE / prime) {
                    heap.add(prime * min);
                }
            }
            fetchCount++;
        }
        return min;
    }
}
