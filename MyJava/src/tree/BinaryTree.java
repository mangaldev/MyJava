package tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BinaryTree {
    public static final int NUM_ELEMENTS = 10;

    public BinaryTree() {
        super();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeUtils.insertIntoBinaryTree(root, 2);
        TreeUtils.insertIntoBinaryTree(root, 6);
        TreeUtils.insertIntoBinaryTree(root, 5);
        TreeUtils.insertIntoBinaryTree(root, 7);
        TreeUtils.insertIntoBinaryTree(root, 1);
        TreeUtils.insertIntoBinaryTree(root, 3);
        //        System.out.println("Printing Pre Order");
        //        TreeUtils.printPreOrder(root);
        //        System.out.println("\nPrinting In Order");
        //        TreeUtils.printInOrder(root);
        //        System.out.println("\nPrinting all the paths ");
        //        TreeUtils.printAllPathsFromRootToLeaf(root, NUM_ELEMENTS);
        //        System.out.println(TreeUtils.hasGivenSumFromRootToLeaf(root, 17));
        //        Node resultNode = TreeUtils.LCA(root, 3, 5);
        //        System.out.println(resultNode.getData());
        TreeUtils.printAllAncestors(root, 3);
    }

}


