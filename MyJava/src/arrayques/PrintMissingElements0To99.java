package arrayques;

/**
 * Created by mdev on 4/16/15.
 */
public class PrintMissingElements0To99 {
    public static void main(String[] args) {
        int[] input = {88, 105, 3, 2, 200, 0, 10};
        boolean[] result = new boolean[100];

        for (int i = 0; i < input.length; i++) {
            if (input[i] < 100 && input[i] >= 0) {
                result[input[i]] = true;
            }
        }

        int ptr1 = 0;

        while (ptr1 < result.length) {
            if (!result[ptr1]) {
                int ptr2 = ptr1;
                while (ptr2 < result.length && !result[ptr2]) {
                    ptr2++;
                }
                ptr2--;
                System.out.println(ptr1 == ptr2 ? ptr1 : ptr1 + " - " + ptr2);
                ptr1 = ptr2 + 1;
            } else {
                ptr1++;
            }
        }
    }
}
