class Solution {
    public boolean isPalindrome(ListNode head) 
    {
        if(head == null || head.next == null)
        {
            return true;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        fast = fast.next.next;
        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode newhead = reverse(slow.next);
        fast = head;
        
        while(fast!=null && newhead!=null)
        {
            if(fast.val != newhead.val)
            {
                return false;
            }
            fast = fast.next;
            newhead = newhead.next;
        }
        return true;   
    }
    
    public ListNode reverse(ListNode head)
    {
        if (head == null || head.next == null) 
        {
            return head;
        }
        
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr != null)
        {
            ListNode futr = curr.next;
            curr.next = prev;
            prev = curr;
            curr = futr;
        }
        return prev;
    }
}