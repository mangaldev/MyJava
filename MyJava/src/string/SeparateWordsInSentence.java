package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by mdev on 4/26/15.
 */
public class SeparateWordsInSentence {
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) {
        String[] words = {"there", "are", "so", "me","some","the","re"};

        for (String word:words) {
            set.add(word);
        }
//        print("therearesome",new ArrayList<>());
        String input = "Mangal";
        System.out.println(input.substring(0,2)+input.substring(3));
        System.out.println(Integer.parseInt("1a2"));
    }

    public static void print(String input, List<String> list) {
        if (input.length() == 0) {
            for(String word:list){
                System.out.printf("%s ",word);
            }
            System.out.println();
            return;
        }

        for (int i = 0; i <= input.length(); i++) {
            String cur = input.substring(0,i);
            if(set.contains(cur)){
                list.add(cur);
                print(input.substring(i), list);
                list.remove(cur);
            }
        }
    }
}
