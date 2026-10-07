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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode curr = head, last = null, secHead = null, secLast = null;
        head = null;
        
        while (curr != null) {
            ListNode next = curr.next;
            if (curr.val < x) {
                if (head == null) {
                    head = curr;
                    last = curr;
                } else {
                    last.next = curr;
                    last = last.next;
                }
                last.next = null;
            } else {
                if (secHead == null) {
                    secHead = curr;
                    secLast = curr;
                } else {
                    secLast.next = curr;
                    secLast = secLast.next;
                }
                secLast.next = null;
            }

            curr = next;
        }

        if(last != null) last.next = secHead;
        if (head == null) head = secHead;

        return head;
    }
}