package string;

import java.util.*;

/**
 * Created by mdev on 4/21/15.
 * Given an array of strings sort it such that the anagrams come side by side. A word is called anagram of another word, if one can be formed by rearranging the letters of the other, without any addition or deletion of letters.
 */
public class SortToBringAnagramsTogether {
    public static void main(String[] args) {
        String[] arr = {"dog", "listen", "tip", "enlist", "pit", "god", "man", "top", "pot"};
        Map<String,List<String>> map = new HashMap<>();
        for(String str:arr){
            char[] chararr = str.toCharArray();
            Arrays.sort(chararr);
            String newstr = new String(chararr);
            if(map.containsKey(newstr)){
                map.get(newstr).add(str);
            }
            else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(newstr,list);
            }
        }
        for(String key:map.keySet()){
            System.out.printf("%s ",map.get(key));
        }
    }
}

