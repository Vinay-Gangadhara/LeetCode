class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
    PriorityQueue<Pair> minHeap = new PriorityQueue<>();
    int M = 1000000007;    
    int count = 1;
    int result = 0;
    for(int i=0;i<nums.length;i++)
    {
        minHeap.add(new Pair(nums[i],i));
    }
    for(count=1;count<=right;count++)
    {
        Pair old = minHeap.peek();
        minHeap.poll();
        int sum = old.first;
        int idx = old.second;
        if(count>=left)
        {
            result = (result + sum) % M;
        }
        int new_idx = idx+1;
        if(new_idx<n)
        {
            sum += nums[new_idx];
            minHeap.add(new Pair(sum,new_idx));
        }
    }
    return result;
    }
}
  class Pair implements Comparable<Pair> {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.first, other.first);
        }
    }