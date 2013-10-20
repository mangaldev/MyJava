package client;

public class ReverseLinkedList {
	static class Node{
		int data;
		Node next = null;
		Node(int data){
			this.data = data;
		}
	}
	static Node head = null;
	public static void main(String... args){
		Node root = new Node(1);
		root.next = new Node(2);
		root.next.next = new Node(3);
		root.next.next.next = new Node(4);
		root.next.next.next.next = new Node(5);
		root.next.next.next.next.next = new Node(6);
		head = root;
		print(root);
		reverse(root);
		print(head);
	}
	
	public static Node reverse(Node root){
		if(root.next == null){
			head = root;
			return root;
		}
		Node nextNode = reverse(root.next);
		nextNode.next = root;
		root.next = null;
		return root;
	}

	public static void print(Node root){
		System.out.println();
		while(root!=null){
			System.out.print("->"+root.data);
			root = root.next;
		}
		System.out.println();
	}
}
