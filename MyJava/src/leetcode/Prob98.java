package leetcode;

/**
 * Created by mdev on 7/23/17.
 */
public class Prob98 {

    boolean validation = true;
    Integer lastValue = null;

    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return validation;
    }

    public void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        if (lastValue != null && root.val <= lastValue) {
            validation = false;
            return;
        }
        lastValue = root.val;
        inorder(root.right);
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
