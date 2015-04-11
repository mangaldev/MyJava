package client;

/**
 * Created by mdev on 4/10/15.
 */
public class PrintSetOfNCharsWithKLength {

    private int n = 0;

    public static void main(String[] args) {
        PrintSetOfNCharsWithKLength prob = new PrintSetOfNCharsWithKLength();
        prob.print(new char[]{'a', 'b'}, 3,"");
    }

    public void print(char[] charset, int k, String result) {
        if(k == 0){
            System.out.println(result);
            return;
        }
        for (int i = 0; i < charset.length; i++) {
            print(charset,k-1,result+charset[i]);
        }
    }
}
