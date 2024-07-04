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
    public ListNode mergeNodes(ListNode head) {
        
        ListNode temp = head.next;      //Creating temp to traversal the LL
        ListNode ans = head;            //Creating ans to traversal my result LL
        ListNode newHead = head;        //Created newHead keep my result head
        int sum = 0;                    // Initially the sum = 0
        while(temp!=null)
        {
            // If sum != 0 calculate the sum and move to nxt element
            if(temp.val != 0)
            {
                sum = sum+temp.val;
                temp = temp.next;
            }
            // Store the new Sum and move the pointer
            else
            {
                ListNode total = new ListNode(sum);
                ans.next = total;
                ans = ans.next;
                temp = temp.next;
                sum = 0;
            }
        }
        return newHead.next;
    }
}