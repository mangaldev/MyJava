package hackerrank.euler;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Created by mdev on 6/13/16.
 */
public class Euler019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while (cases-- != 0) {
            long year1 = sc.nextLong();
            int month1 = sc.nextInt();
            int date1 = sc.nextInt();
            long year2 = sc.nextLong();
            int month2 = sc.nextInt();
            int date2 = sc.nextInt();
            int count = 0;
            for (long i = year1; i <= year2; i++) {
                int j = 1;
                if(i == year1){
                    if(date1>1)
                        j = month1 + 1;
                    else
                        j = month1;
                }
                for (; j <= 12; j++) {
                    if(i == year2 && j>month2)
                        break;
                    if(isSunday(i,j,1)) {
                        count++;
                    }
                }
            }
            System.out.println(count);

        }
    }

    public static int noOfSundaysInFourCenturies() {
        int count = 0;
        for (int i = 1900; i <= 1910; i++) {
            for (int j = 1; j <= 12; j++) {
                if (LocalDate.of(i, j, 1).getDayOfWeek() == DayOfWeek.SUNDAY) {
                    System.out.println(LocalDate.of(i, j, 1));
                    count++;
                }
            }
        }
        System.out.println(count);
        return count;
    }

    private static boolean isSunday(long year, int month, int date) {
        int q = date;
        int m = month;
        if (month == 1) m = 11;
        else if (month == 2) m = 12;
        else
            m = month - 2;
        if (m > 10) {
            year = year - 1;
        }
        long K = (year % 100);
        long J = year / 100;
//        while(J > 100){
//        J = J / 100;
//        }
        //        Apply Zeller's Congruence Forumula

        double v = (q + Math.floor(2.6 * m - 0.2) + K + Math.floor(K / 4) + Math.floor(J / 4) - 2 * J) % 7;
        int l = (int) v;
        return l == 0;
    }
}
