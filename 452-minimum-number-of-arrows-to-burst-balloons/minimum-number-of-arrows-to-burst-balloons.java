class Solution {
    public int findMinArrowShots(int[][] points) {
        //Initialising the result container
        int count = 1;
        // sorting the ballons based on start value increasing order
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int last = points[0][1];
        for(int i=1;i<points.length; i++)
        {
            // check if the last ending values > current starting value
            if(last >= points[i][0])
            {
                // if so find the min between them because we need the max overlapping area between them
                last = Math.min(points[i][1],last);
            }
            // else take the curennt ending and increase the counter
            else
            {
                last = points[i][1];
                count++;
            }
        }
        // increase the cuter by 1 because we missed he last set of ballons
        return count;
        
    }
}