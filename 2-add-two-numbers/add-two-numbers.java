class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode temp = new ListNode(-1);
        ListNode curr = temp;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int carry = 0;
        while(temp1 != null || temp2 != null)
        {
            int sum = carry;
            if(temp1!=null)
            {
                sum += temp1.val;
            }
            if(temp2!=null)
            {
                sum += temp2.val;
            }
            
            ListNode node = new ListNode(sum%10);
            curr.next = node;
            curr = curr.next;
            carry = sum/10;
            if(temp1!=null)
            {
                temp1 = temp1.next;
            }
            if(temp2!=null)
            {
                temp2 = temp2.next;
            }
        }
        
        if(carry!=0)
        {
            ListNode node = new ListNode(carry);
            curr.next = node;
            curr = curr.next;
        }
        curr.next = null;
        return(temp.next);
        
        
    }
}