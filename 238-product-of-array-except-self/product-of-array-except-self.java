class Solution {
    public int[] productExceptSelf(int[] nums) {
        //intialising the answer array container
        int[] ans = new int[nums.length];
        Arrays.fill(ans,1);
        
        //Finding the prefix sum for the given array
        int presum = 1;
        for(int i=0; i<nums.length;i++)
        {
            ans[i] = presum;
            presum = presum*nums[i];
        }
        
        //Finding the postfix sum for the given array
        int postsum = 1;
        for(int i=nums.length-1; i>=0;i--)
        {
            ans[i] = ans[i]*postsum;
            postsum = postsum*nums[i];
        }
        
        return ans;
        
    }
}