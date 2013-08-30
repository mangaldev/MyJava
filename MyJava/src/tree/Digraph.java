package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Digraph {
    private Map<Character,List<Character>> adjMap;
    private int V; // Nuber of Vertices in graph
    public Digraph(int V) {
        adjMap = new HashMap<Character,List<Character>>();
        for (int i = 0; i < V; i++)
        {
            adjMap.put((char)(i+65), new ArrayList<Character>());
        }

    }


    public void setV(int V)
    {
        this.V = V;
    }

    public int getV()
    {
        return V;
    }
    public void connect(char v, char w)
    {
        System.out.println("Connecting V: "+ v +"to W : "+w);
        adjMap.get(v).add(w);
    }

    public void setAdjMap(Map<Character, List<Character>> adjMap)
    {
        this.adjMap = adjMap;
    }

    public Map<Character, List<Character>> getAdjMap()
    {
        return adjMap;
    }
}
