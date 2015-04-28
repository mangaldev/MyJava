package hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by mdev on 4/26/15.
 */


public class GameOfThrones {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        String inputString = myScan.nextLine();

        String ans = "YES";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < inputString.length(); i++) {
            if (map.containsKey(inputString.charAt(i)))
                map.put(inputString.charAt(i), map.get(inputString.charAt(i)) + 1);
            else
                map.put(inputString.charAt(i), 1);

        }
        int oddCount = 0;
        for (char key : map.keySet()) {
            if (map.get(key) % 2 != 0) {
                oddCount++;
            }
            if (oddCount > 1) {
                ans = "NO";
                break;
            }
        }
        // Assign ans a value of YES or NO, depending on whether or not inputString satisfies the required condition
        System.out.println(ans);
        myScan.close();
    }
}
