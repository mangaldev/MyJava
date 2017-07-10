package interviewbit;

import java.util.ArrayList;

/**
 * Created by mdev on 8/8/16.
 */
public class Rearrange {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0);
        list.add(3);
        list.add(2);
        new Rearrange().arrange(list);
    }

    public void arrange(ArrayList<Integer> a) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == i)
                continue;
            int nextVal = a.get(i);
            while (true){
                if(a.get(nextVal) == nextVal)
                    break;
                int nextNextVal = a.get(nextVal);
                a.set(nextVal,nextVal);
                nextVal = nextNextVal;
            }
        }
        for (int i = 0; i < a.size(); i++) {
            System.out.printf(" %d ", a.get(i));
        }
    }
}
