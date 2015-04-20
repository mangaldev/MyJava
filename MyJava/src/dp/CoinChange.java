package dp;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {

	public static void main(String... args){
//		int[] input = new int[]();
//		findMinExchange();
	}
    static Map<Integer, Integer> cache = new HashMap<>();
	public static int findMinExchange(int[] input, int currentValue, int coinCount){
		if(currentValue  == 0){
			return coinCount;
		}
		if(cache.containsKey(currentValue))
			return cache.get(currentValue);
		for(int i : input)
		{
			int minCount = findMinExchange(input,currentValue - i,coinCount+1);
			if(cache.containsKey(currentValue - i))
			{
				int count = cache.get(currentValue - i);
				if(minCount < count)
					cache.put(currentValue - i, minCount);
			}
			else
			{
				cache.put(currentValue - i, minCount);
			}
		}
		return cache.get(currentValue);
	}
}
