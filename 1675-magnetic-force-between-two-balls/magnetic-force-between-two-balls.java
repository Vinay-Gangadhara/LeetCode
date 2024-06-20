class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 1;
        int high = position[position.length-1];
        int ans = -1;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(calculate(mid,position,m))
            {
                ans = mid;
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return ans;
    }

    public boolean calculate(int mid,int[] position, int m)
    {
        int prevposition = 0; 
        int ballsplaced = 1;

        for(int i=1; i<position.length;i++)
        {
            //int current_position = prevposition+mid;
            if(position[i] - position[prevposition]>=mid)
            {
                prevposition = i;
                ballsplaced++;
            }
        }
        if(ballsplaced >= m)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}