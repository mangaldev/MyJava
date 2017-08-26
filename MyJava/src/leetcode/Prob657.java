package leetcode;

public class Prob657 {
    public static void main(String[] args) {
        System.out.println(judgeCircle("LL"));
    }
    public static boolean judgeCircle(String moves) {
        int l = 0, u = 0;
        for (int i = 0; i < moves.length(); i++) {
            final char c = moves.charAt(i);
            if(c =='L') l++;
            else if(c == 'R') l--;
            else if( c == 'U') u++;
            else if(c == 'D') u--;
        }
        return (l==0 && u==0);
    }
}
