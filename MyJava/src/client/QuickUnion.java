package client;

public class QuickUnion {
    public QuickUnion() {
        super();
    }
    private static int MAX = 10;

    public static void main(String[] args) {

        int[] arr = new int[MAX];
        for (int i = 0; i < MAX; i++) {
            arr[i] = i;
        }
        union(arr, 4, 3); //Join 4 with 3 ....matlab arr[4] ko change karna hai
        union(arr, 3, 8); //Join 3 with 8 ..3 ka number change hoga..
        union(arr, 6, 5);
        union(arr, 9, 4);
        union(arr, 2, 1);
        union(arr, 8, 9);
        union(arr, 5, 0);
        union(arr, 7, 2);
        union(arr, 6, 1);
        System.out.println(isConnected(arr, 3, 7));
        for (int i = 0; i < MAX; i++) {
            System.out.printf(" %d ", arr[i]);
        }
    }

    private static int root(int[] arr, int p) {
        while (p != arr[p])
            p = arr[p];
        return p;
    }

    private static void union(int[] arr, int p, int q) {
        int firstRoot = root(arr, p);
        int secondRoot = root(arr, q);
        arr[firstRoot] = secondRoot;
    }

    private static boolean isConnected(int[] arr, int p, int q) {
        if (root(arr, p) == root(arr, q))
            return true;
        else
            return false;
    }
}
