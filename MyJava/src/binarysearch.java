/**
 * Created by mdev on 4/12/15.
 */
public class binarysearch {

    public static void main(String[] args) {
        int[] arr = {0,1,3,4,5};
        System.out.println(findUnMatchedIndex(arr,0,arr.length-1));
        StringBuilder sb = new StringBuilder();
    }

    public static int findUnMatchedIndex(int[] arr, int start, int end){
        int result;
        if(end - start == 1)
            return arr[end] == end?  (arr[start] == start ? -1:start) : end;
        int middle = (end-start)/2 + start;
        if(arr[middle] == middle)
            result = findUnMatchedIndex(arr,middle+1,end);
        else
            result = (arr[middle - 1] == middle -1) ? middle : findUnMatchedIndex(arr,start,middle-1);
        return result;
    }
}
