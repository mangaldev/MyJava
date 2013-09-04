package client;
import java.io.Serializable;
import java.util.Comparator;

public class Hierarchy{
	private static void p(Object msg) {
		System.out.println(msg);
	}

	public static class Super {

		public void do1(int i) {
			p("Super.do1(int)");
		}

		public void doNumber(Number n){
			p("Super.doNumber(Number)");
		}
	}
	
	public static class C extends Super{

//        public void do1(int i) {
//	        p("C.do1(int)");
//        }
		
//		public void do1(Integer i){
//			p("C.do1(Integer)");
//		}
//		
		public void do1(long i){
			p("C.do1(long)");
		}
		
		public void do1(short i){
			p("C.do1(short)");
		}
		
		public void doNumber(Integer n){
			p("C.doNumber(Integer)");
		}
		
		public void doNumber(Serializable n){
			p("C.doNumber(Serializable)");
		}

		public void doNothing(Serializable n){
			p("do nothing ");
		}
		
	}
	
	public static void main(String[] args){
		if(null == null)
			System.out.println("return true");
		Super o = new C();
		C c = (C) o;
		Integer i = 1;
		o.do1(i);
		c.do1(i);
	}
//	private static boolean compare(Object value1, Object value2){
//	    BeamArtifactChange change = new BeamArtifactChange();
//	    if(value1 == null && value2 == null)
//	      return false;
//	    
//	    if(value1 == null && value2 != null || value1 != null && value2 == null){
//	      return true;
//	    }else{
//	      if(value1 instanceof List && value2 instanceof List){
//	        List list1 = (List)value1;
//	        List list2 = (List)value2;
//	        if(list1.size() != list2.size()){
//	          return true;
//	        }else{
//	          for(int i = 0; i < list1.size(); i++){
//	            if(!list1.get(i).equals(list2.get(i))){
//	              return true;
//	            }
//	          }
//	        }
//	      }else if(value1.getClass().isArray()  && value2.getClass().isArray()){
//	        Object[] list1 = (Object[])value1;
//	        Object[] list2 = (Object[])value2;
//	        if(list1.length != list2.length)
//	          return true;
//	        else{
//	          for(int i = 0; i < list1.length; i++){
//	            if(!list1[i].equals(list2[i])){
//	              return true;
//	            }
//	          }
//	        }
//	      }else if(!value1.equals(value2))
//	         return true;
//	      else 
//	        return false;
//	    }
//	    
//	    //change.setOldValue(value1);
//	    //change.setNewValue(value2);
//	    return false;
//	  } 

}