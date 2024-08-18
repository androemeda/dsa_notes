class Graphs3{

    /**
     * Q. given a graph, find its chromatic number.
     * 
     * backtracking
     * 
     * same as to sudoku solver.
     */

    /**
     * Q. given a graph, check if there exists a cycle with odd number of nodes.
     */

    /**
     * Q. check if a graph is bipartite or not.
     * 
     * approach 1 : cn = 2
     * 
     * if graph is connected and undirected : 
     *      graph is acyclic => it is a tree => bipartite
     *      graph is cyclic : cycle exists with odd number of nodes => false
     *                        no cycle exists with odd number of nodes => true
     */

    /**
     * GOOGLE
     * Q. given a tree , return the max number of edges that can be added to the tree such that 
     *    the resulting graph is still bipartite. 
     * 
     * ans = (c1 * c2) - (n-1)
     */

    /**
     * UBER
     * Q. EXTROVERTS DOING PARTY
     *    only the people who can bring at least k friends can join the party. count the number of attendees.
     * 
     * Ex: person friends
     *      1       2,6
     *      2       1,3,4
     *      3       2,4
     *      4       3,5,2
     *      5       4
     *      6       1
     * ans = 3 : (2,3,4 can join the party)
     * 
     * find all nodes with degree less than k . add them in queue . perform multi-source bfs. mantain a degree map.
     */

    /**
     * Q. given a graph, generate any of the topological sorted order.
     * 
     * to sort topologically --> no cycle should be present.
     *                           it should be a directed graph.
     *                           it may/may not be connected.
     */

    /**
     * Q. PETROL BUNKS
     */

    public static void main(String[] args){

    }
}
/**
 * minimum number of colors to paint a planar graph such that no 2 adjacent cells have same color = 4. 
 * this was the first theorum based completely on computational proof.
 * 
 * chromatic number : minimum number of colors needed to paint all vertices such that no 2 adjacent vertices have same color.
 * 
 * max chromatic number of binary tree = 2
 * 
 * an undirected connected graph with chromatic number 2 is a tree : FALSE
 * 
 * ring / cyclic graph : cn = 2 , if n = even
 *                       cn = 3 , if n = odd
 * 
 * bi-partite graphs => cn = 2 && cn = 2 => bi-partite graph
 */