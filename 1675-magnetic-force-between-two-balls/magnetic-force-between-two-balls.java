class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 1;
        int high = position[position.length-1];
        int ans = -1;
        // Finding my answer range (min,max)
        while(low<=high)
        {
            int mid = (low+high)/2;
            // Applying BS on Answers
            if(calculate(mid,position,m))
            {
                // If calculation is true that means distance is less we need to incease the range
                ans = mid;
                low = mid+1;
            }
            else
            {
                // Else condition means the distance is very lasrge we cannot accomodate all bals so need to reduce the distance
                high = mid-1;
            }
        }
        // returning the pivot value;
        return high;
    }

    public boolean calculate(int mid,int[] position, int m)
    {
        //Initially placing 1 ball in first basket and incrementing the ball count
        int prevposition = 0; 
        int ballsplaced = 1;

        for(int i=1; i<position.length;i++)
        {
            //Checking the distance between prev placed ball and current basket.
            // If distance is greater we increment the ball count and change the prev placed ball to current.
            if(position[i] - position[prevposition]>=mid)
            {
                prevposition = i;
                ballsplaced++;
            }
        }
        // Now check the total ball placed for distance mid.
        // If No.of Balls placed > m return true else False 
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