package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Prob113 {
    List<List<TreeNode>> paths = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return result;
        }
        final ArrayList<TreeNode> list = new ArrayList<>();

        list.add(root);
        pathFinder(root.val, list, root, sum);
        for (List<TreeNode> path : paths) {
            List<Integer> inner = new ArrayList<>();
            for (TreeNode treeNode : path) {
                inner.add(treeNode.val);
            }
            result.add(inner);
        }
        return result;
    }

    public void pathFinder(int sum, List<TreeNode> list, TreeNode root, int givenSum) {
        if (isLeaf(root) && sum == givenSum) {
            paths.add(new ArrayList<>(list));
        }
        if (root.left != null) {
            list.add(root.left);
            pathFinder(sum + root.left.val, list, root.left, givenSum);
            list.remove(root.left);
        }
        if (root.right != null) {
            list.add(root.right);
            pathFinder(sum + root.right.val, list, root.right, givenSum);
            list.remove(root.right);
        }
    }

    public boolean isLeaf(TreeNode root) {
        if (root.left == null && root.right == null)
            return true;
        return false;
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
