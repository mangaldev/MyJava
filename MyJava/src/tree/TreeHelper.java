package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mdev on 3/30/15.
 */
public class TreeHelper {

    static class Node{
        Node left;
        Node right;
        int data;

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node createTree(int[] input){
        Map<Integer,Node> map = new HashMap<>();
        Node root = null;
        for (int i = 0; i < input.length; i++) {
            if(input[i]!=-1){
                Node node = null;
                if(map.containsKey(input[i]))
                    node = map.get(input[i]);
                else {
                    node = new Node(input[i]);
                    map.put(input[i],node);
                }
                if(root == null)
                    root = node;
                int left = 2*i + 1;
                if(left < input.length && input[left]!=-1) {
                    node.left = new Node(input[left]);
                    map.put(input[left],node.left);
                }
                int right = 2*i + 2;
                if(right < input.length && input[right]!=-1) {
                    node.right = new Node(input[right]);
                    map.put(input[right],node.right);
                }

            }
        }
        return root;
    }
}
