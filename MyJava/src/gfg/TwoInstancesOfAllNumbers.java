package gfg;

import java.util.LinkedList;
import java.util.List;

public class TwoInstancesOfAllNumbers {

        
	public static void main(String[] args) {
            List<String> names = new LinkedList<>();
            names.add("Mangal");
            names.forEach(name -> System.out.println(names));
	}

}
