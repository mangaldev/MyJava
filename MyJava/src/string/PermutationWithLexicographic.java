package string;

/**
 * Created by mdev on 4/12/15.
 *
 Print all permutations with repetition of characters
 Given a string of length n, print all permutation of the given string. Repetition of characters is allowed. Print these permutations in lexicographically sorted order
 Examples:

 Input: AB
 Ouput: All permutations of AB with repetition are:
 AA
 AB
 BA
 BB

 */

public class PermutationWithLexicographic {

    public static void main(String[] args) {
        print("AB","");
    }

    public static void print(String input,  String result){
        if(result.length() == input.length()){
            System.out.println(result);
            return;
        }
        for (int i = 0; i < input.length(); i++) {
            print(input,result + input.charAt(i));
        }
    }
}
