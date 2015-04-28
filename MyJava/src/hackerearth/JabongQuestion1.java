package hackerearth;

/**
 * Created by mdev on 4/26/15.
 */
public class JabongQuestion1 {

    static class Node{
        Node left;
        Node right;
        char data;
        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }

        public Node(char data) {
            this.data = data;
        }
    }
    public static void main(String[] args) {
        String[] input = {"G","CJ","BDIL","AK"};
//        String[] input = {"J","DN","CEK","L"};
        Node root = new Node(input[0].charAt(0));
        createTree(null,input,0, Integer.MIN_VALUE,Integer.MAX_VALUE);
        printPreOrder(root);
    }

    private static void printPreOrder(Node oTreeRoot) {
        if (oTreeRoot == null)
            return;
        System.out.printf(" %c ", oTreeRoot.data);
        printPreOrder(oTreeRoot.left);
        printPreOrder(oTreeRoot.right);
    }

    public static void createTree(Node root, String[] input, int level, int min, int max){
        if(level>=input.length)
            return ;
        String str = input[level];
        for (int i = 0; i < str.length(); i++) {
            char data = str.charAt(i);
            if(data > min && data < root.data){
                root.left = new Node(data);
                createTree(root.left,input, level+1,min,root.data);
            }
            else if(data < max && data > root.data){
                root.right = new Node(data);
                createTree(root.right,input, level+1,root.data,max);
            }
        }
    }

    }
