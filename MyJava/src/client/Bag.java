package client;

import java.util.Iterator;

public class Bag<T> implements Iterable<T>,Comparable<T>{
	private Node rootNode;
	private Node tailNode;
	private int count = 0;
	public Bag() {

	}

	public void insert(T item){
		if(rootNode == null){
			rootNode = new Node(item);
			tailNode = rootNode;
		}
		else{
			Node node = new Node(item);
			tailNode.next = node;
			tailNode = node;
		}
		count++;
	}
	
	public void remove(T item){
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}
	
	private class ListIterator<T> implements Iterator<T>{

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class Node{
		public Node(T item) {
			data = item;
		}
		private T data;
		private Node next;
	}

}
