package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mdev on 4/14/15.
 * <code class=" language-java">A tree is given in which each edge is having some weight associated with it and you are given a number K<span class="token punctuation">.</span>

 So starting from root in K<span class="token operator">-</span>steps how much maximum weight you can collect<span class="token punctuation">.</span> You can traverse in any direction either from parent to child or child to parent<span class="token punctuation">.</span> You can visit a node multiple times<span class="token punctuation">.</span>

 Eg<span class="token operator">:</span>
 O
 <span class="token number"> 5</span><span class="token operator">/</span>   \<span class="token number"> 6</span>
 O	O
 <span class="token number"> 24</span><span class="token operator">/</span> <span class="token number"> 1</span> \     <span class="token number">\11</span>

 For K<span class="token number">=1</span><span class="token punctuation">,</span> ans<span class="token number">=6</span>
 For K<span class="token number">=2</span><span class="token punctuation">,</span> ans<span class="token number">=29</span> etc<span class="token punctuation">.</span><span class="token punctuation">.</span></code>
 */
public class MaximumWeightInTreeWithGivenSteps {

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


    public static void main(String[] args) {
//        int[] nodes = {0,5,6,24,-1,1,11};
//        Node root = createTree(nodes);
//
//        resultMax = getMax(root, 2, 0);
//        System.out.println(resultMax);
        int count=0;
        for (int i = 1234; i < 2014; i++) {
            for (int j = 0; j < 4; j++) {
                int a = i%10;
                int b = i%100;
                int c = i%1000;
                int d = i%10000;
                if(a ==b && b==c && c==d){
                    System.out.println(i);
                    count++;
                }
            }

        }
        System.out.println(count);
    }
    static int resultMax = 0;

    public static int getMax(Node root, int k, int sum){
        if(root == null){
            return sum;
        }
        if(k ==0 ){
            return sum + root.data;
        }
        int max = k * root.data + sum;
        if(k%2 == 0){
            int newmax = k/2 * root.data + sum;
            if(newmax > max)
                max = newmax;
        }
        else{

        }

        for (int i = 1; i <= k ; i = i + 2) {
            int lmax = getMax(root.left,k-i,sum + root.data*((k-i)/2));
            if(lmax > max){
                max = lmax;
            }
            int rmax = getMax(root.right,k-i,sum + root.data*((k-i)/2));
            if(rmax > max){
                max = rmax;
            }
        }
        return max;
    }
}
