package thread;

public class Mass360 
{

	public static void main(String... args){
		runCustomerSimulation (2, "ABBAJJKZKZ");
		runCustomerSimulation (3, "GACCBDDBAGEE");
		runCustomerSimulation (3, "GACCBGDDBAEE");
		runCustomerSimulation (1, "ABCBCA");
		runCustomerSimulation (1, "AFGBCFBGCAWW");
	}
	
	static int runCustomerSimulation (int numComputers, String customers) {
		if(customers == null || customers.length() == 0)
			return 0;
		int counter = 0,leftCustomers = 0;
		boolean[] result = new boolean[26];
		for(int i =0 ;i<customers.length();i++){
			char ch = customers.charAt(i);
			if(result[ch-65]){
				result[ch-65] = false;
				counter--;
			}
			else{
				result[ch-65] = true;
				counter++;
				if(counter>numComputers){
					leftCustomers++;
				}
			}
		}
		System.out.println(leftCustomers);
		return leftCustomers;
	}
}
