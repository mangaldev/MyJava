import java.util.Scanner;


public class Spiral {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		Spiral sp = new Spiral();
		int[][] mat = sp.createMatrix(size);
		sp.printMatrix(mat);
		System.out.println();
		System.out.println("-------- Result --------");
		sp.printSpiral(mat,size);
	}
	
	public void printSpiral(int[][] mat,int size){
		int total = ((size * size)% 2 == 0) ? (size * size):(size * size) - 1; 		
		int count = 0;
		int lb = 0;
		int rb = size - 1;
		int ub = 0;
		int db = size - 1;
		while(count < total ){
			for(int i = lb;i<rb;i++){
				count++;
				System.out.printf(" %d ",mat[ub][i]);
			}
			for(int i = ub;i<db;i++){
				count++;
				System.out.printf(" %d ",mat[i][rb]);
			}
			for(int i = rb;i>lb;i--){
				count++;
				System.out.printf(" %d ",mat[db][i]);
			}
			for(int i = db;i>ub;i--){
				count++;
				System.out.printf(" %d ",mat[i][lb]);
			}
			lb++;
			rb--;
			ub++;
			db--;
		}
		if((size * size)%2 != 0)
			System.out.printf(" %d ",mat[(size)/2][(size)/2]);
	}
	
	public int[][] createMatrix(int size){
		int[][] newMat = new int[size][size];
		int count = 1;
		for(int i = 0 ;i<size;i++)
			for(int j = 0 ;j<size;j++)
				newMat[i][j] = count++;
		return newMat;
	}
	
	public void printMatrix(int[][] arr){
		int size = arr[0].length;
		for(int i = 0 ;i<size;i++)
		{
			System.out.println();
			for(int j = 0 ;j<size;j++)
			{
				System.out.printf(" %d ",arr[i][j]);
			}
		}
	}
	

}
