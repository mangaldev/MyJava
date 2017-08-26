package leetcode;

public class Prob86 {
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

    public static void main(String[] args) {
        final ListNode list2 = createList(new int[]{2, 1});
        final ListNode partition = partition(list2, 2);
        print(partition);
    }

    private static void print(ListNode list) {
        while (list != null) {
            System.out.print(" -> " + list.val);
            list = list.next;
        }
    }

    private static ListNode partition(ListNode head, int x) {
        ListNode firstHead = null;
        ListNode firstLast = null;
        ListNode secondHead = null;
        ListNode secondLast = null;
        ListNode current = head;
        while (current != null) {
            if (current.val < x) {
                if (firstHead == null)
                    firstHead = current;
                else
                    firstLast.next = current;
                firstLast = current;
            } else {
                if (secondHead == null)
                    secondHead = current;
                else
                    secondLast.next = current;
                secondLast = current;
            }
            ListNode prev = current;
            current = current.next;
            prev.next = null;
        }
        if (firstLast != null) {
            firstLast.next = secondHead;
            return firstHead;
        } else {
            return secondHead;
        }

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }
}
