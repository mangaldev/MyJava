package leetcode;

public class Prob111 {
    private static int minDist(TreeNode root, int depth) {
        if (root == null) return depth;
        if (root.left == null && root.right == null)
            return depth;
        if (root.left != null && root.right != null)
            return Math.min(minDist(root.left, depth + 1), minDist(root.right, depth + 1));
        else if (root.left != null) {
            return minDist(root.left, depth + 1);
        } else
            return minDist(root.right, depth + 1);
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return minDist(root, 1);
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
