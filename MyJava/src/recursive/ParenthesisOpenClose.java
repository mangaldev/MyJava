package recursive;

import java.util.*;

/**
 * Created by mdev on 3/17/15.
 */
public class ParenthesisOpenClose {

    public Set<String> putParenthesis(int count){
        if(count == 1)
           return new HashSet<>(Arrays.asList("()"));
        Set<String> resultSet = new HashSet<>();
        for(String str:putParenthesis(count - 1)){
            for (int i = 0; i < str.length(); i++) {
                resultSet.add("("+str.substring(0,i) + ")" + str.substring(i)) ;
            }
        }
        return resultSet;
    }
    
    public static void parenthesis(String str, int n, int l, int r) {
		if (l < r) return;
		if (l==n && r == n) {
			System.out.println(str);
			return;
		}
		if (l<=n) {
			parenthesis(str+"(", n, l+1, r);
		}
		if (r <=n ) {
			parenthesis(str+")", n, l, r+1);
		}
	}

    public static void main(String... args){
        ParenthesisOpenClose prob = new ParenthesisOpenClose();
        Set<String> result = prob.putParenthesis(4);
        System.out.println("result = " + result);
    }
}
