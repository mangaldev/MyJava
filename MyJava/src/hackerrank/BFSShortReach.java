package hackerrank;

import java.util.*;

public class BFSShortReach {
    static Map<Integer, List<Integer>> adjList = new HashMap<>();
    static Map<Integer, Integer> result = new HashMap<>();
    static Deque<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casese = sc.nextInt();
        while (casese-- != 0) {
            int nodes = sc.nextInt();
            int edges = sc.nextInt();
            adjList = new HashMap<>();
            result = new HashMap<>();
            queue.clear();
            while (edges-- != 0) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                if (!adjList.containsKey(x))
                    adjList.put(x, new ArrayList<>());
                if (!adjList.containsKey(y))
                    adjList.put(y, new ArrayList<>());
                adjList.get(x).add(y);
                adjList.get(y).add(x);
            }
            final int givenNode = sc.nextInt();
            result.put(givenNode, 0);
            queue.addLast(givenNode);
            while (!queue.isEmpty()) {
                int somenode = queue.removeFirst();
                if (adjList.containsKey(somenode)) {
                    for (Integer neighbour : adjList.get(somenode)) {
                        if (!result.containsKey(neighbour)) {
                            result.put(neighbour, result.get(somenode) + 1);
                            queue.addLast(neighbour);
                        }
                    }
                }
            }
            for (int i = 1; i <= nodes; i++) {
                if (i == givenNode) continue;
                if (result.containsKey(i))
                    System.out.print(result.get(i) * 6 + " ");
                else
                    System.out.print("-1 ");
            }
            System.out.println();
        }
    }
}