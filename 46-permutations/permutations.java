class Solution {
    public List<List<Integer>> permute(int[] nums) {
        //Initialising the array container
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        
        funcs (0,nums,ans,n);
        return ans;
        
    }
    
    public void funcs(int indx, int[] nums,List<List<Integer>> ans, int n)
    {
        // if the index == n then we have formed the n digits number add to result
        if(indx == n)
        {
            List<Integer> ds = new ArrayList<>();
            for(int i: nums)
            {
                ds.add(i);
            }
            ans.add(new ArrayList<>(ds));
        }
        // iterate for index to n-1 and keep swapping each digits
        for(int i=indx; i<n; i++)
        {
            swap(nums,i,indx);
            funcs(indx+1,nums,ans,n);
            swap(nums,i,indx);
        }
    }
    // swap function
    public void swap(int[] nums,int x, int y)
    {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}