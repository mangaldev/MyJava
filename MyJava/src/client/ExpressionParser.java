package client;

public class ExpressionParser {
	static class Node{

		char x;
		Node left;
		Node right;
		Node(char x){
			this.x = x;
		}
	}

	public static void main(String[] args){
		Node root = new Node('*');
		Node add = new Node('+');
		Node c = new Node('c');
		root.left = add;
		root.right = c;

		Node a = new Node('a');
		Node b = new Node('b');

		add.left = a;
		add.right = b;
				System.out.println(printExpression(root));
	}

	public static String printExpression(Node root)
	{
		if(root.left == null && root.right == null)
			return root.x+"";
		String a = printExpression(root.left);
		String b = printExpression(root.right);
		return "(" + a+ root.x +b+ ")";
	}


}
