class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] ans = new int[nums.length];
        Arrays.fill(ans,1);
        
        int presum = 1;
        for(int i=0; i<nums.length;i++)
        {
            ans[i] = presum;
            presum = presum*nums[i];
        }
        
        int postsum = 1;
        for(int i=nums.length-1; i>=0;i--)
        {
            ans[i] = ans[i]*postsum;
            postsum = postsum*nums[i];
        }
        
        for(int i : ans)
        {
            System.out.println(i);
        }
        return ans;
        
    }
}