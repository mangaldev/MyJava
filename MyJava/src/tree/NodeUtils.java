package tree;


public class NodeUtils {
    private NodeUtils() {
        super();
    }

    public static void printLinkedList(LinkedListNode headNode) {
        LinkedListNode temp = headNode;
        System.out.println("");
        while (temp != null) {
            System.out.print(temp.getData() + " --> ");
            temp = temp.getNext();
        }
    }

    public static LinkedListNode createLinkedListOfNElements(int iNoNodes) {
        LinkedListNode headNode = new LinkedListNode(1, null);
        LinkedListNode lastNode = headNode;
        for (int i = 2; i <= iNoNodes; i++) {
            LinkedListNode newNode = new LinkedListNode(i, null);
            lastNode.setNext(newNode);
            lastNode = newNode;
        }
        return headNode;
    }
}
