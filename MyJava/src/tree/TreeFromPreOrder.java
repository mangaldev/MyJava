package tree;

import java.util.Arrays;

/**
 * Created by mdev on 4/20/15.
 */
public class TreeFromPreOrder {


    static class Node {
        Node left;
        Node right;
        int data;

        @Override
        public String toString() {
            return data+" ";
        }

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{10, 5, 4, 8, 15, 12, 20};
        Node root = createTree(input, 0, input.length - 1);
        inorder(root);
    }
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.println(" " + root);
        inorder(root.right);
    }


    private static Node createTree(int[] input, int start, int end) {
        Node root = null;
        int data;
        if (start >= input.length || start<0 || end<0 || end >= input.length || start>end)
            return null;
        if(end==start){
            return new Node(input[start]);
        }
        data = input[start];
        root = new Node(data);
        int index = justBiggerNum(input, start, end, data);
        if(index!=-1)
        {
            root.left = createTree(input, start + 1, index - 1);
            root.right = createTree(input, index, end);
        }

        return root;
    }

    private static int justBiggerNum(int[] arr, int start, int end, int k) {


        if(start<0 || start>end || end<0 || end>=arr.length || start>=arr.length)
            return -1;
        int mid = start + (end - start) / 2;
        int index;
        if (arr[mid] < k) {
            if (arr[mid + 1] >= k) {
                index = mid + 1;
            } else {
                index = justBiggerNum(arr, mid + 1, end, k);
            }
        } else {
            if (arr[mid - 1] < k) {
                index = mid;
            } else {
                index = justBiggerNum(arr, start, mid - 1, k);
            }
        }
        return index;
    }
}
