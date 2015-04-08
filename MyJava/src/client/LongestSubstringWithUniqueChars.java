package client;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mdev on 4/7/15.
 */

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class LongestSubstringWithUniqueChars {
    public static void main(String[] args) {
        int answer = LengthOfLongestSubstring("abcdcefcg");
        System.out.println(answer);
        answer = LengthOfLongestSubstring("abcbaebcdef");
        System.out.println(answer);
        answer = LengthOfLongestSubstring("abccbaabccba");
        System.out.println(answer);
        answer = LengthOfLongestSubstring("inprobabilitytheoryandstatisticsamedianisdescribedasthenumericvalueseparating");
        System.out.println(answer);
        answer = LengthOfLongestSubstring("");
        System.out.println(answer);
        answer = LengthOfLongestSubstring("bbbbb");
        System.out.println(answer);
        answer = LengthOfLongestSubstring("abcabcde");
        System.out.println(answer);



    }

//  e.g acbab //    abcabcbb
    //d - 3
    //c - 4 e - 5 f -


    public static int LengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int max_length  = 0;
        for(int i = 0 ; i< s.length();i++){//abcdcefcg
            List<Character> toRemove = new ArrayList<>();
            if(map.containsKey(new Character(s.charAt(i)))){
                int old_index = map.get(new Character(s.charAt(i))); // c->2
                map.put(new Character(s.charAt(i)),i); //c-> 4
                int min = 100000;
                int max = -1;
                for(Character c : map.keySet()){
                    int data = map.get(new Character(c));
                    if(data <= old_index){
                        toRemove.add(c);
                        continue;
                    }
                    if(min > data) // min 3 max // 4
                        min = data;
                    else if(data > max) {
                        max = data;
                    }
                }

                for(Character c : toRemove){
                    map.remove(c);
                }
                int curr_result = max - min + 1;
                if(curr_result > max_length)
                    max_length = curr_result;
            }

            else{ // a -> 0 b -> 1 c -> 2 d ->3 e->5
                map.put(new Character(s.charAt(i)),i);
                int len = map.keySet().size();//4
                if(len > max_length)
                    max_length  = len;//4
            }
        }
        return max_length;
    }

}

/*
Your previous Java content is preserved below:


// Given a string, find the length of the longest substring without repeating characters.
// For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
// For "ccccc" the longest substring is "c", with the length of 1
// For "ddddded" the longest substring is "de", with the length of 2

// Please implement the algorithm and add some test cases

/* Example stub

using System;

// To execute C#, please define "static void Main" on a class
// named Solution.
class Solution {
    public static int LengthOfLongestSubstring(string s) {
        return 0;
    }

    static void Main(string[] args) {
        int answer = LengthOfLongestSubstring("dddddded");
        System.Console.WriteLine(answer);
    }
}

*/

