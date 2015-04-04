package client;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by mdev on 4/3/15.
 */
public class HackerRank1 {




    public static String text = "nothing";
    public static String prefix = "bruno";
    public static String suffix = "ingenious";
//    public static String text = "ab";
//    public static String prefix = "b";
//    public static String suffix = "a";

    public static void main(String[] args) {
        String result = calculateScore(text, prefix, suffix);
        System.out.println(result);
    }

    static String calculateScore(String text, String prefix, String suffix) {
        int max = 0;
        int max_pre  = 0;
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            for (int j = i + 1; j <= text.length(); j++) {
                String subStr = text.substring(i, j);
                int pre = findPreLength(subStr, prefix);
//                System.out.println("pre = " + pre);
                int post = findPostLength(subStr, suffix);
//                System.out.println("post = " + post);

                if(max < (pre + post)) {
                    max = pre + post;
                    result = subStr;
                    max_pre = pre;
                }
                else if(max == pre + post){
                    if(pre > max_pre) {
                        max_pre = pre;
                        result = subStr;
                    }
                    else{
                        String[] arr = {result,subStr};
                        Arrays.sort(arr);
                        if(arr[0].equals(subStr)){
                            result = subStr;
                            max_pre = pre;
                        }
                    }
                }


            }
        }
        return result;
    }


    private static int findPostLength(String subStr, String suffix) {
        int max = 0;
        for (int i = 0; i < subStr.length(); i++) {
            int len = 0;
            String str = subStr.substring(i);
            int k =0;
            for (int j = 0; j <suffix.length() && k < str.length(); j++, k++) {
                if (str.charAt(k) == suffix.charAt(j))
                    len++;
                else
                    break;
            }
            if (len > max && k == str.length())
                max = len;
        }
        return max;
    }


    private static int findPreLength(String subStr, String prefix) {
        int max = 0;
        for (int i = 1; i < subStr.length() + 1; i++) {
            int len = 0;
            int j = prefix.length() - 1;
            String str = subStr.substring(0, i);
            int k =str.length() - 1;

            for (; j >= 0 && k >=0; j--, k--) {
                if (str.charAt(k) == prefix.charAt(j))
                    len++;
                else
                    break;
            }
            if (len > max && k == -1)
                max = len;
        }
        return max;
    }
}
