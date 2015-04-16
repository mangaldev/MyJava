package arrayques;

/**
 * Created by mdev on 4/16/15.
 */
public class FindMinDistanceXAndY {
    public static void main(String[] args) {
        int[] arr = {2,1,9,8,5,7,7,1,1,1,0,5,3,1,7,5,5,6,6,8,9,1,1};
        int N = arr.length;
        int X  = 1;
        int Y = 5;
        int min = Integer.MAX_VALUE;
        int ptr1 = 0;
        int ptr2 = 0;
        while(ptr1<N && ptr2 < N){
            while (ptr1<N && arr[ptr1] != X )
                ptr1++;
            while (ptr2<N && arr[ptr2] != Y )
                ptr2++;
            if(ptr1!= N && ptr2!=N)
                if(Math.abs(ptr1 - ptr2) < min)
                    min = Math.abs(ptr1 - ptr2);

            if(ptr1 < ptr2)
                ptr1++;
            else
                ptr2++;
        }
        System.out.println(min);
    }
}
