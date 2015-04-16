package recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mdev on 4/12/15.
 * Recursively print all sentences that can be formed from list of word lists
 Given a list of word lists How to print all sentences possible taking one word from a list at a time via recursion?

 Example:

 Input: {{"you", "we"},
 {"have", "are"},
 {"sleep", "eat", "drink"}}

 Output:
 you have sleep
 you have eat
 you have drink
 you are sleep
 you are eat
 you are drink
 we have sleep
 we have eat
 we have drink
 we are sleep
 we are eat
 we are drink
 */
public class PrintAllCombinations {


    public static void main(String[] args) {
        String[][] input = new String[][]{{"you", "we"},
                {"have", "are"},
                {"sleep", "eat", "drink"}};
        List<List<String>> main = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            List list = new ArrayList<>();
            for (int j = 0; j < input[i].length; j++) {
                list.add(input[i][j]);
            }
            main.add(list);
        }

        print(main, new ArrayList<>(), 0);
    }

    static void print(List<List<String>> input, List<String> currentList, int setNum) {
        if (setNum == input.size()) {
            currentList.stream().forEach(str -> System.out.print(" " + str));
            System.out.println();
            return;
        }
        List<String> thisList = input.get(setNum);
        for (String i : thisList) {
            currentList.add(i);
            print(input, currentList, setNum + 1);
            currentList.remove(i);
        }
    }


}

