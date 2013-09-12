package sorting;

public class TwoDBinarySearch {

	public TwoDBinarySearch() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		if(leftDownApproach(mat,2,2,9,2))
			System.out.println("Found Element");
	}

	public static boolean leftDownApproach(int mat[][],int m,int n,int element,int max){
		if(mat[m][n] == element){
			return true;
		}
		else if(element > mat[m][n])
		{
			if(m+1<max)
				leftDownApproach(mat,m+1,n,element,max);
		}
		else if(element < mat[m][n])
		{
			if(n-1>=0)
				leftDownApproach(mat,m,n-1,element,max);
		}
		return false;
	}
}
