package client;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class MedianInUnSortedString {

	static Queue<Integer> minHeap = new PriorityQueue<Integer>(100);
	static Queue<Integer> maxHeap = new PriorityQueue<Integer>(100,Collections.reverseOrder());
	public static void main(String... args){
		Scanner input = new Scanner(System.in);
		while(input.hasNextInt()){
			int newInput = input.nextInt();
			int median;
			if(newInput!=-1){
				System.out.printf("adding input == %d\n",newInput);
				add(newInput);
			}
			else{
				median = findAndDeleteMedian();
				System.out.printf("Median is == %d\n",median);
			}
			doBalanceHeaps();
			System.out.println(Arrays.asList(maxHeap.toArray()).toString());
			System.out.println(Arrays.asList(minHeap.toArray()).toString());

		}
	}


	private static void doBalanceHeaps() {
		int size1 = minHeap.size();
		int size2= maxHeap.size();
		if(size2 - size1 == 2){
			int minNum = maxHeap.poll();
			minHeap.add(minNum);
		}
		if(size1 - size2 == 2){
			int maxNum = minHeap.poll();
			maxHeap.add(maxNum);
		}

	}

	private static int findAndDeleteMedian() 
	{
		int size1 = maxHeap.size();
		int size2= minHeap.size();
		if(size1 >= size2)
			return maxHeap.poll();
		else
			return minHeap.poll();
	}

	static void add(int newInput){
		int size1 = maxHeap.size();
		int size2= minHeap.size();
		if(maxHeap.peek()==null || newInput <= maxHeap.peek())
			maxHeap.add(newInput);
		else
			minHeap.add(newInput);
	}
}
