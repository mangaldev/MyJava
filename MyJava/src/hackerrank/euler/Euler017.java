package hackerrank.euler;

import java.util.*;

/**
 * Created by mdev on 6/12/16.
 */
public class Euler017 {
    static List<String> words = Arrays.asList(" ", "Thousand", "Million", "Billion", "Trillion");
    static List<String> digits = Arrays.asList(" ", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"
    ,"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen");
    static List<String> hundreds = Arrays.asList(" ", " ", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        while (testcases-- != 0) {
            String num = sc.next();
            String result = "";
            int chunks = num.length() % 3==0 ? num.length() / 3:  num.length() / 3 + 1;
            for (int i = chunks; i >0; i--) {
                int upper = num.length() - ((chunks-i)*3);
                int lower = upper -3 > 0 ? upper -3 : 0;
                String word = num.substring(lower, upper);
                if(Integer.valueOf(word)>0){
                    result = (" "+translateThreeDigits(word).trim() +" " +words.get(chunks-i) +" "+ result).trim();
                }

            }
            System.out.println(result.trim());
        }
    }

    public static String translateThreeDigits(String word) {
        word = Integer.valueOf(word).toString();
        int iWord = Integer.valueOf(word);
        if(iWord<=19){
            return digits.get(iWord);
        }
        if(word.length() == 2){
            return hundreds.get(Character.getNumericValue(word.charAt(0))) +" "+ digits.get(Character.getNumericValue(word.charAt(1)));
        }

        if(word.length() == 3){
            return digits.get(Character.getNumericValue(word.charAt(0))) + " Hundred "+translateThreeDigits(word.substring(1));
        }
        return "";
    }
}
