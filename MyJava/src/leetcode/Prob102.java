package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Prob102 {

    private TreeNode BLANK_NODE = new TreeNode(-1);

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(BLANK_NODE);
        queue.offer(root);
        int count = 1;
        List<Integer> innerList = null;
        while (!queue.isEmpty() && count!=0) {
            final TreeNode polled = queue.poll();
            if (polled == BLANK_NODE) {
                innerList = new ArrayList<>();
                result.add(innerList);
                queue.offer(BLANK_NODE);
                continue;
            }
            count--;
            innerList.add(polled.val);
            if (polled.left != null){
                queue.offer(polled.left);
                count++;
            }
            if (polled.right != null){
                queue.offer(polled.right);
                count++;
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
