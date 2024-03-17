class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //Initialising the array
        int n= intervals.length;
        List<int[]> result = new ArrayList<>();
        int i=0;
        // check for each element
        while(i<n)
        {
            // if last elemt of array > first elemet in new array then cannor merge
            if(intervals[i][1] < newInterval[0])
                result.add(intervals[i]);
            // if first element in array > last element in new array cannot merge
            else if(intervals[i][0] > newInterval[1])
                break;
            // if we can merge : [0] => min of both, [1] => max of both
            else
            {
                newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            }
            i++;
        }
        // add the new merged interval
        result.add(newInterval);
        // after merging if any elements available add them directly
        while(i<n)
        {
            result.add(intervals[i]);
            i++;
        }
        
        return(result.toArray(new int[result.size()][2]));
    }
}