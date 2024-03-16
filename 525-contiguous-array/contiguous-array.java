class Solution {
    public int findMaxLength(int[] nums) {
        int max = 0;
        int count =0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,-1);
        //Iterate through each element
        for(int i = 0;i<nums.length;i++)
        {
            // if we get 1 increment the counter
            if(nums[i] == 1)
            {
                count++;
            }
            // If we get 0 decrement the counter
            else
            {
                count--;
            }
            // we will check if the counter has any same value in hm, if yes find the max length
            if(hm.containsKey(count))
            {
                max = Math.max(max,(i-hm.get(count)));
            }
            // if no match add that element into the hm with the first occurance of the count.
            else
            {
                hm.put(count,i);
            }
        }
        return max;
    }
}