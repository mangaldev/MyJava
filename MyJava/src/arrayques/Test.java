package arrayques;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mdev on 4/19/15.
 */
public class Test extends Object{
    public String name = "amngl";

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Test)) return false;

        Test test = (Test) o;

        if (!name.equals(test.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public static void main(String[] args) {
        String input = "";
        input = input.toLowerCase();
        List list1 = new ArrayList<>();
        list1.add("mangal");
        List list2 = list1;
        list2.add(new Test());
        for (Object o : list2) {
            System.out.println("o.toString() = " + o.toString());
        }

        Map<Character,String> map = new HashMap<>();
        map.put(new Character('a'),"a");
        map.put(new Character('b'),"b");
        map.put(new Character('a'),"b");
        System.out.println(map);
    }

    public static int get(String input) {
        boolean[] result = new boolean[26];
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 97 && input.charAt(i) <= 122) {
                if (!result[input.charAt(i) - 97])
                    result[input.charAt(i) - 97] = true;
            }
        }
        for (int i = 0; i < result.length; i++) {
            if (!result[i]) {
                return 0;
            }
        }
        return 1;
    }

}
