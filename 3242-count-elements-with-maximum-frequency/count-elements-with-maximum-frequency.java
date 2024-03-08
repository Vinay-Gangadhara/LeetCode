class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        int max = Integer.MIN_VALUE;
        int count = 0;
        for(int i : nums)
        {
            if(hm.containsKey(i))
            {
                int temp = hm.get(i);
                hm.put(i,temp+1);
            }
            else
            {
                hm.put(i,1);
            }
        }
        
        for(int i:hm.values())
        {
            if(i > max)
            {
                max = i;
            }
        }
        
         for (int freq : hm.values()) {
            if (freq == max)
                count += max;
        }
        return count;
    }
}