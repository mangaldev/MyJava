package dp;

import java.util.Map;

public class CoinChange {

	public static void main(String... args){
//		int[] input = new int[]();
//		findMinExchange();
	}
	public static int findMinExchange(int[] input, int value, int currentValue, int coinCount,Map<Integer, Integer> cache){
		if(currentValue  == 0){
			return coinCount;
		}
		if(cache.containsKey(currentValue))
			return cache.get(currentValue);
		for(int i : input)
		{
			int minCount = findMinExchange(input,value,currentValue - i,coinCount+1,cache);
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
