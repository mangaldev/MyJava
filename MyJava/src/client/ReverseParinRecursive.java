package client;

import tree.LinkedListNode;
import tree.NodeUtils;

public class ReverseParinRecursive {
    public ReverseParinRecursive() {
        super();
    }

    public static void main(String[] args) {
        int iNoNodes = 10;
        System.out.println("Total number of nodes : " + iNoNodes);
        LinkedListNode headNode = NodeUtils.createLinkedListOfNElements(iNoNodes);
        LinkedListNode ptrToSecondNode = headNode.getNext();
        NodeUtils.printLinkedList(headNode);
        reversePairInLinkedList(headNode);
        NodeUtils.printLinkedList(ptrToSecondNode);
        System.out.println(2.00 - 1.10);
    }

    private static void reversePairInLinkedList(LinkedListNode headNode) {
        LinkedListNode tempNode = headNode;
        if (tempNode == null || tempNode.getNext() == null)
            return;
        LinkedListNode a = tempNode;
        LinkedListNode b = tempNode.getNext();
        LinkedListNode bNext = b.getNext(); //3
        b.setNext(a);
        if (bNext != null && bNext.getNext() != null)
            a.setNext(bNext.getNext());
        else
            a.setNext(null);
        reversePairInLinkedList(bNext);
    }

}


