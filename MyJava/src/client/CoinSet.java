package client;

public class CoinSet {

	public CoinSet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr[] = {1, 2, 3};
		    int m = 3;
		    int n = 6;
		    System.out.printf(" %d ", count(arr, m, n));
	}
	
	private static int count=0;
//	private static int recursive(int[] arr, int m, int sum){
//		if(sum(arr) == sum)
//			count++;
//		for(int i=0;i<m;i++){
//			
//		}
//	}
	
	private static int count( int S[], int m, int n )
	{
	    // table[i] will be storing the number of solutions for
	    // value i. We need n+1 rows as the table is consturcted
	    // in bottom up manner using the base case (n = 0)
	    int[] table = new int[n+1];
	 
	 
	    // Base case (If given value is 0)
	    table[0] = 1;
	 
	    // Pick all coins one by one and update the table[] values
	    // after the index greater than or equal to the value of the
	    // picked coin
	    for(int i=0; i<m; i++){
	    	printTable(table);
	    	System.out.println("\n--------------------------------");
	        for(int j=S[i]; j<=n; j++){
	            table[j] += table[j-S[i]];
	            printTable(table);
	        }
	    }
	 
	    return table[n];
	}

	

	private static void printTable(int[] s) {
		// TODO Auto-generated method stub
		System.out.println();
		for(int i =0;i<s.length;i++){
			System.out.print(" "+s[i]);
		}
		
	}

}
