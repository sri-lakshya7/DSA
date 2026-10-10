/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode head1 = null, rHead = null, head2 = null;
        ListNode curr = head;
        ListNode last1 = null, rLast = null;
        int idx = 1;

        while (idx < left) {
            if (head1 == null) {
                head1 = curr;
                last1 = head1;
            } else {
                last1.next = curr;
                last1 = last1.next;
            }

            curr = curr.next;
            last1.next = null;
            idx++;
        }

        while (idx <= right) {
            if (rHead == null) {
                rHead = curr;
                rLast = rHead;
            } else {
                rLast.next = curr;
                rLast = rLast.next;
            }

            curr = curr.next;
            rLast.next = null;
            idx++;
        }

        head2 = curr;
        curr = rHead;
        ListNode prev = null, header = rHead;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        rHead = prev;

        if (rHead == null) rHead = head2;
        else header.next = head2;

        if (head1 == null) head1 = rHead;
        else last1.next = rHead;

        return head1;
    }
}