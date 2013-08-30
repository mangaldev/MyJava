package client;

public class QuickUnionWeighted {
    public QuickUnionWeighted() {
        super();
    }
    private static int MAX = 10;

    public static void main(String[] args) {

        int[] arr = new int[MAX];
        int[] sz = new int[MAX];
        for (int i = 0; i < MAX; i++) {
            arr[i] = i;
            sz[i] = 1;
        }
        union(arr, sz, 8, 6);
        union(arr, sz, 2, 0);
        union(arr, sz, 2, 4);
        union(arr, sz, 5, 7);
        union(arr, sz, 1, 9);
        union(arr, sz, 5, 8);
        union(arr, sz, 0, 3);
        union(arr, sz, 2, 6);
        union(arr, sz, 9, 5);

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

    private static void union(int[] arr, int[] sz, int p, int q) {
        int firstRoot = root(arr, p);
        int secondRoot = root(arr, q);
        if (sz[firstRoot] < sz[secondRoot]) {
            arr[firstRoot] = secondRoot;
            sz[secondRoot] += sz[firstRoot];
        } else {
            arr[secondRoot] = firstRoot;
            sz[firstRoot] += sz[secondRoot];
        }
    }

    private static boolean isConnected(int[] arr, int p, int q) {
        if (root(arr, p) == root(arr, q))
            return true;
        else
            return false;
    }
}
