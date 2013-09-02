package client;

public class SwapBitsInNumber {

	public SwapBitsInNumber() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int res =  swapBits(28, 0, 3, 2);
//		System.out.printf("\nResult = %d ", res);
		System.out.println(Add(12,14));
	}

	private static int swapBits( int x,  int p1,  int p2,  int n)
	{
		
		System.out.println("x is "+Integer.toBinaryString(x));
		System.out.println("((1 << n) - 1) is "+Integer.toBinaryString((1 << n) - 1));
		
		/* Move all bits of first set to rightmost side */
		int set1 =  (x >> p1) & ((1 << n) - 1);
		System.out.println("set1 is "+Integer.toBinaryString(set1));
		/* Moce all bits of second set to rightmost side */
		int set2 =  (x >> p2) & ((1 << n) - 1);
		System.out.println("set2 is "+Integer.toBinaryString(set2));
		/* XOR the two sets */
		int xor = (set1 ^ set2);
		System.out.println("xor is "+Integer.toBinaryString(xor));
		/* Put the xor bits back to their original positions */
		xor = (xor << p1) | (xor << p2);
		System.out.println("xor is "+Integer.toBinaryString(xor));
		/* XOR the 'xor' with the original number so that the 
	       two sets are swapped */
		int result = x ^ xor;
		System.out.println("result is "+Integer.toBinaryString(result));
		return result;
	}
	
	private static int Add(int x, int y)
	{
		System.out.println("-1 is "+Integer.toBinaryString(-2));
		System.out.println("X is "+Integer.toBinaryString(x));
		System.out.println("Y is "+Integer.toBinaryString(y));
	    if (y == 0)
	        return x;
	    else
	        return Add( x ^ y, (x & y) << 1);
	}

}
