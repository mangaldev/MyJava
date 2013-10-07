package client;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	private static Map<Integer,Long> cachedMap = new HashMap<Integer,Long>();
	static{
		cachedMap.put(0, new Long(1));
		cachedMap.put(1, new Long(1));
		cachedMap.put(2, new Long(2));
		cachedMap.put(3, new Long(3));
		cachedMap.put(4, new Long(5));
		cachedMap.put(5, new Long(8));
		cachedMap.put(6, new Long(13));
		cachedMap.put(7, new Long(21));
		cachedMap.put(8, new Long(34));

	}
	public static void main(String... args){
		System.out.println("Calculating Fibonacci ...");
		final int NUM = 50;
		for(int i =0;i<NUM ;i++)
			System.out.print(" , "+fib(i));
	}

	private static Long fib(int i){
		if(cachedMap.containsKey(i))
			return cachedMap.get(i);
		else{
			if(!cachedMap.containsKey(i-1))
				cachedMap.put(i-1, fib(i-1));
			if(!cachedMap.containsKey(i-2))
				cachedMap.put(i-2, fib(i-2));
			return cachedMap.get(i-1) + cachedMap.get(i-2);
		}
	}
}
