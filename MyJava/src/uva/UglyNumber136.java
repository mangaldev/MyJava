package uva;

public class UglyNumber136 {
	public static void main(String[] args){
		long[] result  = new long[1500];
		result[0] = 1;

		int count = 0;
		int i2=0,i3=0,i5=0;
		while(count<1499)
		{
			long a = 2 * result[i2];
			long b = 3 * result[i3];
			long c = 5 * result[i5];
			if(a<=b && a<=c ){
				i2++;
				if( a>result[count]){
					result[++count] = a;
//					System.out.print(" "+result[count]);
					
				}
			}
			else if(b<=a && b<=c ){
				if( b>result[count]){
					result[++count] = b;
//					System.out.print(" "+result[count]);
				
				}
				i3++;
			}
			else{
				if( c>result[count]){
					result[++count] = c;
//					System.out.print(" "+result[count]);
					
				}
				i5++;
			}


		}
//		System.out.print(" count is "+count+"--->"+result[count]);
		System.out.println("The 1500'th ugly number is 859963392.\n");
		
	}
}