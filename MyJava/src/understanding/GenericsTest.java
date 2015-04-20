package understanding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mdev on 4/20/15.
 */
public class GenericsTest {
    List<Object> list = new ArrayList<>();


    public GenericsTest(List<Object> list) {
        this.list = list;
    }

    public static void main(String[] args) {
        List<String> objList = new ArrayList<>();
//        GenericsTest test = new GenericsTest(objList);
    }


}
