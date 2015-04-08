package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mdev on 4/5/15.
 */
public class VertexCover {

    class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node createTree(int[] input) {
        Map<Integer, Node> map = new HashMap<>();
        Node root = null;
        for (int i = 0; i < input.length; i++) {
            if (input[i] != -1) {
                Node node = null;
                if (map.containsKey(input[i]))
                    node = map.get(input[i]);
                else {
                    node = new Node(input[i]);
                    map.put(input[i], node);
                }
                if (root == null)
                    root = node;
                int left = 2 * i + 1;
                if (left < input.length && input[left] != -1) {
                    node.left = new Node(input[left]);
                    map.put(input[left], node.left);
                }
                int right = 2 * i + 2;
                if (right < input.length && input[right] != -1) {
                    node.right = new Node(input[right]);
                    map.put(input[right], node.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        VertexCover problem = new VertexCover();
        Node root = problem.createTree(new int[]{10, 20, 30, 40, 50, -1, 60, -1, -1, 70, 80});

    }


}
