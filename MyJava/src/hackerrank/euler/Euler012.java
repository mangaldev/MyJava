package hackerrank.euler;


import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Euler012 {


    private static Map<Integer,Long> maps = new TreeMap<>();
    static {
        maps.put( 1,1L);
        maps.put( 2,3L);
        maps.put( 4,6L);
        maps.put( 6,28L);
        maps.put( 8,66L);
        maps.put( 9,36L);
        maps.put( 10,496L);
        maps.put( 12,276L);
        maps.put( 14,8128L);
        maps.put( 16,120L);
        maps.put( 18,300L);
        maps.put( 20,528L);
        maps.put( 24,630L);
        maps.put( 26,33550336L);
        maps.put( 28,8256L);
        maps.put( 30,209628L);
        maps.put( 32,3570L);
        maps.put( 36,2016L);
        maps.put( 40,3240L);
        maps.put( 42,662976L);
        maps.put( 44,2096128L);
        maps.put( 45,41616L);
        maps.put( 48,5460L);
        maps.put( 50,3357936L);
        maps.put( 52,33558528L);
        maps.put( 54,64980L);
        maps.put( 56,400960L);
        maps.put( 60,41328L);
        maps.put( 64,32640L);
        maps.put( 66,169878528L);
        maps.put( 70,53752896L);
        maps.put( 72,39060L);
        maps.put( 80,61776L);
        maps.put( 84,204480L);
        maps.put( 88,18877440L);
        maps.put( 90,25200L);
        maps.put( 96,79800L);
        maps.put( 100,947376L);
        maps.put( 104,302002176L);
        maps.put( 108,97020L);
        maps.put( 112,73920L);
        maps.put( 120,270480L);
        maps.put( 126,119946816L);
        maps.put( 128,157080L);
        maps.put( 132,169860096L);
        maps.put( 140,53742528L);
        maps.put( 144,437580L);
        maps.put( 150,2881200L);
        maps.put( 156,301977600L);
        maps.put( 160,839160L);
        maps.put( 162,749700L);
        maps.put( 168,1385280L);
        maps.put( 176,102753280L);
        maps.put( 180,2049300L);
        maps.put( 192,1493856L);
        maps.put( 196,140574528L);
        maps.put( 200,7248528L);
        maps.put( 210,7874496L);
        maps.put( 216,10577700L);
        maps.put( 224,12457536L);
        maps.put( 240,2031120L);
        maps.put( 252,8923200L);
        maps.put( 256,3483480L);
        maps.put( 264,52433920L);
        maps.put( 270,209070576L);
        maps.put( 280,305156160L);
        maps.put( 288,4573800L);
        maps.put( 300,100472400L);
        maps.put( 320,2162160L);
        maps.put( 324,34283340L);
        maps.put( 336,73926720L);
        maps.put( 352,354432000L);
        maps.put( 360,30728880L);
        maps.put( 384,22582560L);
        maps.put( 400,164611440L);
        maps.put( 405,48024900L);
        maps.put( 416,838840320L);
        maps.put( 432,60769800L);
        maps.put( 448,48565440L);
        maps.put( 480,17907120L);
        maps.put( 486,722931300L);
        maps.put( 504,250891200L);
        maps.put( 512,163723560L);
        maps.put( 540,335936160L);
        maps.put( 560,803824560L);
        maps.put( 576,76576500L);
        maps.put( 600,468930000L);
        maps.put( 640,214980480L);
        maps.put( 648,103672800L);
        maps.put( 672,762041280L);
        maps.put( 720,438094800L);
        maps.put( 768,236215980L);
        maps.put( 896,1044039360L);
        maps.put( 1024,842161320L);
    }
//    private static long[] nums = new long[50000];

    public static void main(String[] args) {
//        setup();
        testcases();
    }

    private static void testcases() {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        while (tests-- != 0){
            long lowest = Integer.MAX_VALUE;
            int input = sc.nextInt();
            for (int key : maps.keySet()){
                if(key > input && maps.get(key)<lowest){
                    lowest = maps.get(key);
                }
            }

            System.out.println(lowest);
        }
    }

//    private static void setup() {
//        nums[0] = 1;
//        for (int i = 1; i < nums.length; i++) {
//            nums[i] = nums[i-1] + i+ 1;
//        }
//        for (long num : nums) {
//            int divisors = countDivisors(num);
//            maps.putIfAbsent(divisors, num);
//        }
//    }

//    private static int countDivisors(long num) {
//        int count = 0;
//        int i = 1;
//        for ( i = 1;i*i < num; i++) {
//            if(num%i == 0)
//                count++;
//        }
//        count *=2;
//        if (i*i == num){
//            count++;
//        }
//        return count;
//    }

}
