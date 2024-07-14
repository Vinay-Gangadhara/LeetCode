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
    public ListNode modifiedList(int[] nums, ListNode head) 
    {
        Set<Integer> lst = new HashSet<>();
        for(int i : nums)
        {
            lst.add(i);
        }

        ListNode strt = head;
        while(strt!=null && lst.contains(strt.val))
        {
            strt = strt.next;
        }
        ListNode itr = strt.next;
        ListNode itr1 = strt;
        while(itr!=null)
        {
            if(lst.contains(itr.val))
            {
                itr1.next = itr.next;
            }
            else
            {
                itr1 = itr;
            }
            itr = itr.next;
        }
        return strt;
    }
}