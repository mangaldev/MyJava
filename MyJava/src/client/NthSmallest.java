package client;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NthSmallest {
    public NthSmallest() {
        super();
    }

    public static void main(String[] args) {
        //        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = { 0, 5, 4, 6, 2, 3, 1, 7, 8, 9, 9 };
        int totalNums = 11;
        int indexToFind = 3;
        int ansIndex = findKthSmaillest(0, totalNums - 1, indexToFind, arr);
        System.out.println("answer is " + arr[ansIndex]);
    }

    static int findKthSmaillest(int first, int last, int kth, int[] arr) {
        int pivot = arr[first];
        System.out.println("Choosing  pivoit " + pivot);
        int pivotIndex = findPivotIndexInArr(first, last, pivot, arr);
        System.out.println("got the pivot Index of pivot " + pivot + " as " + pivotIndex);
        if (kth < pivotIndex) {
            return findKthSmaillest(first, pivotIndex - 1, kth, arr);
        } else if (kth > pivotIndex) {
            return findKthSmaillest(pivotIndex + 1, last, kth, arr);
        } else
            return pivotIndex;
    }

    static int findPivotIndexInArr(int low, int high, int pivot, int[] arr) {
        int first = low;
        int last = high;
        System.out.println("findPivotIndexInArr(" + first + "," + last + "," + pivot + ",)");
        while (first < last) {
            while (arr[first] < pivot) {
                System.out.println(arr[first] + " is smaller than " + pivot);
                first++;
            }
            while (arr[last] > pivot) {
                System.out.println(pivot + " is larger than " + arr[last]);
                last--;
            }
            if (first < last) {
                System.out.println("swapping " + arr[first] + " with " + arr[last]);
                int temp = arr[first];
                arr[first] = arr[last];
                arr[last] = temp;
            }
        }
        return last;
    }
}
