package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mdev on 4/6/15.
 */
public class ThreadedBinaryTree {

    public static void main(String[] args) {
        Node root = createTree(new int[]{10,5,15,3,-1,-1,-1,2,4});
//        inorder(root);
        inOrderWithoutRecursionStack(root);
    }

    public static void inOrderWithoutRecursionStack(Node root){
        while(true){
            if(root == null)
                break;
            Node rightMostNode = null;
            if(root.left != null) {
                rightMostNode = root.left;
            }
            while(rightMostNode!=null && rightMostNode.right!=null){
                if(rightMostNode.right == root){
                    System.out.print(" " + root.data);
                    root = root.right;
                    rightMostNode.right = null;
                    break;
                }
                rightMostNode = rightMostNode.right;
            }
            if(rightMostNode != null)
                rightMostNode.right = root;

            if(root.left!=null) {
                root = root.left;
            }
            else if(root.right != null){
                System.out.print(" "+root.data);
                root = root.right;
            }
        }
    }

    public static void inorder(Node root){
        if(root == null)
            return;
        inorder(root.left);
            System.out.print(" "+root.data);
        inorder(root.right);
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
