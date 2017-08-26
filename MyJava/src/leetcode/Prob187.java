package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mdev on 7/23/17.
 */
public class Prob187 {

    Map<String,Integer> map = new HashMap<>();
    public List<String> findRepeatedDnaSequences(String input) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < input.length() - 9; i++) {
            String substring = input.substring(i,i+10);
            if(!map.containsKey(substring)){
                map.put(substring,1);
            }
            else{
                map.put(substring,map.get(substring)+1);
            }
        }
        for (String s : map.keySet()) {
            if(map.get(s) > 1){
                result.add(s);
            }
        }
        return result;
    }
}
