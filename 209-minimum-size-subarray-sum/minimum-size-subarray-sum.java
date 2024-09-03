 class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int result = Integer.MAX_VALUE;
        int sum=0;
        for(int right=0;right<nums.length;right++)
        {
            sum+=nums[right];

            while(sum>=target)
            {
                result = Math.min(result, right-left+1);
                sum -= nums[left];
                left++;
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}

/*
-----> Main Intution:
1. keep adding the right element into the sum.
2. Once added keep removing the left values until sum>=target.
3. Now update the min value 
4. result result
*/