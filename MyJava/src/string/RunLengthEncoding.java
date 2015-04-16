package string;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by mdev on 4/12/15.
 */
public class RunLengthEncoding {

    public static void main(String[] args) {
        print("wwwwaaadexxxxxx");
        print1("wwwwaaadexxxxxx");
    }

    private static void print1(String input) {
        System.out.println();
        Map<Character,Integer> map  = new LinkedHashMap<>();
        for (int i = 0; i < input.length(); i++) {
            if(map.containsKey(input.charAt(i))){
                map.put(input.charAt(i),map.get(input.charAt(i)) + 1);
            }
            else{
                map.put(input.charAt(i),1);
            }
        }
        for(char key: map.keySet()){
            System.out.printf("%c%d", key, map.get(key));
        }
    }

    public static void print(String input) {
        char last_char = '0';
        int count = 0;
        System.out.println("last_char = " + last_char);
        for (int i = 0; i < input.length(); i++) {
            if (last_char == '0' || last_char == input.charAt(i)) {
                count++;
            }
            else{
                System.out.printf("%c%d", last_char, count);
                count = 1;
            }
            last_char = input.charAt(i);
        }
        System.out.printf("%c%d",last_char,count);
    }
}

