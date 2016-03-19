package puzzler;

/**
 * Created by mdev on 5/23/15.
 */
public class Puzzle1 {
    public static void main(String[] a) {
        long v = 1L << 63 - 3;
        System.out.print(v + " " + Math.round(v));
    }
}
