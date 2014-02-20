package coursera;

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
        String input ="3-5 0-4 6-9 8-2 8-6 3-6";
        String[] pairs = input.split(" ");
        for(String pair:pairs){
        	String[] nums = pair.split("-");
        	union(arr,Integer.parseInt(nums[0]),Integer.parseInt(nums[1]));
        }
        System.out.println(isConnected(arr, 3, 7));
        for (int i = 0; i < MAX; i++) {
            System.out.printf(" %d ", arr[i]);
        }
    }

    private static void union(int[] arr, int p, int q) {
        int firstRoot = arr[p];
        int secondRoot = arr[q];
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
