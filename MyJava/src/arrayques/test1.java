package arrayques;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mdev on 4/22/15.
 */
public class test1 {
    String A = "a";

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof test1)) return false;

        test1 test1 = (test1) o;

        if (A != null ? !A.equals(test1.A) : test1.A != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return A != null ? A.hashCode() : 0;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List object = list;
        object.add(3);
        object.add("sdfsf");
        Number n = new Integer(2);
        int i = -2;
        System.out.println("i%10 = " + i % 10);
//        List<Integer> nums = new ArrayList<Number>();


    }

    class ThreadTest {
        Object lock = new Object();
        public void test() throws InterruptedException {
            lock.wait();
            lock.notify();

        }
    }

    public Integer add(Integer a, Integer b) {
        return new Integer(1);
    }

    public Float add(int a, Integer b) {
        return new Float(1);
    }
}
