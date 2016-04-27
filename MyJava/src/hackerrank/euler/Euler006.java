package hackerrank.euler;

import sun.jvmstat.perfdata.monitor.PerfStringVariableMonitor;

import java.util.Scanner;

/**
 * Created by mdev on 4/24/16.
 */
public class Euler006 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        while(testCases-- != 0){
            long n = scanner.nextLong();
            long result = (n * (n+1) * ((3*n*n) - n -2))/12;
            System.out.println(result);
        }
    }
}
