package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Prob103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Deque<TreeNode> stack1 = new LinkedList<>();
        Deque<TreeNode> stack2 = new LinkedList<>();
        stack1.push(root);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()){
                List<Integer> innerList = new ArrayList<>();
                result.add(innerList);
                while (!stack1.isEmpty()) {
                    TreeNode popped = stack1.pop();
                    innerList.add(popped.val);
                    if (popped.left != null)
                        stack2.push(popped.left);
                    if (popped.right != null)
                        stack2.push(popped.right);
                }
            }
            if (!stack2.isEmpty()){
                List<Integer> innerList = new ArrayList<>();
                result.add(innerList);
                while (!stack2.isEmpty()) {
                    TreeNode popped = stack2.pop();
                    innerList.add(popped.val);
                    if (popped.right != null)
                        stack1.push(popped.right);
                    if (popped.left != null)
                        stack1.push(popped.left);
                }
            }
        }
        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
