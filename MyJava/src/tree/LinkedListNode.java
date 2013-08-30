package tree;



public  class LinkedListNode {
	private int data; // value
	private LinkedListNode next;

	LinkedListNode(int n) {
		this.data = n;
	}
	
	LinkedListNode(int n,LinkedListNode next) {
		this.data = n;
		this.next = next;
	}


	public void setData(int n) {
		this.data = n;
	}

	public int getData() {
		return data;
	}

	public LinkedListNode getNext() {
		return next;
	}


	public void setNext(LinkedListNode next) {
		this.next = next;
	}
}
