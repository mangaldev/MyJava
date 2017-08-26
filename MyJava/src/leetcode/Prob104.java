package leetcode;

public class Prob104 {
    private static int _maxDepth(Prob102.TreeNode root, int depth) {
        if (root == null) {
            return depth - 1;
        }
        return Math.max(_maxDepth(root.left, depth + 1), _maxDepth(root.right, depth + 1));
    }

    public int maxDepth(Prob102.TreeNode root) {
        return _maxDepth(root, 1);
    }
}
