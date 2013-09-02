package client;

public class EightQueen {

	public EightQueen() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//		for(int index=0;index<8;index++){
		//			int[][] chess = new int[8][8];
		//			disableBlocks(chess,0,index);
		//			printMat(chess);
		//		}
		queens(1);
		print_solution();
	}

	private static void queens(int index)
	{
		for(arr[index]=1;arr[index]<=8;arr[index]++)
		{
			if(empty(index))
			{
				if(index==8)
				{
					print_solution();
					/* If this exit is commented, it will show ALL possible combinations */
					System.exit(0);
				}
				else
				{
					// Recurse!
					queens(index+1);
				}

			}// if

		}// for
	}
	private static boolean empty(int i)
	{
		int j;
		j=1;

		while(arr[i]!=arr[j] && Math.abs((arr[i]-arr[j]))!=(i-j) &&j<8)j++;

		return((i==j)?true:false);	
	}



	private static void print_solution()
	{
		int i;
		for(i=1;i<=8;i++)System.out.printf("\nt[%d] = [%d]",i,arr[i]);
	}

	private static int[] arr= new int[10];




	private static void printMat(int[][] chess)
	{
		boolean possible = true;
		for(int i=1;i<8;i++)
		{
			if(!possible)
				break;
			possible = false;
			for(int j=0;j<8;j++)
			{	
				if(chess[i][j] != -1)
				{
					possible = true;
					disableBlocks(chess,i,j);
				}
			}
		}
		//		if(possible)
		print(chess);
		System.out.println("\n----------------------------------------------------------");
	}



	private static void disableBlocks(int[][] chess,int i, int j) {
		for(int k = 0;k<8;k++){
			chess[i][k] = -1;
			chess[k][j] = -1;
			if(i-k>=0 && j-k>=0)
				chess[i-k][j-k] = -1;
			if(i-k>=0 && j+k<8)
				chess[i-k][j+k] = -1;
			if(j-k>=0 && i+k<8)
				chess[i+k][j-k] = -1;
			if(j+k<8 && i+k<8)
				chess[i+k][j+k] = -1;
		}
		chess[i][j] = 3;
	}

	private static void print(int[][] mat){
		for(int i=0;i<8;i++){
			System.out.println();
			for(int j=0;j<8;j++){
				System.out.print(" "+mat[i][j]);
			}
		}
	}

}
