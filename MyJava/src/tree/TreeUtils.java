package tree;


import java.util.*;

public class TreeUtils {
    private TreeUtils() {
        super();
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

    public static void printBinaryTree(TreeNode root, int NUM_ELEMENTS) {
        int heightOfTree = (int)(Math.log(NUM_ELEMENTS) / Math.log(2));
        System.out.println(heightOfTree);
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int currentHeight = 1;
        int numberOfchildrenProcessed = 1;
        int maxSpaces = (int)Math.pow(2, heightOfTree + 1);
        while (!q.isEmpty()) {
            int tempHeight =
                (int)(Math.log(numberOfchildrenProcessed) / Math.log(2));

            if (tempHeight >= currentHeight) {
                currentHeight++;
                maxSpaces = (int)Math.pow(2, heightOfTree - tempHeight + 2);
                System.out.println("");
            }
            TreeNode node = q.remove();
            numberOfchildrenProcessed++;


            for (int s = maxSpaces; s > 0; s--)
                System.out.print("-");

            System.out.print(node.getData());
            if (node.getLeft() != null)
                q.add(node.getLeft());
            if (node.getRight() != null)
                q.add(node.getRight());
        }
    }

    public static void insertIntoBinaryTree(TreeNode root, int i) {
        if (i <= root.getData()) {
            if (root.getLeft() == null) {
                root.setLeftNode(new TreeNode(i));
                return;
            } else
                insertIntoBinaryTree(root.getLeft(), i);
        }

        else {
            if (root.getRight() == null) {
                root.setRightNode(new TreeNode(i));
                return;
            } else
                insertIntoBinaryTree(root.getRight(), i);
        }
    }

    static void printAllPathsFromRootToLeaf(TreeNode root, int NUM_ELEMENTS) {
        List<TreeNode> nodeList = new ArrayList<TreeNode>();
        printRootToLeaf(root, nodeList, 0);
    }

    private static void printRootToLeaf(TreeNode root, List<TreeNode> nodeList,
                                        int index) {
        nodeList.add(index, root);
        index++;

        if (root.getLeft() == null && root.getRight() == null) {
            printNodeList(nodeList, index);
            return;
        }
        if (root.getLeft() != null)
            printRootToLeaf(root.getLeft(), nodeList, index);
        if (root.getRight() != null)
            printRootToLeaf(root.getRight(), nodeList, index);
    }

    private static void printNodeList(List<TreeNode> nodeList, int index) {
        int i = 0;
        System.out.println("\n----------------------");
        while (i < index) {
            System.out.print(" " + nodeList.get(i).getData());
            i++;
        }
    }

    static boolean hasGivenSumFromRootToLeaf(TreeNode root, int sum) {

        if (root.getLeft() == null && root.getRight() == null) {
            if (sum - root.getData() != 0) {
                return false;
            } else
                return true;
        }
        boolean rightBranchResult = false;
        boolean leftBranchResult = false;
        if (root.getLeft() != null)
            leftBranchResult =
                    hasGivenSumFromRootToLeaf(root.getLeft(), sum - root.getData());

        if (root.getRight() != null)
            rightBranchResult =
                    hasGivenSumFromRootToLeaf(root.getRight(), sum -
                                              root.getData());
        return leftBranchResult || rightBranchResult;
    }

    static void printPreOrder(TreeNode root) {
        if (root == null)
            return;
        System.out.print(" " + root.getData() + " ");
        printPreOrder(root.getLeft());
        printPreOrder(root.getRight());
    }

    static void printInOrder(TreeNode root) {
        if (root == null)
            return;
        printInOrder(root.getLeft());
        System.out.print(" " + root.getData() + " ");
        printInOrder(root.getRight());
    }

    static TreeNode LCA(TreeNode root, int a, int b) {
        if (root == null)
            return null;
        if (root.getData() == a || root.getData() == b)
            return root;
        TreeNode root1 = LCA(root.getLeft(), a, b);
        TreeNode root2 = LCA(root.getRight(), a, b);
        if (root1 != null && root2 == null)
            return root1;
        else if (root1 == null && root2 != null)
            return root2;
        else if (root1 != null && root2 != null)
            return root;
        else
            return null;
    }

    static boolean printAllAncestors(TreeNode root, int givenRoot) {
        if (root == null) {
            return false;
        }
        if (root.getData() == givenRoot) {
            System.out.println(" " + root.getData() + " ");
            return true;
        }
        if (printAllAncestors(root.getLeft(), givenRoot) ||
            printAllAncestors(root.getRight(), givenRoot)) {
            System.out.println(" " + root.getData() + " ");
            return true;
        }
        return false;
    }
}
