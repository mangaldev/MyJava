package hackerrank.euler;


import java.util.Scanner;

public class Euler004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while(cases-- !=0){
            int num = sc.nextInt();
            while(num>=100001){
                if(isPalindrome(num) && isProductOf3DigitsNum(num)) {
                    break;
                }
                else{
                    num--;
                }
            }
            System.out.println(num);
        }

    }

    private static boolean isProductOf3DigitsNum(int num) {
        for (int i = 100; i < 999; i++)
            if (num % i == 0) {
                int j = num / i;
                if (String.valueOf(j).length() == 3){
                    return true;
                }
            }
        return false;
    }

    private static boolean isPalindrome(int num){
        int first = num;
        int second = 0;
        while(num != 0){
            second = 10 * second + num%10;
            num/=10;
        }
        return first == second;
    }

}
