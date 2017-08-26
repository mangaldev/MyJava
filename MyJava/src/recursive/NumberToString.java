package recursive;

public class NumberToString {

    public static void main(String... args){
        translateIntegerToString(11,"");
    }

    private static void translateIntegerToString(Integer input, String soFar){
        if(input == 0)
            System.out.println(new StringBuilder(soFar).reverse());
        if(input%10 > 0)
            translateIntegerToString(input/10,soFar+intToChar(input%10));
        if(input%100 > 9 && input%100 <=26)
            translateIntegerToString(input/100,soFar+intToChar(input%100));
    }

    private static  char intToChar(int n){
        return (char) (n+64);
    }

}