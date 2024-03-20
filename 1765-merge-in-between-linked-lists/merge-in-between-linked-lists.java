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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        // taking 2 pointer from list 1.
        // travel 1st pointer to a-1 position
        // 2nd pointer to b+1 posision
        // connect 1st pointer . next to list2
        // list2 ending to pointer 2
        ListNode first = list1;
        ListNode conn = list1;
        for(int i=0;i<a-1;i++)
        {
            first = first.next;
        }
        for(int i=0;i<=b;i++)
        {
            conn = conn.next;
        }
        first.next = list2;
        ListNode last = list2;
        while(last.next !=null)
        {
            last = last.next; 
        }
        last.next = conn;
        return list1;        
    }
}