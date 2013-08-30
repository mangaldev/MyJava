package tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class BFS
{

    private boolean[] marked;
    private int[] fromVertex;
    private Queue<Character> bfsQueue;

    public BFS(int V)
    {
        marked = new boolean[V];
        fromVertex = new int[V];
        bfsQueue = new LinkedList<Character>();
    }

    public void performBFS(char source, Digraph dg)
    {
        bfsQueue.add(source);
        marked[source - 65] = true;
        while (!bfsQueue.isEmpty())
        {
            source = bfsQueue.poll();
            System.out.println("Visiting Vertex " + source);
            Iterator<Character> iter = dg.getAdjMap().get(source).iterator();
            while (iter.hasNext())
            {
                char nextNeighbor = iter.next();
                if (!marked[nextNeighbor - 65])
                {
                    bfsQueue.add(nextNeighbor);
                    marked[nextNeighbor - 65] = true;
                }
            }
        }
    }
}
