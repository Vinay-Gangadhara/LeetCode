class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        // Initialise result matrix, lengths of row and col sums.
        int m = rowSum.length;
        int n = colSum.length;
        int[][] result = new int[m][n];
        int i=0;
        int j=0;
        /*
        **Main Logic**:
        1. Use greedy method to place which is smaller number among row/col in the cell.
        2. Minus that numer from row and col.
        3. once place we will have 1 value which is 0 either row/col.
        4. Move the pointer which is 0. If row sum is 0 move to next row. Vice versa.
        5. Since all the give sum will form a perfect matrix at the last cell we will equal value left in row/col sum. End resulting a perfect matrix.
        */
        while(i<m && j<n)
        {
            result[i][j] = Math.min(rowSum[i],colSum[j]);
            rowSum[i] = rowSum[i] - result[i][j];
            colSum[j] = colSum[j] - result[i][j];
            if(rowSum[i] == 0)
            {
                i++;
            } 
            if(colSum[j] == 0)
            {
                j++;
            }
        }
        return result;
    }
}