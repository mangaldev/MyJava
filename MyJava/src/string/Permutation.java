package string;

import java.util.Arrays;

/**
 * Created by mdev on 4/26/15.
 */
public class Permutation {
    public static void main(String[] args) {
        String input = "aac";
        char[] charArr = input.toCharArray();
        Arrays.sort(charArr);
        printPermutation(new String(charArr),"",input.length());
    }

    public static void printPermutation(String  input, String result, int n){
        if(result.length() == n){
            System.out.println(result);
        }
        for (int i = 0; i < input.length(); i++) {
            if(i-1 >=0 && input.charAt(i)==input.charAt(i-1))
                continue;
            else{
                String input1 = new StringBuilder(input).deleteCharAt(i).toString();
                String result1 = new StringBuilder(result).append(input.charAt(i)).toString();
                printPermutation(input1,result1,n);
            }

        }
    }
}
