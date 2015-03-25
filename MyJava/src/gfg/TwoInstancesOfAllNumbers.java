package gfg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TwoInstancesOfAllNumbers {


    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Mangal");
        names.add("Aakash");
        names.add("Mangall");
        names.forEach(name -> System.out.println(name));
        long count = names.stream()
                .filter(name -> name.startsWith("A"))
                .count();
        System.out.println("count = " + count);
        System.out.println(names.stream().distinct().count());
    }

}
