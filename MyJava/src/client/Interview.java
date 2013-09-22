package client;

import java.math.BigInteger;

public class Interview {
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Interview)) {
			return false;
		}
		Interview other = (Interview) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}
	private String name;
	public static void main(String[] args) {
		System.out.println(isInterleaved("ab","ae","aeab"));
	}

	public static boolean isInterleaved(String s1,String s2,String s3)
	{
		System.out.println("Checking interleaving for String1 :"+s1 +" String s2: "+ s2 +" String s3: "+s3);
		if(s3.length() == 0){
			if(s1.length() == 0 && s2.length() == 0)
				return true;
			else return false;
		}

		if(s1.length()>0 && s2.length()>0 && (s1.charAt(0) == s2.charAt(0)) && (s1.charAt(0) == s3.charAt(0)))
			return (isInterleaved(s1.substring(1),s2,s3.substring(1)) || isInterleaved(s1,s2.substring(1),s3.substring(1)));
		else if(s1.length()>0 && s1.charAt(0) == s3.charAt(0))
			return isInterleaved(s1.substring(1),s2,s3.substring(1));
		else if(s2.length()>0 && s2.charAt(0) == s3.charAt(0))
			return isInterleaved(s1,s2.substring(1),s3.substring(1));
		else
			return false;
	}
}