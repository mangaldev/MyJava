package client;


public class KadanesAlgo {
	static class Result{
		int x1,y1,x2,y2;
		int sum = Integer.MIN_VALUE;
	}

	public static Result applyKadens(int[] arr){
		for(int i:arr)
			System.out.print(i+",");
		System.out.println();
		int tempSum = 0;
		int start = 0;
		Result result = new Result();
		for(int i=0;i<arr.length;i++){
			tempSum += arr[i];
			if(result.sum<tempSum){
				result.sum = tempSum;
				result.x1 = start;
				result.x2 = i;
			}
			if(tempSum<0){
				tempSum = 0;
				start = i;
			}
		}
		return result;
	}

	public static Result applyKadensIn2D(int[][] arr,final int WID,final int HEIGHT){
		Result result = new Result();
		//		int maxSum = 0;
		int lb = 0;
		int rb = WID-1;
		for(int i = lb;i<=rb;i++){
			int[] temp = new int[HEIGHT];
			for(int j = i;j<=rb;j++){
				for(int k = 0;k<HEIGHT;k++){
					temp[k] += arr[k][j];
				}
				Result tempResult = applyKadens(temp);
				if(tempResult.sum > result.sum){
					result.sum = tempResult.sum;
					result.x1 = lb;
					result.x2 = rb;
					result.y1 = tempResult.x1;
					result.y2 = tempResult.x2;
				}
			}
		}
		return result;
	}

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args){
				int[] arr = {-1,-2,-3,-11,-6,-6,-13};
				Result r = applyKadens(arr);
		int[][] arr2 = {{1, 2, -1, -4, -20},
				{-8, -3, 4, 2, 1},
				{3, 8, 10, 1, 3},
				{-4, -1, 1, 7, -6}
		};
		int[][] arr1 = {{0, -2},
				{9 ,2},
				{-4 ,1},
				{-1 ,8},
				{-10 ,1},
				{-15 ,-1}};
		//r = applyKadensIn2D(arr1,2,6);
		System.out.println(r.sum);
		//System.out.println(r.x1+","+r.y1);
		//System.out.println(r.x2+","+r.y2);
		//		System.out.println(r.sum);
		;
	}

}