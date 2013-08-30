package client;

public class QuickFind {
    public QuickFind() {
        super();
    }
    private static int MAX = 10;

    public static void main(String[] args) {

        int[] arr = new int[MAX];
        for (int i = 0; i < MAX; i++) {
            arr[i] = i;
        }
        //        union(arr, 3, 8); //Join 3 with 8 ..3 ka number change hoga..
        union(arr, 5, 9);
        union(arr, 0, 3);
        union(arr, 4, 0);
        union(arr, 1, 9);
        union(arr, 4, 9);
        union(arr, 8, 3);
        System.out.println(isConnected(arr, 3, 7));
        for (int i = 0; i < MAX; i++) {
            System.out.printf(" %d ", arr[i]);
        }
    }

    private static void union(int[] arr, int p, int q) {
        int firstRoot = arr[p];
        int secondRoot = arr[q];
        //        while (p != arr[p])
        //            p = arr[p];
        //        arr[q] = p;
        for (int i = 0; i < MAX; i++) {
            if (arr[i] == firstRoot)
                arr[i] = secondRoot;
        }
    }

    private static boolean isConnected(int[] arr, int i, int i1) {
        if (arr[i] == arr[i1])
            return true;
        else
            return false;
    }
}
