package uva;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JollyJumper10038 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);

		while(s.hasNextLine()){
			boolean isjolly  = true;
			String[] nums = s.nextLine().split(" ");
			int[] result = new int[nums.length-1];
			if(nums.length == 1)
				isjolly  = true;
			int lastInt = Integer.valueOf(nums[0]);
			for(int i =1;i<nums.length;i++){
				int thisInt = Integer.valueOf(nums[i]);	
				int index = Math.abs( thisInt- lastInt);
				if(index < result.length)
					result[index] = 1;
				lastInt = thisInt;
			}
			for(int i =1;i<result.length;i++){
				if(result[i] != 1){
					isjolly = false;
					break;
				}
			}
			if(isjolly)
				System.out.println("Jolly");
			else
				System.out.println("Not jolly");
		}
	}

}
