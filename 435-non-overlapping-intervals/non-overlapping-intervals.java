class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        int count = 0;
        // sort the array in acending order for start element
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        int last = intervals[0][1];
        // iterate for 2nd element to last
        for(int i=1; i<intervals.length;i++)
        {
            // if prev last > curr starting then overlapp
            // increment counter +1
            // find min of lasts values among both, bcz we need to remove min no. of ballons. if largerange baloon is present it will effect the calculation
            if(last > intervals[i][0])
            {
                count++;
                last = Math.min(last,intervals[i][1]);
            }
            // else take the last of next array
            else
            {
                last = intervals[i][1];
            }
        }
        return count;
    }
}