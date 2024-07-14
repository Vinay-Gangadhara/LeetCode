class Solution {
    public int minimumCost(int m1, int n1, int[] horizontalCut, int[] verticalCut)  {

     int i = 0;
     int j = 0;

     int hor = 1;
     int ver = 1;

     long ans = 0;

    int n = horizontalCut.length;
    int m = verticalCut.length;

    // Convert to Integer arrays for sorting in descending order
        Integer[] horizontalCutDesc = Arrays.stream(horizontalCut).boxed().toArray(Integer[]::new);
        Integer[] verticalCutDesc = Arrays.stream(verticalCut).boxed().toArray(Integer[]::new);

        // Sort the arrays in descending order
        Arrays.sort(horizontalCutDesc, Collections.reverseOrder());
        Arrays.sort(verticalCutDesc, Collections.reverseOrder());

        // Convert back to int arrays if needed
        horizontalCut = Arrays.stream(horizontalCutDesc).mapToInt(Integer::intValue).toArray();
        verticalCut = Arrays.stream(verticalCutDesc).mapToInt(Integer::intValue).toArray();

    while(i<n && j<m)
    {
        if(horizontalCut[i] >= verticalCut[j])
        {
            ans += (long)(ver* horizontalCut[i]);
            hor++;
            i++;
        }
        else
        {
            ans += (long)(hor*verticalCut[j]);
            ver++;
            j++;
        }
    }

    while(i<n)
    {
        ans += (long) (ver* horizontalCut[i]);
        hor++;
        i++;
    }

    while(j<m)
    {
        ans += (long) (hor*verticalCut[j]);
        ver++;
        j++;
    }

    return (int)ans;

    }
}