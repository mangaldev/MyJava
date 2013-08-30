package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class MajorityElement {
    public MajorityElement() {
        super();
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Enter the number of elements");
        MyReader reader = new MyReader();
        int iNum = reader.getNextInt();
        int[] arrNum = new int[iNum];
        for (int i = 0; i < iNum; i++) {
            arrNum[i] = reader.getNextInt();
        }
        System.out.println("Answer is ---> " + getMajorityElement(arrNum));
    }


    public static int getMajorityElement(int[] arrNum) {
        int ans = -1;
        int count = 0;
        for (int i = 0; i < arrNum.length; i++) {
            if (ans == arrNum[i]) {
                count++;
            } else {
                if (count == 0)
                    ans = arrNum[i];
                else
                    count--;
            }
        }
        return ans;
    }

    static class MyReader {
        private String input;
        private StringTokenizer strTokens;
        private BufferedReader myReader;

        MyReader() {
            myReader = new BufferedReader(new InputStreamReader(System.in));

        }

        public String getToken() throws IOException {
            if (strTokens == null || !strTokens.hasMoreTokens())
                strTokens = new StringTokenizer(myReader.readLine());
            return strTokens.nextToken();
        }

        public int getNextInt() throws IOException {
            return Integer.parseInt(getToken());
        }
    }
}
