/**
 * 
 * cycle in undirected graph BFS --> adj list + queue<node , parent node>  + check for connected components using for loop and visited array
 * 
 * class Solution {
    
    public class NodeInfo{
        int node;
        int parent;
        public NodeInfo(int n , int p){
            this.node = n;
            this.parent = p;
        }
    }
    
    public boolean helper(int src , boolean[] visited , ArrayList<ArrayList<Integer>> adj){
        
        Queue<NodeInfo> q = new LinkedList<>();
        
        q.add(new NodeInfo(src , -1));
        visited[src] = true;
        
        while(!q.isEmpty()){
            
            NodeInfo curr = q.remove();
    
            for(Integer nb : adj.get(curr.node)){
                if(nb == curr.parent) continue;
                if(visited[nb]) return true;
                q.add(new NodeInfo(nb , curr.node));
                visited[nb] = true;
            }
        }
        
        return false;
        
    }
    
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean[] visited = new boolean[V];
        
        for(int i=0 ; i<V ; i++){
            if(!visited[i]) if(helper(i , visited , adj)) return true;
        }
        
        return false;
    }
}

 */

/**
 * 
 * cycle in undirected graph - DFS
 * 
 * class Solution {
    
    public class NodeInfo{
        int node;
        int parent;
        public NodeInfo(int n , int p){
            this.node = n;
            this.parent = p;
        }
    }
    
    public boolean helper(int src , int parent , boolean[] visited , ArrayList<ArrayList<Integer>> adj){
        
        visited[src] = true;
        
        for(Integer nb : adj.get(src)){
            if(nb == parent) continue;
            if(visited[nb]) return true;
            if(helper(nb , src , visited , adj)) return true;
        }
        
        return false;
        
    }
    
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean[] visited = new boolean[V];
        
        for(int i=0 ; i<V ; i++){
            if(!visited[i]) if(helper(i , -1 , visited , adj)) return true;
        }
        
        return false;
    }
}
 */


/** 
 * 
 * cycle in directed graph --> same node should get visited agin while walking on the same path
 * 
 * class Solution {
    
    private boolean cycle(int node, boolean[] visited, boolean[] pathV, ArrayList<ArrayList<Integer>> adj) {
        
        visited[node] = true;
        
        pathV[node] = true;
        
        for (Integer nb : adj.get(node)) {
            if (!visited[nb]) {
                if (cycle(nb, visited, pathV, adj)) {
                    return true;
                }
            } else if (pathV[nb]) {
                return true;
            }
        }
        
        pathV[node] = false;
        
        return false;
    }
    
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean[] visited = new boolean[V];
        
        boolean[] pathV = new boolean[V];
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (cycle(i, visited, pathV, adj)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
 */

/**
 * cycle in directed graph
 * can be done using topological sort - kahn's algorithm
 */