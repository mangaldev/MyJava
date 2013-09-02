package dp;

public class HammingDistance {

	public HammingDistance() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(calculateHammingDistance(15,10));
	}
	
	private static int calculateHammingDistance(int x,int y){
		int z = x ^ y;
		int count = 0;
		if(z==0)
			return 0;
		while(z!=0){
			count++;
			z = z & (z-1);
		}
		return count;
	}

}
