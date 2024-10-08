class KthLargest {
    private int k;
    private PriorityQueue<Integer> pq = new  PriorityQueue<Integer>();
    public KthLargest(int k, int[] nums) 
    {
        this.k = k;
        for(int i=0;i<nums.length;i++)
        {
            pq.add(nums[i]);
        }    
    }
    
    public int add(int val) 
    {
        pq.add(val);
        while(pq.size() > k)
        {
            pq.remove();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
