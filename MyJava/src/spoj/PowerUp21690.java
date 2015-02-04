package spoj;

import java.math.BigInteger;
import java.util.Scanner;

public class PowerUp21690 {
	public static BigInteger mod1 = new BigInteger("1000000006");
	public static BigInteger mod2 = new BigInteger("1000000007");
	public static BigInteger zero = new BigInteger("0");
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if(a==-1 && b==-1 && c==-1)
				break;			
			BigInteger A = new BigInteger(a+"");
			BigInteger B = new BigInteger(b+"");
			BigInteger C = new BigInteger(c+"");			
			BigInteger d = B.modPow(C, mod1);			
			BigInteger result ;			
			if(A.equals(zero) && B.equals(new BigInteger("1000000006")) && C.equals(new BigInteger("1000000006")))			
				result = new BigInteger("0");			
			else
				result = A.modPow(d,mod2);
			System.out.println(result);
		}
	}

}
