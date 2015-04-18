package understanding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mdev on 4/5/15.
 */
public class Test {

    public static void main(String[] args) {
        System.out.println((Integer) 128 == (Integer) 128);
        System.out.println((Integer) 222 == (Integer) 222);
        List<Integer> list = new ArrayList<>(100);
        list.add(1,1);
        System.out.println(list.toString());
    }
}
