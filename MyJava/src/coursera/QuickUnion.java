package coursera;

public class QuickUnion {

	private static int MAX = 10;
	static int[] size  = new int[MAX];
    public static void main(String[] args) {

        int[] arr = new int[MAX];
        
        for (int i = 0; i < MAX; i++) {
            arr[i] = i;
            size[i] = 1;
        }
        String input ="9-8 0-5 8-6 8-3 2-7 9-1 7-4 0-4 1-7";
        String[] pairs = input.split(" ");
        for(String pair:pairs){
        	String[] nums = pair.split("-");
        	weightedUnion(arr,Integer.parseInt(nums[0]),Integer.parseInt(nums[1]));
        }
        System.out.println(isConnected(arr, 3, 7));
        for (int i = 0; i < MAX; i++) {
            System.out.printf(" %d", arr[i]);
        }
        int a1 = 8192   ;//131072 ;
        int a2 = 16384  ;//262144  ;
        
        double b1= 403.441;//634.892;
        double b2 = 3446.137;//3338.162;
        //b = z * a;
        double b = Math.log(b2) - Math.log(b1);
        double a = Math.log(a2) - Math.log(a1);
        System.out.println();
        System.out.println(b/a);//2.394470865582952
    }

    private static int root(int[] arr, int p) {
        while (arr[arr[p]] != p)
            p = arr[arr[p]];
        return p;
    }

    private static void union(int[] arr, int p, int q) {
        int firstRoot = root(arr, p);
        int secondRoot = root(arr, q);
        arr[firstRoot] = secondRoot;
    }
    
    private static void weightedUnion(int[] arr, int p, int q) {
        int firstRoot = root(arr, p);
        int secondRoot = root(arr, q);
        if(size[firstRoot] >= size[secondRoot]){
        	size[firstRoot] += size[secondRoot];
        	arr[secondRoot] = firstRoot;
        }
        else{
        	size[secondRoot] += size[firstRoot];
        	arr[firstRoot] = secondRoot;
        }
    }

    private static boolean isConnected(int[] arr, int p, int q) {
        if (root(arr, p) == root(arr, q))
            return true;
        else
            return false;
    }
}
