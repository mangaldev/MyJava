package interviewbit;

import java.util.ArrayList;

/**
 * Created by mdev on 8/8/16.
 */
public class PrettyPrint {
    public static void main(String[] args) {
        PrettyPrint print = new PrettyPrint();
        print(print.prettyPrint(10));
    }

    public static void print(ArrayList<ArrayList<Integer>> lists) {
        for (ArrayList<Integer> list : lists) {
            System.out.println();
            for (Integer integer : list) {
                System.out.printf(" %d ", integer);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int count = 0; count < a; count++) {
            ArrayList<Integer> list = new ArrayList<>();
            int temp = count;
            for (int i = a, j = 0; j < a; j++) {
                list.add(i);
                if (temp > 0) {
                    temp--;
                    i = i - 1;
                }
            }
            for (int i = list.size() - 2; i >= 0; i--) {
                list.add(list.get(i));
            }
            result.add(list);
        }
        for (int i = result.size() - 2; i >= 0; i--) {
            result.add(result.get(i));
        }
        return result;
    }
}
