class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rown = matrix.length;
        int coln = matrix[0].length;
        // Iterate through the row
        for(int i=0; i<rown;i++)
        {
            int min_value = Integer.MAX_VALUE;
            int col_value = -1; 
            // Iterate through the row and find the min value in the row
            for(int j=0;j<coln;j++)
            { 
                if(matrix[i][j] < min_value)
                {
                    min_value = matrix[i][j];
                    col_value = j; 
                }
            }
            //once we find the lowest value in the row
            //Iterate through the column
            //Find the max value in the column 
            int max_value = Integer.MIN_VALUE;
            for(int k=0;k<rown;k++)
            {
                if(matrix[k][col_value] > max_value)
                {
                    max_value = matrix[k][col_value];
                }
            }
            //If the max value and the min value is equal
            //That is the Lucky Number
            if(min_value == max_value)
            {
                result.add(min_value);
                break;
            } 
            //We can only have 1 Lucky number in an matrix
        }
        return result;
    }
}