class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
    PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1,p2) -> Integer.compare(p1.first,p2.first));
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
  class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    /*
    -------> Main Idea:
    1. Create a Min Heap which will hold a Pair(Sum,index).
    2. Everytime you pop the items from Heap, you will keep getting increasing order Sum of Sub-Arrays.
    3. New Keep a counter to only have result from left to right;
    4. Once we Pop element add the next index value into sum and increment index. Make sure index < n before you add to sum.
    5. Once have result in range left to right return result.
    6. minHeap requires to implement comparable because priorityQueue only sorts by natural order for Custom compare need a Comparable.
    */