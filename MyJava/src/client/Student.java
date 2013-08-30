package client;

public class Student extends Object{
    public Student() {
        super();
    }
  int a;
  int b;
  Student(int a,int b){
    this.a = a;
    this.b = b;
  }
  
  @Override
  public  boolean equals(Object s){
      System.out.println("coming to here");
      if(!(s instanceof Student ))
          return false;
      Student st = (Student)s;
      if(st.getA() == this.a && st.getB() == this.b)
          return true;
    return  false;
  }

    public void setA(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getB() {
        return b;
    }
}
