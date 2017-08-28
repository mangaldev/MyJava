package leetcode;

public class Prob38 {
    public String countAndSay(int n) {
        String last = "1";
        String current = "";
        for(int i = 2;i <= n; i++){
            for(int j=0;j<last.length();j++){
                int dig = last.charAt(j) - '0';
                int count = 1;
                while(++j< last.length() && (last.charAt(j) - '0') == dig){
                    count++;
                }
                j = j -1;
                current = current + count +""+ dig;
            }
            last = current;
            current = "";
        }
        return last;
    }
}
