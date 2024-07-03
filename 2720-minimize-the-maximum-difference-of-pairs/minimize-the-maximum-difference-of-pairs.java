class Solution {
    public int minimizeMax(int[] nums, int p) {
        
        //Binary Search approach
        // BS on Answers 
        // we need to find pairs whose diff <= mid
        // if No.of pairs > p reduce high
        // else increase low
        Arrays.sort(nums);
        int n = nums.length;
        int low = 0;
        int high = nums[n-1] - nums[0];
        

        while(low <= high)
        {
            int mid = low + (high-low)/2;
            int res = isValid(mid, nums, p);
            
            if(res >= p )
            {
                high = mid-1; 
            }
            else
            {
                low = mid+1;
            }

        }
        return low;
    }

    public int isValid(int mid, int[] nums, int p)
    {
        int i=0;
        int count = 0;
        int n = nums.length;
        while(i<n-1)
        {
            if((nums[i+1] - nums[i]) <= mid)
            {
                count++;
                i = i+2;
            }
            else
            {
                i++;
            }
        }
        return count;
    }
}

//1,1,2,3,7,10