package tree;

import java.util.Iterator;

public class DepthFirstSearch {
    public DepthFirstSearch(int V) {
        super();
        init(V);
    }

    boolean[] marked;

    public void dfs(Graph G, int s) {
        marked[s] = true;
        for (int i = 0; i < G.getAdjList().get(s).size(); i++) {
            Iterator<Integer> it = G.getAdjList().get(i).iterator();
            while (it.hasNext()) {
                int v = it.next();
                if (!marked[v]) {
                    dfs(G, v);
                }
            }
        }
    }

    private void init(int V) {
        for (int i = 0; i < V; i++) {
            marked[i] = false;
        }

    }
}
