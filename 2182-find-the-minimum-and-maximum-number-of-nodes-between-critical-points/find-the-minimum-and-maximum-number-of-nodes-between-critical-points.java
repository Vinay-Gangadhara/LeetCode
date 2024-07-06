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
        ListNode first = head;
        ListNode sec = head.next;
        ListNode third;
        int count = 2;
        List<Integer> ll = new ArrayList<Integer>();
        if(sec.next != null)
        {
            third = sec.next;
        }
        else
        {
            return (new int[] {-1,-1} );
        }

        while(third != null)
        {
            if((sec.val > first.val && sec.val > third.val) || (sec.val < first.val && sec.val < third.val))
            {
                ll.add(count);
            }
            count++;
            first = first.next;
            sec = sec.next;
            third = third.next;
        }
        System.out.println(ll);
        int n = ll.size();
        //System.out.println(n);
        // Calculate the maximum difference
        if(n<2)
        {
            return (new int[] {-1,-1} );
        }
        else
        {
            int maxDiff = ll.get(n - 1) - ll.get(0);

            // Calculate the minimum difference
            int minDiff = Integer.MAX_VALUE;
            for (int i = 1; i < n; i++) {
                int diff = ll.get(i) - ll.get(i - 1);
                if (diff < minDiff) {
                    minDiff = diff;
                }
            }
            return new int[]{minDiff,maxDiff};
        }
        
        
    }
}