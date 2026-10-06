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
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;
        Deque<Integer> stack = new ArrayDeque<>();

        ListNode curr = head;
        int n = 0;

        while (curr != null) {
            curr = curr.next;
            n++;
        }
        curr = head;

        for (int i = 0; i < n/2; i++) {
            stack.push(curr.val);
            curr = curr.next;
        }
        if (n % 2 == 1) curr = curr.next;

        while(!stack.isEmpty()) {
            if (stack.pop() != curr.val) return false;
            curr = curr.next;
        }

        return true;
    }
}