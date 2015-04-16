package string;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mdev on 4/12/15.
 *
 Example:

 Input: str1 = "AB",  str2 = "CD"
 Output:
 ABCD
 ACBD
 ACDB
 CABD
 CADB
 CDAB

 Input: str1 = "AB",  str2 = "C"
 Output:
 ABC
 ACB
 CAB
 */
public class InterleavingStrings {


    public static void main(String[] args) {
        print("AB","CD","");
    }

    public static void print(String str1,String str2, String result){
        if(result.length() == 4){
            System.out.println(result);
            return;
        }

        if(!str1.equals(""))
            print(str1.substring(1),str2,result+str1.charAt(0));

        if(!str2.equals(""))
            print(str2.substring(1),str1,result+str2.charAt(0));

    }
}
