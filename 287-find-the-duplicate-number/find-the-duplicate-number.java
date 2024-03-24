class Solution {
    public int findDuplicate(int[] nums) {
        // consider this array to be linkedlist
        // traverse fast and slow pointer accordingly
        int slow = nums[0];
        int fast = nums[0];
        do
        {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while(slow!=fast);
        // once the meet make fast pointer to 0th position
        // now traverse one by one step until they collide
        fast = nums[0];
        while(slow!=fast)
        {
            slow = nums[slow];
            fast = nums[fast];
        }
        return(fast);
        
    }
}