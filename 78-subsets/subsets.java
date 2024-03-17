class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        List<Integer> ds = new ArrayList<>();
        funcs(0,nums,n,ans,ds);
        return ans;
    }
    
    public void funcs(int indx, int[] nums, int n, List<List<Integer>> ans, List<Integer> ds)
    {
        if(indx == n)
        {
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        ds.add(nums[indx]);
        funcs(indx+1,nums,n,ans,ds);
        ds.remove(ds.size()-1);
        funcs(indx+1,nums,n,ans,ds);
    }
}