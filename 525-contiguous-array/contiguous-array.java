class Solution {
    public int findMaxLength(int[] nums) {
        int max = 0;
        int count =0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,-1);
        
        for(int i = 0;i<nums.length;i++)
        {
            if(nums[i] == 1)
            {
                count++;
            }
            else
            {
                count--;
            }
            
            if(hm.containsKey(count))
            {
                max = Math.max(max,(i-hm.get(count)));
            }
            else
            {
                hm.put(count,i);
            }
        }
        return max;
    }
}