package gfg;

public class FindSmalledPositiveInteger {
	
	public static void main(String... args){
		FindSmalledPositiveInteger prob = new FindSmalledPositiveInteger();
		int[] arr = {1, 2, 3, 4, 5, 6};
		int res = 1;
		for(int i = 0 ; i<arr.length;i++){
			if(res < arr[i])
				break;
			else
				res += arr[i];
		}
		System.out.println(res);
	}

}
