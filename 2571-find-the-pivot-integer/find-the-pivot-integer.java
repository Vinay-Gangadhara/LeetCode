class Solution {
    public int pivotInteger(int n) {
        if(n == 1)
        {
            return 1;
        }
        if (n==2)
        {
            return -1;
        }
        else
        {
            int low = 1;
            int high = n;
            
            while(low<=high)
            {
                int mid = (low+high)/2;
                int ans1 = (mid * (mid+1))/2;
                int ans2 = ((n * (n+1))/2) - ans1 + mid;
                if(ans1 == ans2)
                {
                    return mid;
                }
                if(ans1<ans2)
                {
                    low = mid+1;
                }
                else
                {
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}