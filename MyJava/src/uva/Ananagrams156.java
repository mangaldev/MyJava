package uva;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Ananagrams156 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String,String> map = new HashMap<String,String>();
		String word = sc.next();
		while(!word.equalsIgnoreCase("#")){
			String key = word;
			char[] aword = word.toLowerCase().toCharArray();
			Arrays.sort(aword);
			word = String.copyValueOf(aword);
			if(map.containsKey(word))
				map.put(word, null);
			else
				map.put(word, key);
			word = sc.next();
		}
		List<String> list = new ArrayList<String>();
		for(String key: map.keySet()){
			if(map.get(key)!=null)
				list.add(map.get(key));
		}
		Collections.sort(list);
		for(String s:list)
			System.out.println(s);
	}

}
