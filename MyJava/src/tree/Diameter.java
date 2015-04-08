package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mdev on 4/6/15.
 */
public class Diameter {

    public static void main(String[] args) {
        Node root = createBSTTree(new int[]{3,6,8,1,2});
        diameter(root);
        inorder(root);
        System.out.println(result);
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.println("root = " + root);
        inorder(root.right);
    }


    static class Node {
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

    public static Node createTree(int[] input) {
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

    public static int result = -1;

    public static Node createBSTTree(int[] input) {
        Node root = new Node(input[0]);
        for (int i = 1; i < input.length; i++) {
            Node newNode = new Node(input[i]);
            insertIntoBST(root, newNode);
        }
        return root;
    }

    private static  void insertIntoBST(Node root, Node newNode) {

        if (newNode.data <= root.data) {
            if(root.left == null)
                root.left = newNode;
            else
                insertIntoBST(root.left, newNode);
        }
        else {
            if(root.right == null)
                root.right = newNode;
            else
                insertIntoBST(root.right, newNode);
        }
    }

    public static int diameter(Node root) {
        if (root == null)
            return 0;
        int l = diameter(root.left);
        int r = diameter(root.right);

        int dia = l + r + 1;
        if (result == -1)
            result = dia;
        if (result < dia)
            result = dia;
        return Math.max(l, r) + 1;
    }


}
