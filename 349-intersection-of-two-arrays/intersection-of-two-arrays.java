class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hs_nums1 = new HashSet<Integer>();
        HashSet<Integer> hs_nums2 = new HashSet<Integer>();
        HashSet<Integer> hs_result = new HashSet<Integer>();
        
        for(int i : nums1)
        {
            hs_nums1.add(i);
        }
        
        for(int i : nums2)
        {
            hs_nums2.add(i);
        }
        
        for(int i : hs_nums1)
        {
            if(hs_nums2.contains(i))
            {
                hs_result.add(i);
            }
        }
        int result[] = new int[hs_result.size()];
        int index = 0;
        
        for(int i: hs_result)
        {
            result[index] = i;
            index++;
        }
        return result;
    }
}