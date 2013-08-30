package tree;

public class TreeNode {

	private int Data;
	private TreeNode leftNode;
	private TreeNode rightNode;
	public TreeNode() {
		// TODO Auto-generated constructor stub
	}
	
	public TreeNode(int data) {
		// TODO Auto-generated constructor stub
		this.Data = data;
	}
	
	public TreeNode getLeft(){
		return leftNode;
	}

	public TreeNode getRight(){
		return rightNode;
	}
	public int getData() {
		return Data;
	}

	public void setData(int data) {
		Data = data;
	}

	public TreeNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(TreeNode leftNode) {
		this.leftNode = leftNode;
	}

	public TreeNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(TreeNode rightNode) {
		this.rightNode = rightNode;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("First Upload on GitHub");
	}

}
