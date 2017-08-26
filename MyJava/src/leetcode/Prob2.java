package leetcode;

/**
 * Created by mdev on 7/23/17.
 */
public class Prob2 {
    public static void main(String[] args) {
//        final ListNode list1 = createList(new int[]{9, 2, 3});
//        final ListNode list1 = createList(new int[]{9, 2, 3});
        final ListNode list1 = createList(new int[]{1});
        final ListNode list2 = createList(new int[]{9,9});
        final ListNode listNode = addTwoNumbers(list1, list2);
        System.out.println("listNode = " + listNode);
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode first = null;
        int rem = 0;
        while (l1 != null && l2 != null) {
            if (result == null) {
                result = new ListNode((l1.val + l2.val) % 10);
                rem = (l1.val + l2.val) / 10;
                first = result;
            } else {
                result.next = new ListNode((l1.val + l2.val + rem) % 10);
                rem = (l1.val + l2.val + rem) / 10;
                result = result.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l2 != null) {
            result.next = new ListNode((l2.val + rem) % 10);
            result = result.next;
            rem = (l2.val + rem) / 10;
            l2 = l2.next;
        }

        while (l1 != null) {
            result.next = new ListNode((l1.val + rem) % 10);
            result = result.next;
            rem = (l1.val + rem) / 10;
            l1 = l1.next;
        }
        if(rem > 0)
            result.next = new ListNode(rem);
        return first;
    }

    private static ListNode createList(int[] list) {
        ListNode current = null;
        ListNode first = null;
        for (int l : list) {
            if (first == null) {
                first = new ListNode(l);
                current = first;
            } else {
                current.next = new ListNode(l);
                current = current.next;
            }
        }
        return first;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }
}
