package arrayques;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by mdev on 4/16/15.
 */
public class Confusing {



    public void abc(List o){
        System.out.println("Confusing.abcc");
    }
    public void abc(Object o){
        System.out.println("Confusing.abc");
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
