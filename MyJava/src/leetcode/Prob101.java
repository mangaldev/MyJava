package leetcode;


public class Prob101 {
    public static boolean isMirrored(TreeNode left, TreeNode right) {
        if (left == right) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && isMirrored(left.left, right.right) && isMirrored(left.right, right.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return root == null || isMirrored(root.left, root.right);
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
