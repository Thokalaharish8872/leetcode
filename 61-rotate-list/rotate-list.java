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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
                return null;
            }

            ListNode tail = head;
            ListNode orinial_list = head;
            int size=0;
            int i=1;
            while(tail.next!=null){
                tail = tail.next;
                size++;
            }

            size++;

            if(size==1 || k==0 || k%size ==0){
                return head;
            }
            k=k%size;
            head = reverse(head,tail.next);

            tail = head;
            while(i<k){
                tail = tail.next;
                i++;
            }

            ListNode sec_head = tail.next;

            ListNode head1  = reverse(head,tail.next);

            ListNode head2 = reverse(sec_head, orinial_list.next);

            ListNode temp = head1;
            while(temp.next!=null){
                temp = temp.next;
            }
           temp.next = head2;
        return head1;
        }

        public static ListNode reverse(ListNode head,ListNode tail){
            ListNode temp = head.next;
            ListNode prev = null;
            ListNode curr = head;
            while(curr!=tail){
                curr.next = prev;
                prev = curr;
                curr = temp;
                if(temp ==  null){
                    break;
                }
                temp = temp.next;
            }
            return prev;
        }
        
    
}