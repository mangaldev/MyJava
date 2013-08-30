package client;

import java.util.Scanner;
import java.util.StringTokenizer;

import tree.BFS;
import tree.Digraph;


public class Client
{
    public Client()
    {
        super();
    }
    
    public static void main(String[] args)
    {
        Scanner ir = new Scanner(System.in);
//        InputReader ir  = new InputReader();
        int V  = ir.nextInt();
        ir.nextLine();
        System.out.println(V);
        Digraph dg = new Digraph(V);
        for (int i = 0; i < V; i++)
        {
            System.out.println("For Vertex : "+ i);
            String inputString = ir.nextLine();
            System.out.println("input Strin gis "+ inputString);
            StringTokenizer oTokens = new StringTokenizer(inputString);
            while(oTokens.hasMoreTokens())
            {
                char c = oTokens.nextToken().charAt(0);
                System.out.println("Got Char "+ c);
                dg.connect((char)(i+65), c );
            }
        }

        BFS oBFS = new BFS(V);
        oBFS.performBFS('A', dg);

    }
    
    private static int nextInt(Scanner sc)
    {
        while(!sc.hasNextInt())
            System.out.println(sc.next());
        return sc.nextInt();
    }
}
