class Solution {
    public int pivotInteger(int n) {
        
        //Using Binary search for iteratinf to the list of Numbers
            int low = 1;
            int high = n;
            
            while(low<=high)
            {
                int mid = (low+high)/2;
                // Finding left half sum
                int ans1 = (mid * (mid+1))/2;
                //Finding the rright half Sum
                int ans2 = ((n * (n+1))/2) - ans1 + mid;
                if(ans1 == ans2)
                {
                    return mid;
                }
                // If left sum is less we move right 
                if(ans1<ans2)
                {
                    low = mid+1;
                }
                else
                {
                    high = mid-1;
                }
            }
        return -1;
    }
}