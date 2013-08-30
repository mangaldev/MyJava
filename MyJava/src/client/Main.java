package client;

import java.io.File;

import java.io.FileNotFoundException;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main
{
    private int noOfCases, n, k;
    private char[] color;
    private Map<Integer, Queue<Integer>> adjMap;
    private int wc = 0;
    private int bc = 1;
    static Scanner input;

    public static void main(String[] args) throws FileNotFoundException
    {
        Main m = new Main();
//         input = new Scanner(System.in);
                                input = new Scanner(new File("c://JDeveloper//abc.txt"));
        m.noOfCases = m.nextInt(input);
        while (m.noOfCases-- > 0)
        {
            
            m.takeInput(input);
            m.color[0] = 'b';
            m.processGraph(1);
            if (m.bc < m.wc)
            {
                m.bc = m.wc;

                for (int i = 1; i < m.color.length; i++)
                {
                    if (i != 1)
                        System.out.print(" ");
                    if (m.color[i] == 'w')
                        System.out.print(i + 1);
                }

            }
            else
            {
                for (int i = 1; i < m.color.length; i++)
                {
                    if (i != 1)
                        System.out.print(" ");
                    if (m.color[i] == 'b')
                        System.out.print(i + 1);
                }
            }
        }
        input.close();
    }

    private void takeInput(Scanner input)
    {
        adjMap = new HashMap<Integer, Queue<Integer>>();
        n = nextInt(input);
        color = new char[n+1];
        for (int i = 1; i <= n; i++)
        {
            adjMap.put(i, new LinkedList<Integer>());
            color[i] = 'r';
        }
        k = nextInt(input);
        for (int i = 0; i < k; i++)
        {
            int a = nextInt(input);
            int b = nextInt(input);
            adjMap.get(a).add(b);
            adjMap.get(b).add(a);
        }

    }

    private int nextInt(Scanner input)
    {
        while (!input.hasNextInt()){
            
            String str= input.next();
            System.out.println(str);
        }
        System.out.println("got the next int");
        return input.nextInt();
    }

    private void processGraph(int source)
    {
        List<Integer> adjList = (List<Integer>)adjMap.get(source);
        for (int s : adjList)
        {
            if (color[s] == 'r')
            {
                if (color[source] == 'b')
                {
                    color[s] = 'w';
                    wc++;
                }
                else
                {
                    color[s] = 'b';
                    bc++;
                }
                processGraph(s);
            }
        }
    }
}
