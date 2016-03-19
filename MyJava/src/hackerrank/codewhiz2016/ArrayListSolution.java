package hackerrank.codewhiz2016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by mdev on 3/8/16.
 *
 5
 12 0 1 78 12
 2
 Insert
 5 23
 Delete
 0
 */
public class ArrayListSolution {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int listLength = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>(listLength);
        while(listLength-- != 0){
            list.add(scanner.nextInt());
        }
        int numOperations = scanner.nextInt();
        while(numOperations-- != 0){
            String operation = scanner.next();
            if(operation.equals("Insert"))
                list.add(scanner.nextInt(),scanner.nextInt());
            else
                list.remove(scanner.nextInt());
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if(i != list.size() - 1 ){
                System.out.print(" ");
            }
        }
    }
}
