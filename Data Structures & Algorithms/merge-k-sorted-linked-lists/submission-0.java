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

    // Min heap approach. time: O(n * logk) space: O(k)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);
        for (ListNode head: lists) {
            if (head != null) {
                minHeap.offer(head);
                head = head.next;
            }
        }


        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            cur.next = node;
            cur = cur.next;
            node = node.next;
            if (node != null) {
                minHeap.offer(node);
            }
        }

        return dummy.next;
    }
}
