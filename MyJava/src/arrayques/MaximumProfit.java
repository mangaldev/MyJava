package arrayques;

/**
 * Created by mdev on 4/18/15.
 */
public class MaximumProfit {
    public static void main(String[] args) {
//        int[] input = new int[]{2, 30, 15, 10, 8, 25, 80};
        int[] input = new int[]{2, 30, 15, 100, 8, 25, 80};
        int result = getProfit(input);
    }

    private static int getProfit(int[] input) {
        int result = Integer.MIN_VALUE;
        int[] temp = new int[input.length];
        temp[input.length-1] = input[input.length - 1];
        for (int i = input.length - 2; i >=0 ; i--) {
            if(input[i]> temp[i+1] ){
                temp[i] = input[i];
            }
            else{
                temp[i] = temp[i+1];
            }
            if(result > (temp[i]-input[i])){
                result = temp[i]-input[i];
            }
        }

        print(temp);
        return 0;
    }

    public static void print(int[] input) {
        System.out.println("-----------------");
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i]+" ");
        }
    }


}
