class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        HashSet<Integer> hs1 = new HashSet<>();
        HashSet<Integer> hs2 = new HashSet<>();
        boolean flag = true;
        for(int i: nums)
        {
            flag = true;
            if(!hs1.contains(i))
            {
                hs1.add(i);
                flag = false;
            }
            else if(!hs2.contains(i))
            {
                hs2.add(i);
                flag = false;
            }
            if(flag)
            {
                break;
            }
        }
        return !flag;
    }
}