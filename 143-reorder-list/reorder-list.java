class Solution {
    public ListNode reverse(ListNode l)
    {
        ListNode prev = null;
        ListNode curr = l;
        while(curr!=null)
        {
            ListNode forwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forwd;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode l2 = reverse(slow.next);
        slow.next = null;
        ListNode l1 = head;
        
        while(l2!=null)
        {
            ListNode temp1 = l1.next;
            ListNode temp2 = l2.next;
            l1.next = l2;
            l2.next = temp1;
            l1 = temp1;
            l2 = temp2;
        }
    }
}