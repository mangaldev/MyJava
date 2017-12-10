package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Prob662 {
    Map<Integer, int[]> levelMinMax = new HashMap<>();


    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        recursive(root, 0, 0);
        int max = Integer.MIN_VALUE;
        for (Integer key : levelMinMax.keySet()) {
            if (levelMinMax.get(key)[1] - levelMinMax.get(key)[0] > max) {
                max = levelMinMax.get(key)[1] - levelMinMax.get(key)[0];
            }
        }
        return max + 1;
    }

    public void recursive(TreeNode node, int index, int level) {
        if (node == null) {
            return;
        }
        int[] minMax = new int[2];
        if (levelMinMax.containsKey(level)) {
            minMax = levelMinMax.get(level);
            if (minMax[0] > index)
                minMax[0] = index;
            if (minMax[1] < index)
                minMax[1] = index;
        } else {
            minMax[0] = index;
            minMax[1] = index;
            levelMinMax.put(level, minMax);
        }

        if (node.left != null) {
            recursive(node.left, 2 * index, level + 1);
        }
        if (node.right != null) {
            recursive(node.right, 2 * index + 1, level + 1);
        }
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
