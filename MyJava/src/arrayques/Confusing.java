package arrayques;

import java.util.function.Consumer;

/**
 * Created by mdev on 4/16/15.
 */
public class Confusing {

    public void abc(double[] o){
        System.out.println("Confusing.abc");
    }
    public void abc(Object o){
        System.out.println("Confusing.abcc");
    }

    public static void abcd() {
        System.out.println("Confusing.abcd");
    }


    public static void main(String[] args) {
        Confusing c = new Confusing();
        c.abc(null);
        ((Confusing)null).abcd();
        Thread t  = new Thread();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
