package leetcode;

public class Prob109 {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode middleNode = findMiddleNode(head);
        if (middleNode == null)
            return null;
        TreeNode root = new TreeNode(middleNode.val);
        root.right = sortedListToBST(middleNode.next);
        ListNode temp = middleNode.next;
        middleNode.next = null;
        ListNode prevNode = getPrevNode(head, middleNode);
        if (prevNode != null) {
            prevNode.next = null;
            root.left = sortedListToBST(head);
        }
        return root;
    }

    public ListNode getPrevNode(ListNode head, ListNode desired) {
        while (head != null && head.next != desired) {
            head = head.next;
        }
        return head;
    }

    public ListNode findMiddleNode(ListNode head) {
        if (head == null) return head;
        if (head.next == null) return head;
        ListNode ptr1 = head;
        ListNode ptr2 = head;
        while (true) {
            if (ptr2.next == null || ptr2.next.next == null) break;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next.next;
        }
        return ptr1;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
