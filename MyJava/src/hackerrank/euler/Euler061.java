package hackerrank.euler;

import java.util.*;

/**
 * Created by mdev on 7/24/16.
 */
public class Euler061 {
    private static final int MAX_POSSIBLE = 200;
    public static Integer[][] shapesCache = new Integer[9][MAX_POSSIBLE];
    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> result1 = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(cyclicNumbers(new ArrayList<>(Arrays.asList(8128, 8281, 2882))));
        cacheIt();
//        for (int i = 0; i < 9; i++) {
//            System.out.println();
//            for (int j = 0; j < MAX_POSSIBLE; j++) {
//                System.out.printf(" %d ",shapesCache[i][j]);
//            }
//        }
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] shapes = new int[N];
        int count = 0;
        while (count < N) {
            shapes[count] = sc.nextInt();
            count++;
        }
        int[] visitedShapes = new int[9];
        Arrays.fill(visitedShapes, 0);
        for (int i = 0; i < shapes.length; i++) {
            visitedShapes[shapes[i]] = -1;
        }
//        countIt(0, shapes, new ArrayList<>());
        getList(visitedShapes, new ArrayList<>(), -1);
        for (int i = 0; i < result1.size(); i++) {
            System.out.println(result1.get(i));
        }
    }


    public static void getList(int[] visitedShapes, ArrayList<Integer> list, int back) {
        if (allComplete(visitedShapes) && list.get(0) / 100 == back) {
            result.add(list);
            return;
        }
        int currentShape = getNextVisitedShape(visitedShapes);
        visitedShapes[currentShape] = 0;
        for (int i = 0; i < shapesCache[currentShape].length; i++) {
            Integer num = shapesCache[currentShape][i];
            if (num == null)
                break;
            if (back == -1 || num / 100 == back) {
                list.add(num);
                getList(visitedShapes, list, num % 100);
            }
        }
        visitedShapes[currentShape] = -1;
    }

    private static int getNextVisitedShape(int[] inputShapes) {
        for (int i = 0; i < inputShapes.length; i++) {
            if (inputShapes[i] == -1)
                return i;
        }
        return -1;
    }

    private static boolean allComplete(int[] visitedShapes) {
        for (int i = 0; i < visitedShapes.length; i++) {
            if (visitedShapes[i] == -1)
                return false;
        }
        return true;
    }

    public static void countIt(int N, int[] inputShapes, ArrayList<Integer> list) {
//        System.out.println("N = [" + N + "], shapes = [" + shapes + "], list = [" + list + "]");
        if (N >= inputShapes.length) {
            if (N == inputShapes.length && cyclicNumbers(new ArrayList<>(list))) {
//                System.out.println(list);
                Collections.sort(list);
                result.add(list);
                Integer integer = list.stream().reduce((a, b) -> a + b).get();
                result1.add(integer);
            }
            return;
        }

        int currentShape = inputShapes[N];
        N = N + 1;
        for (int i = 0; i < MAX_POSSIBLE && shapesCache[currentShape][i] != null; i++) {
            list.add(shapesCache[currentShape][i]);
            countIt(N, inputShapes, list);
            list.remove(shapesCache[currentShape][i]);
        }

    }

    static int i3 = 0, i4 = 0, i5 = 0, i6 = 0, i7 = 0, i8 = 0;

    public static void cacheIt() {
        for (int i = 1; i < 1000; i++) {
            int n = i * (i + 1) / 2;
            if (n >= 1000 && n < 10000)
                shapesCache[3][i3++] = n;

            n = i * i;
            if (n >= 1000 && n < 10000)
                shapesCache[4][i4++] = n;

            n = i * (3 * i - 1) / 2;
            if (n >= 1000 && n < 10000)
                shapesCache[5][i5++] = n;

            n = i * (2 * i - 1);
            if (n >= 1000 && n < 10000)
                shapesCache[6][i6++] = n;

            n = i * (5 * i - 3) / 2;
            if (n >= 1000 && n < 10000)
                shapesCache[7][i7++] = n;

            n = i * (3 * i - 2);
            if (n >= 1000 && n < 10000)
                shapesCache[8][i8++] = n;
        }
    }

    public static boolean cyclicNumbers(ArrayList<Integer> nums) {
        int front = nums.get(0) / 100;
        int back = nums.get(0) % 100;
        nums.remove(nums.get(0));
        while (true) {
            if (nums.size() == 0)
                break;
            Integer num = findNumberWithThisFront(nums, back);
            if (num == null)
                return false;
            back = num % 100;
            nums.remove(num);
        }
        if (front == back)
            return true;
        return false;
    }

    private static Integer findNumberWithThisFront(ArrayList<Integer> nums, int back) {
        for (int i = 0; i < nums.size(); i++) {
            int front = nums.get(i) / 100;
            if (back == front)
                return nums.get(i);
        }
        return null;
    }


}
