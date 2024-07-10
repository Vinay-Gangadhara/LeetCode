// Creating a class for my data which is rotton orange
class pair {
    int row;
    int col;
    int time;

    pair(int row, int col, int time)
    {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int row_length = grid.length;
        int col_length = grid[0].length;
        int fresh_count = 0;
        // Creating a new matrix for visited
        int vis[][] = new int[row_length][col_length];
        // Creating Queue and storing pairs
        Queue<pair> q = new LinkedList<>();
        // fill the visited mattrix
        for(int i=0; i<row_length; i++)
        {
            for(int j=0; j<col_length; j++)
            {
                // if the original matrix is 2 add to queue and mark visited matrix
                if(grid[i][j] == 2)
                {
                    q.add(new pair(i,j,0));
                    vis[i][j] = 2;
                }
                // else mark visited matrix with 0
                else
                {
                    vis[i][j] = 0;
                }
                // keep a count of fresh count
                if(grid[i][j] == 1)
                {
                    fresh_count++;
                }
            }
        }
        // have matrix for 4 directions
        int drow[] = {-1,0,+1,0};
        int dcol[] = {0,+1,0,-1};
        int max_time = 0;
        int count=0;
        while(q.size() > 0)
        {
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            max_time = Math.max(max_time,t);
            q.remove();
            for(int i=0; i<4;i++)
            {
                int nr = r + drow[i];
                int nc = c + dcol[i];
                if(nr >=0 && nr <row_length && nc >=0 && nc < col_length && vis[nr][nc] ==0 && grid[nr][nc] == 1)
                {
                    q.add(new pair(nr, nc, t+1));
                    vis[nr][nc] = 2;
                    count++;
                }
            }
        }

        if(count != fresh_count) return -1;
        return max_time;
    }
}