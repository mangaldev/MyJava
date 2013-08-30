package client;

public class PrintHelically {
    public PrintHelically() {
        super();
    }


    public void test() {
        final int b = 60;
        final int a = 10;
        class abc {
            int ac = 20;

            void tesss() {
                System.out.println("In tessss" + a + b);
            }
        }

        abc oabc = new abc();
        oabc.tesss();
    }


    public PrintHelically(String str) {

    }

    public static void main(String[] args) {
        int n = 4;
        int[][] arr =
        { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15,
                                                               16 } };
        //
        //        { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int count = 0;
        int tb = 0;
        int bb = n - 1;
        int lb = 0;
        int rb = n - 1;
        int total;
        if (n % 2 == 0)
            total = n * n;
        else
            total = n * n - 1;
        while (count < total) {
            for (int i = lb; i < rb; i++) {
                count++;
                System.out.print(" " + arr[tb][i]);
            }
            for (int i = tb; i < bb; i++) {
                count++;
                System.out.print(" " + arr[i][rb]);
            }
            for (int i = rb; i > lb; i--) {
                count++;
                System.out.print(" " + arr[bb][i]);
            }
            for (int i = bb; i > tb; i--) {
                count++;
                System.out.print(" " + arr[i][lb]);
            }
            lb++;
            tb++;
            rb--;
            bb--;
        }
        if (n % 2 != 0)
            System.out.println(" " + arr[n / 2][n / 2]);
    }
}
