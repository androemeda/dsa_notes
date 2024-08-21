/**
 * bipartite 
 * 
 * linear graph will always be bipartite
 * 
 * graph with even cycle length is always bipartite
 * 
 * graph with odd length cycle is never bipartite
 */

/**
 * 
 * BFS --> color array , -1 mean not colored  + color with 0 and 1
 * 
 * class Solution
{
    
    public boolean bfs(int src , ArrayList<ArrayList<Integer>>adj , int[] colors){
        
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        colors[src] = 0;
        
        while(!q.isEmpty()){
            
            int curr = q.remove();
            int currColor = colors[curr];
            
            for(Integer nb : adj.get(curr)){
                if(colors[nb] == -1){
                    colors[nb] = currColor^1;
                    q.add(nb);
                }
                else if(colors[nb] == currColor) return false;
            }
        }
        
        return true;
    }
    
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        
        int[] colors = new int[V];
        Arrays.fill(colors , -1);
        
        for(int i=0 ; i<V ; i++){
            if(colors[i] == -1){
                if(!bfs(i , adj , colors)) return false;
            }
        }
        
        return true;
    }
}
 */



/**
 * 
 * DFS
 * 
 * class Solution
{
    
    public boolean dfs(int src , int parent , ArrayList<ArrayList<Integer>>adj , int[] colors){
        
        if(parent == -1) colors[src] = 0;
        else colors[src] = colors[parent]^1;
        
        for(Integer nb : adj.get(src)){
            if(colors[nb] == -1){
                if(!dfs(nb , src , adj , colors)) return false;
            }
            else if(colors[nb] == colors[src]) return false;
        }
        
        return true;
    }
    
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        
        int[] colors = new int[V];
        Arrays.fill(colors , -1);
        
        for(int i=0 ; i<V ; i++){
            if(colors[i] == -1){
                if(!dfs(i , -1 , adj , colors)) return false;
            }
        }
        
        return true;
    }
}
 */