package dp;

public class EditDistance {

	public EditDistance() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		editDistance("sunday","saturday");
	}

	private static void editDistance(String str1,String str2){
		int len1 = str1.length();
		int len2 = str2.length();
		int[][] mat = new int[len1+1][len2+1];
		for(int i =0;i<len2+1;i++)
			mat[0][i] = i;
		for(int i =0;i<len1+1;i++)
			mat[i][0] = i;
		for(int i=1;i<len1+1;i++){
			for(int j=1;j<len2+1;j++){
				if(str1.charAt(i-1) == str2.charAt(j-1))
					mat[i][j] = mat[i-1][j-1];
				else{
					mat[i][j] = min(mat[i-1][j],mat[i-1][j-1],mat[i][j-1])+1;
				}
			}
		}
		for(int i=0;i<len1+1;i++){
			System.out.println();
			for(int j=0;j<len2+1;j++){
				System.out.print(" "+mat[i][j]);
			}
		}
	}



	private static int min(int a,int b,int c){
		if(a<b && a<c)
			return a;
		else if(b<a && b<c)
			return b;
		else
			return c;
	}
}
