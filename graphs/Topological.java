/**
 * only for DIRECTED ACYCLIC GRAPH 
 * 
 * 
 * DFS
 * 
 * visited array + if not visited , call dfs(i) + push node to stack after visiting all neighbours
 * 
 * class Solution
{
    
    static void dfs(int src , ArrayList<ArrayList<Integer>> adj , boolean[] visited , Stack<Integer> st){
        
        visited[src] = true;
        
        for(Integer nb : adj.get(src)){
            if(!visited[nb]){
                dfs(nb , adj , visited , st);
            }
        }
        
        st.push(src);
    }
    
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        
        boolean[] visited = new boolean[V];
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=0 ; i<V ; i++){
            if(!visited[i]){
                dfs(i , adj , visited , st);
            }
        }
        
        int[] ans = new int[V];
        
        for(int i=0 ; i<V ; i++){
            ans[i] = st.pop();
        }
        
        return ans;
    }
}

 */

/**
 * 
 * BFS - KAHN'S ALGORITHM
 * 
 * indegree array + queue
 * 
 * class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        
        int[] indegree = new int[V];
        
        for(int i=0 ; i<adj.size() ; i++){
            for(Integer nb : adj.get(i)) indegree[nb]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0 ; i<V ; i++){
            if(indegree[i] == 0) q.add(i);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(!q.isEmpty()){
            
            int curr = q.remove();
            
            ans.add(curr);
            
            for(Integer nb : adj.get(curr)){
                indegree[nb]--;
                if(indegree[nb] == 0) q.add(nb);
            }
        }
        
        int[] ans2 = new int[V];
        
        for(int i=0 ; i<V ; i++){
            ans2[i] = ans.get(i);
        }
        
        return ans2;
    }
}
 */

/**
 * 
 * cycle detection in directed graph
 * 
 * topo sort has n elements => DAG
 * 
 * topo sort having less than n elements => cycle present 
 */

/**
 * 
 * ALIEN DICTIONARY
 */

/**
 * SHORTEST PATH IN DIRECTED ACYCLIC GRAPH (weighted edges)
 * 
 * 1. do topo sort
 * 2. take nodes out of stack and relax edges (make a distance  array with infinites and make source node zero )
 */

/**
 * 
 * SHORTEST PATH IN UNDIRECTED GRAPH WITH UNIT WEIGHTS
 */