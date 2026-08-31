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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        

        List<Integer> criticalPoints = new ArrayList<>();

        ListNode prev = head;
        ListNode curr = head.next;

        int i = 1;

        while(curr.next != null){

            if((curr.val < prev.val && curr.val < curr.next.val) || 
                (curr.val > prev.val && curr.val > curr.next.val)){
                    criticalPoints.add(i);
            }

            prev = curr;
            curr = curr.next;
            i++;
        }

        int[] minDis = new int[]{-1, -1};

        if(criticalPoints.size() <= 1)
            return minDis;
        
        minDis[0] = Integer.MAX_VALUE;
        minDis[1] = criticalPoints.get(criticalPoints.size() - 1) - criticalPoints.get(0);

        for(i = 1; i < criticalPoints.size(); i++)
            minDis[0] = Math.min(minDis[0], Math.abs(criticalPoints.get(i) - criticalPoints.get(i - 1)));

        return minDis;
    }
}