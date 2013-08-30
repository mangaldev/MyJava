package client;

public class TowerOfHanoi {
    public TowerOfHanoi() {
        super();
    }

    public static void main(String[] args) {
        int iNoOfDisks = 5;
        System.out.println("Number of disks are " + iNoOfDisks);
        char sourceRod = 'A';
        char auxRod = 'B';
        char destRod = 'C';
        towerOfhanoi(iNoOfDisks, sourceRod, auxRod, destRod);
    }

    private static void towerOfhanoi(int n, char sourceRod, char destRod,
                                     char auxRod) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + sourceRod + " to " +
                               destRod);
            return;
        }

        towerOfhanoi(n - 1, sourceRod, auxRod, destRod);
        System.out.println("Move disk " + n + " from " + sourceRod + " to " +
                           destRod);
        towerOfhanoi(n - 1, auxRod, destRod, sourceRod);

    }
}
