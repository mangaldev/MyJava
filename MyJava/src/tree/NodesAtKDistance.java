package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mdev on 3/27/15.
 */
public class NodesAtKDistance {
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

    public static void main(String[] args) {
        int[] nodes = {20,8,22,4,12,-1,-1,-1,-1,10,14};
        NodesAtKDistance prob = new NodesAtKDistance();
        Node root = prob.createTree(nodes);
//        prob.inorder(root);
        prob.printNodes(root,22,4);
    }

    public Node createTree(int[] input){
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
    
    public void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.println("root = " + root);
        inorder(root.right);
    }

    public int printNodes(Node root,int target, int k){
        if(root == null)
            return -1;

        if(root.data == target){
            printDesc(root, k, 0);
            return k-1;
        }


        int k1 = printNodes(root.left,target,k);
        int k2 = printNodes(root.right,target,k);

        if(k1 ==0 || k2 == 0){
            printDesc(root, 0 , 0);
        }
        if(k1>0) {
            printDesc(root.right, k1 -1, 0);
            return k1 - 1;
        }
        if(k2>0) {
            printDesc(root.left, k2 -1, 0);
            return k2-1;
        }
        return  -1;
    }

    private void printDesc(Node root, int target,int current){

        if(root == null)
            return;
        if(current == target){
            System.out.println("root = " + root);
        }
        if(current > target)
            return;

        printDesc(root.left,target,current+1);
        printDesc(root.right,target,current+1);
    }
}
