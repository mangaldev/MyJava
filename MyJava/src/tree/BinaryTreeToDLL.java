package tree;

/**
 * Created by mdev on 3/31/15.
 */
public class BinaryTreeToDLL {
    static int[] input = {10,12,15,25,30,36,-1};
    static TreeHelper.Node root = TreeHelper.createTree(input);
private int  a  =5;
    public static void main(String[] args) {
        int a = new BinaryTreeToDLL().a;
        System.out.println("a = " + a);
    }

//    TreeHelper.Node prev = x;
    public static TreeHelper.Node createDLL(TreeHelper.Node root){
        if(root == null)
            return null;

        createDLL(root.left);

        root.right = createDLL(root.right);
        return root;
    }
}
