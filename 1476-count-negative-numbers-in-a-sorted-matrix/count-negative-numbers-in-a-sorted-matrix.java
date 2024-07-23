class Solution {
    public int countNegatives(int[][] grid) {
        /**
        
        -----> Main Idea:
        1. in each row find the first negetive number.
        2. TGhe remaining cols will automaticallay be less than my current number hence add all the elements.
        3. If you dont find -ve value increment cols value. */
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        int i = n-1;
        int j = 0;
        while(i>=0 && j<m)
        {
            if(grid[i][j] < 0)
            {
                count += m-j;
                i--;
            }
            else
            {
                j++;
            }
        }
        return count;
    }
}

/**

-----> Time Complexity === O(N+M)
-----> Space Complexity === O(1)
*/