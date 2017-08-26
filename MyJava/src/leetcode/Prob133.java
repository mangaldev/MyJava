package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mdev on 7/23/17.
 */
public class Prob133 {

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }

    }

    public class Solution {
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
            UndirectedGraphNode clonedNode;
            if (node == null)
                return null;
            if (map.containsKey(node.label)) {
                return map.get(node.label);
            }
            clonedNode = new UndirectedGraphNode(node.label);
            map.put(node.label, clonedNode);
            for (UndirectedGraphNode neighbor : node.neighbors) {
                clonedNode.neighbors.add(cloneGraph(neighbor));
            }
            return clonedNode;
        }
    }
}
