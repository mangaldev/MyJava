package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class AAA {

    static int input = 20;
    static int[] result= new int[input+1];
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);


		for(int i =1;i<=6;i++)
			result[i] = i;
        fillInput(input);
        Arrays.stream(result).forEach(num -> System.out.println(num));
    }

    public static int fillInput(int index){
        if(index <= 6)
            return result[index];
        int max = 0;
        int times=2;
        for (int breakpoint = index - 3;breakpoint >= 1;breakpoint--,times++)
        {
            int count  = Integer.max(times * fillInput(breakpoint),(times+1)*fillInput(breakpoint));
            if(count> max)
                max = count;
        }
        result[index]  = max;
        return max;
    }

}
/*
How to print maximum number of A’s using given four keys
This is a famous interview question asked in Google, Paytm and many other company interviews.

Below is the problem statement.

Imagine you have a special keyboard with the following keys:
Key 1:  Prints 'A' on screen
Key 2: (Ctrl-A): Select screen
Key 3: (Ctrl-C): Copy selection to buffer
Key 4: (Ctrl-V): Print buffer on screen appending it
                 after what has already been printed.

If you can only press the keyboard for N times (with the above four
keys), write a program to produce maximum numbers of A's. That is to
say, the input parameter is N (No. of keys that you can press), the
output is M (No. of As that you can produce).
Examples:

Input:  N = 3
Output: 3
We can at most get 3 A's on screen by pressing
following key sequence.
A, A, A

Input:  N = 7
Output: 9
We can at most get 9 A's on screen by pressing
following key sequence.
A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V

Input:  N = 11
Output: 27
We can at most get 27 A's on screen by pressing
following key sequence.
A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V, Ctrl A,
Ctrl C, Ctrl V, Ctrl V

 */