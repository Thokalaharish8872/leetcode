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
    
    ListNode mid;

    private int solve(ListNode head, ListNode slow, ListNode fast){
        if(fast == null)
            return -1;
        
        mid = slow;

        int sum = solve(head, slow.next, fast.next.next);
        mid = mid.next;

        return Math.max(sum, slow.val + mid.val);
    }
    public int pairSum(ListNode head) {

        ListNode slow = head, fast = head;

        return solve(head, slow, fast);
    }
}