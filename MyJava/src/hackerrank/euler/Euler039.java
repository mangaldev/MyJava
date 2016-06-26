package hackerrank.euler;

import java.util.*;

/**
 * Created by mdev on 6/25/16.
 */
public class Euler039 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long cases = sc.nextInt();
        int[] perimeter = new int[5000007];
        Arrays.fill(perimeter, 0);
        Deque<int[]> queue = new LinkedList<>();
        queue.push(new int[]{3, 4, 5});
        while (!queue.isEmpty()) {
            int[] pop = queue.poll();
            int p = pop[0] + pop[1] + pop[2];
//                System.out.printf("%d %d %d",pop[0],pop[1],pop[2]);
//                System.out.println();
            if (p > 5000000) {
                continue;
            }
            for (int i = p; i < 5000007; i = i + p) {
                perimeter[i] += 1;
            }

            queue.add(getPrimitiveTripletsFromTriplets1(pop));
            queue.add(getPrimitiveTripletsFromTriplets2(pop));
            queue.add(getPrimitiveTripletsFromTriplets3(pop));
        }

        int maxP = 0;
        int maxI = 0;
        for (int i = 0; i < 5000004; i++) {
            if(perimeter[i]>maxP){
                maxP = perimeter[i];
                maxI = i;
            }
            perimeter[i] = maxI;
        }
        while (cases-- > 0) {
//            for (int i = 0; i < 100; i++) {
//                if(perimeter[i]>0)
//                System.out.printf("%d -> %d\n",i,perimeter[i]);
//            }
            int N = sc.nextInt();
            System.out.println(perimeter[N]);
        }
    }

    public static int[] getPrimitiveTripletsFromTriplets1(int[] given) {
        int[] result = new int[3];
        result[0] = given[0] + (given[1] * -2) + (given[2] * 2);
        result[1] = given[0] * 2 + given[1] * -1 + given[2] * 2;
        result[2] = given[0] * 2 + given[1] * -2 + given[2] * 3;

        return result;
    }

    public static int[] getPrimitiveTripletsFromTriplets2(int[] given) {
        int[] result = new int[3];

        result[0] = given[0] + given[1] * 2 + given[2] * 2;
        result[1] = given[0] * 2 + given[1] + given[2] * 2;
        result[2] = given[0] * 2 + given[1] * 2 + given[2] * 3;

        return result;
    }

    public static int[] getPrimitiveTripletsFromTriplets3(int[] given) {
        int[] result = new int[3];

        result[0] = given[0] * -1 + given[1] * 2 + given[2] * 2;
        result[1] = given[0] * -2 + given[1] + given[2] * 2;
        result[2] = given[0] * -2 + given[1] * 2 + given[2] * 3;
        return result;
    }

    public void isSlow(int N) {
        long maxP = 0;
        long maxCount = 0;
        for (long p = 12; p <= N; p++) {
            int count = 0;
            for (long i = 1; i < p / 2; i++) {
                for (long j = 1; j < i; j++) {
                    if (i + j >= p)
                        break;
                    long k = p - i - j;
                    if (i > j && i > k && i * i == j * j + k * k) {
                        count++;
                    }
                    if (k > j && k > i && k * k == j * j + i * i) {
                        count++;
                    }
                }
            }
            if (count > maxCount) {
                maxCount = count;
                maxP = p;
            }
        }
        System.out.println(maxP);
    }

}
