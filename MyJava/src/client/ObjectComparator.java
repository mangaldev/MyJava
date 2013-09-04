package client;

import java.util.List;

public class ObjectComparator implements Comparable{
	private String name;
	public ObjectComparator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ObjectComparator other = (ObjectComparator) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		List<String> firstList = new ArrayList<String>();
//		List<String> firstList = new ArrayList<String>();
		Object x = new String[]{"123"};
		Object[] arr = (Object[]) x;
		arr[0] = 1;
		System.out.println("");
	}

	@Override
	public int compareTo(Object that) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean compare(Object first,Object second){
		if(first==second)
			return true;
		if(first == null || second == null)
			return false;
		if(first instanceof List && second instanceof List){
			List firstList = (List) first;
			List secondList = (List) second;
			if(firstList.size() != secondList.size())
				return false;
			//assuming we have overrided equals for List Objects
			for(int i = 0; i < firstList.size(); i++){
				Object o1 = firstList.get(i);
				Object o2 = secondList.get(i);
				if(o1==null && o2==null)
					return false;
				if(o1.equals(secondList.get(i)))
					return true;
			}
		}
		return false;	
	}

}
