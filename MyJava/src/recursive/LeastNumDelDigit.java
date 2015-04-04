package recursive;

/**
 * Created by mdev on 3/30/15.
 */
public class LeastNumDelDigit {

    public static void main(String[] args) {
        String result = findLeastNum("24635",3);
        System.out.println("result = " + result);
    }

    public static String findLeastNum(String strNum, int k){
        System.out.println("strNum = " + strNum);
        if(k == 0)
            return strNum;
        int lastNum  = -1;
        int i ;
        for (i = 0; i < strNum.length(); i++) {
            int n = Character.getNumericValue(strNum.charAt(i));
            if(n < lastNum)
                break;
            else
                lastNum = n;
        }
       return findLeastNum(strNum.substring(0,i-1)+strNum.substring(i),--k);
    }

}
