class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rown = matrix.length;
        int coln = matrix[0].length;
        for(int i=0; i<rown;i++)
        {
            int min_value = Integer.MAX_VALUE;
            int col_value = -1; 
            for(int j=0;j<coln;j++)
            {
                if(matrix[i][j] < min_value)
                {
                    min_value = matrix[i][j];
                    col_value = j; 
                }
            }
            int max_value = Integer.MIN_VALUE;
            for(int k=0;k<rown;k++)
            {
                if(matrix[k][col_value] > max_value)
                {
                    max_value = matrix[k][col_value];
                }
            }
            if(min_value == max_value)
            {
                result.add(min_value);
                break;
            } 
        }
        return result;
    }
}