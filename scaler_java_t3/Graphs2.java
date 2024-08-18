class Graphs{

    /**
     * Q. NUMBER OF ISLANDS
     *    given a matrix of 0's and 1's. 
     *    0 represents water.
     *    1 represents land.
     *    count the number of islands. anything outside matrix can be treated as water.
     * Ex: 11001
     *     01010
     *     10011
     *     11000
     *     10111 : ans = 5.
     */

    /**
     * Q. given a map of conflicted area between 2 countries I and P.
     *    I will take back all the land which is completely surrounded by I. 
     *    return the final state of the map.
     */

    /**
     * Q. given an undirected graph , check if there exists a cycle in the graph.
     * 
     * approach1 : if next node is not a parent node but still visited => cycle exists.
     * 
     * approach2 : in a tree, if there are n nodes, there would be exactly n-1 edges --> apply this logic for each connected component.
     * 
     * approach3 : if there are n nodes and k connected components, number of edges such that there is no cycle present in the graph is : n-k
     */
    public static void main(String[] args){

    }
}

/**
 * in a tree, if there are n nodes, there would be exactly n-1 edges.
 */