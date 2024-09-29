/**
 * 
 * ROTTEN ORANGES
 * 
 * Given a grid of dimension nxm where each cell in the grid can have values 0, 1 or 2 which has the following meaning:
    0 : Empty cell
    1 : Cells have fresh oranges
    2 : Cells have rotten oranges

    We have to determine what is the earliest time after which all the oranges are rotten. A rotten orange at index [i,j] can rot other fresh orange at indexes 
    [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in unit time. 

  *
  * multi-source bfs + queue<CUSTOM CLASS --> cell index + time>
  * 
  * 
  * class Solution
{
    
    public class NodeInfo{
        int r;
        int c;
        int t;
        public NodeInfo(int r , int c , int t){
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }
    
    public boolean isValidCell(int[][] grid , int i , int j){
        return (i>=0 && j>=0 && i<grid.length && j<grid[0].length);
    }
    
    public int orangesRotting(int[][] grid)
    {
        int n = grid.length;
        
        int m = grid[0].length;
        
        boolean[][] visited = new boolean[n][m];
        
        Queue<NodeInfo> q = new LinkedList<>();
        
        for(int i=0 ; i<grid.length ; i++){
            for(int j=0 ; j<grid[0].length ; j++){
                if(grid[i][j] == 2){
                    q.add(new NodeInfo(i , j , 0));
                    visited[i][j] = true;
                }
            }
        }
        
        int ans = 0;
        
        while(!q.isEmpty()){
            NodeInfo curr = q.remove();
            
            if(isValidCell(grid , curr.r+1 , curr.c) && !visited[curr.r+1][curr.c] && grid[curr.r+1][curr.c] != 0){
                grid[curr.r+1][curr.c] = 2;
                q.add(new NodeInfo(curr.r+1 , curr.c , curr.t+1));
                visited[curr.r+1][curr.c] = true;
                ans = Math.max(ans , curr.t+1);
            }
            
            if(isValidCell(grid , curr.r , curr.c+1) && !visited[curr.r][curr.c+1] && grid[curr.r][curr.c+1] != 0){
                grid[curr.r][curr.c+1] = 2;
                q.add(new NodeInfo(curr.r , curr.c+1 , curr.t+1));
                visited[curr.r][curr.c+1] = true;
                ans = Math.max(ans , curr.t+1);
            }
            
            if(isValidCell(grid , curr.r-1 , curr.c) && !visited[curr.r-1][curr.c] && grid[curr.r-1][curr.c] != 0){
                grid[curr.r-1][curr.c] = 2;
                q.add(new NodeInfo(curr.r-1 , curr.c , curr.t+1));
                visited[curr.r-1][curr.c] = true;
                ans = Math.max(ans , curr.t+1);
            }
            
            if(isValidCell(grid , curr.r , curr.c-1) && !visited[curr.r][curr.c-1] && grid[curr.r][curr.c-1] != 0){
                grid[curr.r][curr.c-1] = 2;
                q.add(new NodeInfo(curr.r , curr.c-1 , curr.t+1));
                visited[curr.r][curr.c-1] = true;
                ans = Math.max(ans , curr.t+1);
            }
        }
        
        for(int i=0 ; i<grid.length ; i++){
            for(int j=0 ; j<grid[0].length ; j++){
                if(grid[i][j] == 1) return -1;
            }
        }
        
        return ans;
    }
}
  * 
 */