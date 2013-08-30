package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class FloorAndCeiling {
    public FloorAndCeiling() {
        super();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader myReader =
            new BufferedReader(new InputStreamReader(System.in));
        String oInput = myReader.readLine();
        String[] oInputArray = oInput.split(" ");
        int count = 0;
        int[] iInput = new int[oInputArray.length];
        while (count < oInputArray.length) {
            iInput[count] = Integer.parseInt(oInputArray[count++]);
        }
        int iNumToFind = Integer.parseInt(myReader.readLine());
        int iResult = BinarySearch(iInput, iNumToFind, 0, iInput.length - 1);
        System.out.println(iResult);
        System.exit(1);
    }

    private static int BinarySearch(int[] oInputArray, int iNumToFind,
                                    int iStart, int iEnd) {
        if (iStart == iEnd)
            return oInputArray[iStart];
        if (iEnd - iStart == 1)
            return oInputArray[iEnd];
        int iMedian = (iEnd + iStart) / 2;

        if (iNumToFind < oInputArray[iMedian]) {
            return BinarySearch(oInputArray, iNumToFind, iStart, iMedian);
        } else if (iNumToFind > oInputArray[iMedian]) {
            return BinarySearch(oInputArray, iNumToFind, iMedian, iEnd);
        } else
            return oInputArray[iMedian];
    }
}
