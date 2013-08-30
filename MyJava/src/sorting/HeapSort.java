package sorting;

import java.security.Key;

public class HeapSort {
    public HeapSort() {
        super();
    }

    public boolean less(int a, int b) {
        a = arr[a];
        b = arr[b];
        if (a < b)
            return true;
        else
            return false;
    }

    public void exch(int ia, int ib) {
        int a = arr[ia];
        int b = arr[ib];
        arr[ia] = b;
        arr[ib] = a;
    }

    public static int[] arr = new int[5];
    public static int N = 5;

    int index = 0;

    public static void main(String[] args) {
        HeapSort sort = new HeapSort();
        sort.insert(5);
        //        printArray();
        sort.insert(2);
        //        printArray();
        sort.insert(9);
        //        printArray();
        sort.insert(19);
        //        //        printArray();
        //        sort.insert(10);
        //        //        printArray();
        //        sort.insert(12);
        //        //        printArray();
        //        sort.insert(1);
        //        //        printArray();
        //        sort.insert(15);
        //        //        printArray();
        //        sort.insert(25);
        //        //        printArray();
        //        sort.insert(35);
        //        //        printArray();
        //        sort.insert(20);
        printArray();

        for (int i = 0; i < arr.length; i++) {
            System.out.println(sort.getMax());
        }

    }

    public void insert(int k) {
        arr[++index] = k;
        swim(index);
    }

    public int getMax() {
        int maxElem = arr[1];
        exch(1, N--);
        sink(1);
        return maxElem;
    }


    //    public void swim(int k) {
    //        if (k <= 1)
    //            return;
    //        if (less(k / 2, k)) {
    //            //            System.out.printf("k/2 : %d is smaller than k : %d  \n", arr[k / 2], arr[k]);
    //            exch(k / 2, k);
    //        }
    //        swim(k / 2);
    //    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    //
    //    public void sink(int k) {
    //        if (2 * k >= N)
    //            return;
    //        else if (2 * k + 1 > N && less(2 * k, k)) {
    //            return;
    //        } else if (2 * k + 1 < N && less(2 * k, k) && less(2 * k + 1, k))
    //            return;
    //        else if (2 * k + 1 < N && !less(2 * k, k) && !less(2 * k + 1, k)) {
    //            if (2 * k + 1 < N && less(2 * k, 2 * k + 1)) {
    //                exch(2 * k + 1, k);
    //                sink(2 * k + 1);
    //            } else {
    //                exch(2 * k, k);
    //                sink(2 * k);
    //            }
    //        } else if (less(k, 2 * k)) {
    //            this.exch(2 * k, k);
    //            sink(2 * k);
    //        } else if (2 * k + 1 < N && less(k, 2 * k + 1)) {
    //            this.exch(2 * k + 1, k);
    //            sink(2 * k + 1);
    //        }
    //    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1))
                j++;
            if (!less(k, j))
                break;
            exch(k, j);
            k = j;
        }
    }

    private static void printArray() {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(" %d ", arr[i]);
        }
        System.out.println();
    }

}

