package client;

public class EightQueen {

    private static int[] arr = new int[10];
    static int count = 0;

    public static void main(String[] args) {
        _queens(1);
        System.out.println("count = " + count);
    }

    private static void _queens(int currentIndex) {
        if (currentIndex == 9) {
            count++;
            print_solution();
            System.exit(0);
        }
        for (int num = 1; num <= 8; num++) {
            if (isValidNumber(currentIndex, num)) {
                arr[currentIndex] = num;
                _queens(currentIndex + 1);
            }
        }
    }

    private static boolean isValidNumber(int currentIndex, int num) {
        for (int j = 1; j < currentIndex; j++) {
            if (arr[j] == num)
                return false;
            if (Math.abs(arr[j] - num) == Math.abs(j - currentIndex))
                return false;
        }
        return true;
    }

    private static void print_solution() {
        int i;
        for (i = 1; i <= 8; i++) System.out.printf("\n%d.  [%d]", i, arr[i]);
    }




}
