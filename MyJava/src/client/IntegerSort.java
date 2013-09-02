package client;
/*************************************************************************
 *  Compilation:  javac IntegerSort.java
 *  Execution:    java IntegerSort < input.txt
 *
 *  Reads in sequence of integers between 0 and 99 and print them in
 *  sorted order.
 *
 *  % more input.txt
 *  98 2 3 1 0 0 0 3 98 98 2 2 2 0 0 0 2
 *
 *  % java IntegerSort < input.txt
 *  0 0 0 0 0 0 1 2 2 2 2 2 3 3 98 98 98
 *
 *************************************************************************/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;

public class IntegerSort {

    public static void main(String[] args) throws IOException {

        int MAX = 100; // integers are between 0 and MAX-1
        int[] freq = new int[MAX]; // freq[i] = number of occurrences of i
        BufferedReader myReader =
            new BufferedReader(new InputStreamReader(System.in));
        String strInputString = myReader.readLine();
        String[] strArray;
        strArray = strInputString.split(" ");
        int count = 0;
        // read in values and calculate frequencies
        while (count < strArray.length) {
            int i = Integer.parseInt(strArray[count++]);
            if (i < 0 || i >= MAX)
                throw new RuntimeException("Invalid integer");
            freq[i]++;
        }
        // print values in sorted order
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < freq[i]; j++) {
                System.out.print(" " + i + " ");
            }
        }
        System.out.println();
    }
}
