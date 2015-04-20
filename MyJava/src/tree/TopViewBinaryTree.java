package tree;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by mdev on 4/20/15.
 */
public class TopViewBinaryTree {

    public static void main(String[] args) {
//        Node root = createTree(new int[]{1,2,3,-1,4,-1,-1,-1,-1,-1,5});
        Node root = createTree(new int[]{20,8,22,5,3,-1,25,-1,-1,10,14});
        printTopView(root,0);
        System.out.println();
        for(Integer key: map.keySet()){
            System.out.printf(" %d ", map.get(key));
        }
        System.out.println();
        printBottomView(root,0);
        System.out.println();
        for(Integer key: map.keySet()){
            System.out.printf(" %d ", map.get(key));
        }
        System.out.println();
    }

    static Map<Integer,Integer> map = new TreeMap<>();


//    instead of going pre or post order always go for Level Order Traversal
    public static void printTopView(Node root, int index){
        if(root == null)
            return ;
        printTopView(root.left, index - 1);
        printTopView(root.right, index + 1);
        map.put(index,root.data);
    }

    public static void printBottomView(Node root, int index){
        if(root == null)
            return ;
        map.put(index,root.data);
        printBottomView(root.left, index - 1);
        printBottomView(root.right, index + 1);

    }

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
