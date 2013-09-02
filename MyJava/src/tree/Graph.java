package tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Graph {
    
    private  int V;
    private List<List<Integer>> adjList;
    
    public Graph(int V) {
        adjList = new ArrayList<List<Integer>>(V);
        for (int i = 0; i < V; i++)
        {
            adjList.set(i, new ArrayList<Integer>());
        }

    }
    
    public void connect(int v, int w)
    {
        adjList.get(v).add(w);
        adjList.get(w).add(v);
    }


    public void setAdjList(List<List<Integer>> adjList)
    {
        this.adjList = adjList;
    }

    public List<List<Integer>> getAdjList()
    {
        return adjList;
    }

    public void setV(int V)
    {
        this.V = V;
    }

    public int getV()
    {
        return V;
    }
}
