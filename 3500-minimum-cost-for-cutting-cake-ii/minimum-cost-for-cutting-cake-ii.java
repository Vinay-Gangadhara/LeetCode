class Solution {
    public long minimumCost(int mgiven, int ngiven, int[] horizontalCut, int[] verticalCut) {
    // keep 2 pointers for iterating the array
     int i = 0;
     int j = 0;
    // initially we have 1 complete hor and 1 complete ver
     int hor = 1;
     int ver = 1;
    // initialising the result
     long ans = 0;
    // Keeping count of given array size;
    int m = horizontalCut.length;
    int n = verticalCut.length;
    // Sorting the array in Desc order
    horizontalCut = Arrays.stream(horizontalCut)
                              .boxed()
                              .sorted(Collections.reverseOrder())
                              .mapToInt(Integer::intValue)
                              .toArray();

    verticalCut = Arrays.stream(verticalCut)
                            .boxed()
                            .sorted(Collections.reverseOrder())
                            .mapToInt(Integer::intValue)
                            .toArray();

    // Iterating to the array 
    while(i<m && j<n)
    {
        //Take the largest value and cut it
        if(horizontalCut[i] >= verticalCut[j])
        {
            //once cut multiply the cutting factor with No. remaining parts
            ans += (long)(ver* horizontalCut[i]);
            // increment the cut part count
            hor++;
            i++;
        }
        else
        {
            //once cut multiply the cutting factor with No. remaining parts
            ans += (long)(hor*verticalCut[j]);
            // increment the cut part count
            ver++;
            j++;
        }
    }
    // Do the same operation for left over parts
    while(i<m)
    {
        ans += (long) (ver* horizontalCut[i]);
        hor++;
        i++;
    }

    while(j<n)
    {
        ans += (long) (hor*verticalCut[j]);
        ver++;
        j++;
    }

    return ans;

    }
}