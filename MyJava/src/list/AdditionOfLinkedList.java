package list;

/**
 * Created by mdev on 4/12/15.
 */
public class AdditionOfLinkedList {

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
        Node(){}
    }

    static  int carry = 0;
    static Node resultHead = null;
    static Node head1 = null;
    static Node head2 = null;

    public static void main(String[] args) {
        head1 = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        head1.next = n1;
        n1.next = n2;

        head2 = new Node(2);
        head2.next = new Node(4);
        makeEqualBothList(head1,head2);
        sum(head1,head2,null);
        print(resultHead);
    }

    public static void makeEqualBothList(Node head1,Node head2){
        int count1= 0;
        int count2= 0;
        Node temp1 = head1;
        Node temp2 = head2;
        while(temp1 != null){
            count1++;
            temp1 = temp1.next;
        }
        while(temp2 != null){
            count2++;
            temp2 = temp2.next;
        }
        int diff = Math.abs(count1 - count2);
        Node newRoot= null;
        Node lastNode = null;
        while(diff-- !=0 ){
            Node newNode = new Node(0);
            if(newRoot == null){
                newRoot = newNode;
            }
            if(lastNode != null)
                lastNode.next = newNode;
            lastNode = newNode;
        }
        if(count2>count1) {
            lastNode.next = head1;
            AdditionOfLinkedList.head1 = newRoot;
        }
        else if(count1>count2){
            lastNode.next = head2;
            AdditionOfLinkedList.head2 = newRoot;
        }

    }

    public static void print(Node resultHead){
        if(resultHead == null)
            return;
        System.out.print(resultHead.data + " ");
        print(resultHead.next);
    }

    public static int sum(Node head1, Node head2,Node prevNode){
        if(head1 == null){
            return 0;
        }
        Node root = new Node();
        if(prevNode != null){
            prevNode.next = root;
        }
        if(resultHead == null){
            resultHead = root;
        }
        int carry = sum(head1.next, head2.next,root);
        int sum = head1.data + head2.data + carry;
        root.data = sum%10;
        return sum/10;
    }
}
