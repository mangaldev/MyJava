package prac;

public class Holder<T>{
    private T[] contents;
    private int index = 0;
    
    public static final String test = "test";
    public static void main(String[] args){
    	Holder h = null;
    	System.out.println(h.test);
    }
    public Holder(int size){
        //contents = new T[size]; //compiler error - generic array creation
        contents = (T[]) new Object[size]; //workaround - casting Object[] to generic Type
    }
  
    public void add(T content){
        contents[index] = content;
    }
  
    public T get(int index){
        return contents[index];
    }
}
