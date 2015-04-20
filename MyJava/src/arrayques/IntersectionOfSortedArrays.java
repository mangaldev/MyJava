package arrayques;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mdev on 4/19/15.
 */
public class IntersectionOfSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 7, 10, 13,15,18,19,101,150};
        int[] arr2 = {1, 3, 5, 7, 9,13,101,150};
        Integer[] result = findIntersection(arr1,arr2);
        Arrays.stream(result).forEach(e -> System.out.printf(" %d ", e));
    }

    public static Integer[] findIntersection(int[] arr1, int[] arr2){
        List<Integer> list = new ArrayList<>();
        int ptr1 = 0;
        int ptr2 = 0;
        while(ptr1<arr1.length && ptr2<arr2.length){
            if(arr1[ptr1] == arr2[ptr2]){
                list.add(arr1[ptr1]);
                ptr1++;
                ptr2++;
            }
            else {
                while (ptr1 < arr1.length && arr1[ptr1] < arr2[ptr2]) {
                    ptr1++;
                }
                while (ptr2 < arr2.length && arr1[ptr1] > arr2[ptr2]) {
                    ptr2++;
                }
            }

        }
        return list.toArray(new Integer[list.size()]);
    }


}
