package arrayques;

/**
 * Created by mdev on 4/21/15.
 * Given an integer find the immediate larger integer that that which is a palindrome, example 1234212 -> 1234321, 345676 -> 346643.
 */
public class NextLargerPalindrome {
    public static void main(String[] args) {
//        String given = "1234212";
//        String given = "345676";
//        String given = "999";
//        String given = "1239531";
        String given = "99s";
        int len = given.length();
        String firstHalf = given.substring(0, len / 2);
        int first = Integer.parseInt(firstHalf);
        System.out.println("first = " + first);
        String lastHalf = given.substring((len + 1) / 2, len);
        int second = Integer.parseInt(lastHalf);
        System.out.println("second = " + second);
        int reverseFirstPart = Integer.parseInt(new StringBuilder(firstHalf).reverse().toString());
        System.out.println("reverseFirstPart = " + reverseFirstPart);
        if (len % 2 == 0) {
            if (second >= reverseFirstPart)
                first = first + 1;
            System.out.println(first + new StringBuilder(first + "").reverse().toString());
        } else {
            int mid = Integer.parseInt(given.charAt((len - 1) / 2) + "");
            if (second >= reverseFirstPart) {
                if (mid == 9) {
                    first = first + 1;
                    System.out.println(first + new StringBuilder(first + "").reverse().toString());
                }
                else
                    System.out.println(first + "" + (mid + 1) + "" + new StringBuilder(first + "").reverse().toString());
            } else
                System.out.println(first + "" + mid + "" + new StringBuilder(first + "").reverse().toString());
        }

    }


}
