package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class JobsScheduling {

	static Map<Integer, Integer> result = new HashMap<>();
	List<Asset> assets = new ArrayList<>();

	static class Asset implements Comparable {
		public int a, b, c;

		@Override
		public int compareTo(Object o1) {
			Asset that1 = (Asset) o1;
			Asset that2 = this;// (Asset)o2;
			if (that1.b < that2.b)
				return 1;
			else if (that1.b > that2.b)
				return -1;
			else
				return 0;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Asset [a=");
			builder.append(a);
			builder.append(", b=");
			builder.append(b);
			builder.append(", c=");
			builder.append(c);
			builder.append("]");
			return builder.toString();
		}

	}

	public void getInput() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			Asset ass = new Asset();
			ass.a = sc.nextInt();
			if (ass.a == -1)
				break;
			ass.b = sc.nextInt();
			ass.c = sc.nextInt();
			assets.add(ass);
		}
		
	}

	public static void main(String... args) {
		JobsScheduling scheduler = new JobsScheduling();
		scheduler.getInput();
		Collections.sort(scheduler.assets);
		result.put(0, scheduler.assets.get(0).c);
		int maxProfit = scheduler.getMax(scheduler.assets, scheduler.assets.size() - 1);
		System.out.println("Maximum Profit : "+ maxProfit);

	}

	public int getMax(List<Asset> arr, int currentIndex) {
		if (result.containsKey(currentIndex))
			return result.get(currentIndex);
		int lastIndex = -1;
		for (int j = currentIndex - 1; j >= 0; j--) {
			if (arr.get(j).b <= arr.get(currentIndex).a) {
				lastIndex = j;
				break;
			}
		}		
		int includeProfie = arr.get(currentIndex).c;
		int excludeProfit = 0;
		
		if (lastIndex != -1)
			includeProfie +=  getMax(arr, lastIndex);
		else
			excludeProfit = getMax(arr, currentIndex - 1);
		
		result.put(currentIndex, Integer.max(includeProfie, excludeProfit));
		return result.get(currentIndex);
	}
}
