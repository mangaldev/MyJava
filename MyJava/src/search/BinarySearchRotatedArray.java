package search;

/**
 * Created by mdev on 3/17/15.
 */
public class BinarySearchRotatedArray {
    static int[] arr = {6, 6, 7, 7, 8, 9, 1, 1, 2, 2, 3, 4, 5, 6};

    public int getMedian(int first, int last) {
        return first + ((last - first) / 2);
    }

    public static void main(String... args) {
        BinarySearchRotatedArray prob = new BinarySearchRotatedArray();
        prob.binarySearch(arr, 0, arr.length - 1, 9);
    }

    private void binarySearch(int[] arr, int first, int last, int element) {
        if (last - first <= 1) {
            if (element == arr[first])
                System.out.println("Element Found : "+first);
            else if (element == arr[last])
                System.out.println("Element Found : "+last);
            else
                System.out.println("Element NOT Found");
            return;
        }

        int median = getMedian(first, last);

        if (arr[median] == element) {
            System.out.println("Element Found on index : " + median);
            return;
        }

        if (arr[last] <= arr[first]) {//Rotated Case
            if (arr[median] >= arr[first]) {//first half sorted
                if (element >= arr[first] && element <= arr[median])
                    binarySearch(arr, first, median, element);
                else
                    binarySearch(arr, median, last, element);
            } else {
                if (element <= arr[last] && element >= arr[median])
                    binarySearch(arr, median, last, element);
                else
                    binarySearch(arr, first, median, element);
            }
        } else {//Case 2 Normal Case
            if (arr[median] <= element)
                binarySearch(arr, median, last, element);
            else
                binarySearch(arr, first, median, element);
        }
    }

}
