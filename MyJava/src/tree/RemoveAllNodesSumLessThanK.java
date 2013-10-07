package tree;

public class RemoveAllNodesSumLessThanK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		createTree(root);
		printInOrder(root);
		remove(root,0,45);
		System.out.println();
		printInOrder(root);
	}
	
	private static int remove(Node root,int sum,int k){
		if(root == null)
			return sum;
		int m = Math.max(remove(root.left,sum+root.data,k), remove(root.right,sum+root.data,k));
		if(m<k)
			root.data = -1;
		return m;
		
	}
	
	private static void createTree(Node root){
		root.left = newNode(2);
		root.right = newNode(3);
		root.left.left = newNode(4);
		root.left.right = newNode(5);
		root.right.left = newNode(6);
		root.right.right = newNode(7);
		root.left.left.left = newNode(8);
		root.left.left.right = newNode(9);
		root.left.right.left = newNode(12);
		root.right.right.left = newNode(10);
		root.right.right.left.right = newNode(11);
		root.left.left.right.left = newNode(13);
		root.left.left.right.right = newNode(14);
		root.left.left.right.right.left = newNode(15);
	}
	private static Node newNode(int i) {
		return new Node(i);

	}
	static class Node{
		private int data;
		private Node left;
		private Node right;
		public Node(int data) {
			super();
			this.data = data;
		}
	}
	
	   static void printInOrder(Node root) {
	        if (root == null)
	            return;
	        System.out.print(" " + root.data + " ");
	        printInOrder(root.left);
	        printInOrder(root.right);
	    }

}
