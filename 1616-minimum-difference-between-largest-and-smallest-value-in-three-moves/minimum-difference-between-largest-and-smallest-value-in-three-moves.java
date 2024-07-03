class Solution {
    public int minDifference(int[] nums) {
        
        // There is only 4 possibility to chnage the values 
        Arrays.sort(nums);
        int n = nums.length;
        if(n <= 4)
        {
             return 0;
        }

        // Case 1
        // remove largest 3
        int c1 = nums[n-4] - nums[0];

        // Case 2
        // remove largest 2 and smallest 1
        int c2 = nums[n-3] - nums[1];

        // Case 3
        // remove largest 1 and smallest 2
        int c3 = nums[n-2] - nums[2];

        // Case 4
        // remove smallest 3
        int c4 = nums[n-1] - nums[3];

        // Minimum of all 4 cases
        return Math.min(c1,Math.min(c2,Math.min(c3,c4)));  
    }
}