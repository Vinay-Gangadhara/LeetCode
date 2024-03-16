class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();
        int n = candidates.length;
        List<Integer> ds = new ArrayList<>();
        findS(0,candidates,target,0,ans,ds);
        return ans;
    }
    
    void findS(int indx, int[] arr, int target, int sum, List<List<Integer>> ans, List<Integer> ds)
    {
        if(indx == arr.length)
        {
            if(target == 0)
            {
                ans.add(new ArrayList(ds));     
            }
            return;
        }
        
        
        if(arr[indx]<=target)
        {
            ds.add(arr[indx]);
        findS(indx,arr,target-arr[indx],sum,ans,ds);
        ds.remove(ds.size()-1);
        }
        
        findS(indx+1,arr,target,sum,ans,ds);
    }
}