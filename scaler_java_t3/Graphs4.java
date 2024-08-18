class Graphs4{

    /**
     * Q. given a graph , generate an MST using it minimising the overall weight.
     * 
     * 2 approaches - prims (greedy + bfs)- start from any node ,to connect a new node - pick smallest edge 
     *                                      which doesnt form a cycle. stop when all nodes are visited. 
     *                kruskal (greedy + union find)- sort edges based on weight and select first (n-1) edges which
     *                                               do not form a cycle. stop when all components are connected.
     *                                               use of DISJOINT SETS
     *                                               UNION BY HEIGHT/RANK
     *                                               PATH COMPRESSION
     */
    public static void main(String[] args){
        
    }
}

/**
 * MINIMUM SPAN TREE (MST) : n-1 edges
 *                           0 cycles
 *                           single connected component
 */

/**
 * disjoint set union can be used in questions - kruskals algorithm.
 *                                               check wether there exists a cycle or not.
 *                                               given a graph and 2 nodes. check if there exists a path b/w them.
 */