package tree;

public class PhoneBook {

	Node root = createNewNode('0',-1);
	class Node{
		Node[] nodeList;
		char data;
		int index;
		boolean isWord;
		public Node(char data, int index) {
			super();
			this.data = data;
			this.index = index;
			nodeList = new Node[26];
		}
	}


	public  Node createNewNode(char data, int index){
		return new Node(data,index);
	}

	public  void insertWordIntoDictionary(String word){
		if(word.length() == 0)
			return;
		Node temp = root;

		for(int index=0;index<word.length();index++){
			char c = word.charAt(index);
			int i = Character.toLowerCase(c) - 97;
//			System.out.println("Inseritng char : "+c+" at i : "+i +"of node "+temp.data);
			if(temp.nodeList[i] == null){
				temp.nodeList[i] = createNewNode(c, 0);
			}
			temp = temp.nodeList[i];
			if(index == word.length()-1)
				temp.isWord = true;
		}
		insertWordIntoDictionary(word.substring(1));
	}

	public void printTree(Node root,String result){
		if(root.isWord)
			System.out.println(result);
		for(int i=0;i<26;i++)
			if(root.nodeList[i] != null)
				printTree(root.nodeList[i],result + root.nodeList[i].data);
	}

	public static void main(String... args)
	{
		PhoneBook book = new PhoneBook();
		book.insertWordIntoDictionary("mangal");
		book.insertWordIntoDictionary("mental");
		book.insertWordIntoDictionary("richa");
		book.insertWordIntoDictionary("ting");
		book.printTree(book.root,"");
	}
}
