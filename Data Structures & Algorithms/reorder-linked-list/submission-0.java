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
    // Given 1 -> 2 -> 3 -> 4 -> 5 -> null
    // We want 1 -> 5 -> 2 -> 4 -> 3 -> null
    public void reorderList(ListNode head) {
        // Split the LL in half. If odd, first half contains one more
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null; // Break first half
        ListNode prev = null;

        // Reverse second half LL
        while (second != null) { // 'second' is basically the head of the second half of the LL
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }

        /*
            1      -> 2 -> 3 -> null
            first

            5      -> 4 -> null
            second
        */
        ListNode first = head;
        second = prev; // 'second' is the head of the reversed 2nd half LL
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    }
}
