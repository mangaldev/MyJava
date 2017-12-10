package leetcode;

public class Prog670 {
    public static void main(String[] args) {
        final int i = maximum(2736);
        System.out.println("i = " + i);
    }

    public static int maximum(int num){
        String sNum = num + "";
        char[] charNum = sNum.toCharArray();
        int[] cache  = new int[10];
//        Arrays.fill(cache, );
        for (int i = 0; i < sNum.length(); i++) {
            int digit = sNum.charAt(i) - '0';
            cache[digit] = i;
        }
        int indexToBeSwapped=-1,withIndex=-1;
        for (int i = 0; i < sNum.length() && indexToBeSwapped==-1; i++) {
            int digit = sNum.charAt(i) - '0';
            for (int j = 9; j > 0 ; j--) {
                if(j>digit && cache[j] > i  ){
                    indexToBeSwapped = cache[j];
                    withIndex = i;
                    break;
                }
            }
        }
        if(withIndex != -1) {
            char temp = charNum[indexToBeSwapped];
            charNum[indexToBeSwapped] = charNum[withIndex];
            charNum[withIndex] = temp;
            String result = "";
            for (int i = 0; i < charNum.length; i++) {
                result = result + charNum[i];
            }
            return Integer.parseInt(result);
        }else
            return num;
    }
    public static int maximumSwap(int num) {
        String sNum = num + "";
        char[] charNum = sNum.toCharArray();
        int indexToSwap = -1;
        int withIndex = -1;
        int[] indexArray = new int[sNum.length()];
        int[] maxFromRight = new int[sNum.length()];
        int lastMax = -1;
        for (int i = sNum.length() - 1; i >=0 ; i--) {
            final int currentDigit = sNum.charAt(i) - '0';
            if(currentDigit > lastMax){
                indexArray[i] = i;
                maxFromRight[i] = currentDigit;
                lastMax = currentDigit;
            }
            else{
                indexArray[i] = indexArray[i+1];
                maxFromRight[i] = maxFromRight[i+1];
            }
        }
        for (int i = 0; i < sNum.length(); i++) {
            final int currentDigit = sNum.charAt(i) - '0';
            if(currentDigit != maxFromRight[i]){
                indexToSwap = indexArray[i];
                withIndex = i;
                break;
            }
        }
        if(indexToSwap != -1){
            char temp = charNum[indexToSwap];
            charNum[indexToSwap] = charNum[withIndex];
            charNum[withIndex] = temp;
            String result = "";
            for (int i = 0; i <charNum.length; i++) {
                result = result + charNum[i];
            }
            return Integer.parseInt(result);
        }
        else return num;
    }
}
