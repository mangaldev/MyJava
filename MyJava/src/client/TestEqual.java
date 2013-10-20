package client;

import java.util.Date;

public class TestEqual {
    public TestEqual() {
        super();
    }
    
 
    public static void main(String args[]){
      Student s1 = new Student(5,3);
      Student s2 = new Student(5,3);
      BigStudent bs = new BigStudent(5,3);
      if(s1.equals(s2))
          System.out.println("true");
      else
          System.out.println("false");
      
      if(bs.equals(s1))
        System.out.println(" sdsfds true");
        else
        System.out.println(" sdfs false");
      Date d = new Date();
      System.out.println( d.toString());
    }
}


