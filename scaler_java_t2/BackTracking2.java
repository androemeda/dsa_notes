class BackTracking2{

    /**
     * Q. Given a number n. generate all valid parenthesis sequence of size 2n.
     */

    /**
     * Q. RAT IN A MAZE 
     * Given : 2d matrix
     *         position of rat (x,y)
     *         position of cheese (a,b)
     *         A[i][j] == 1 --> blocked
     *         A[i][j] == 0 --> open
     * Return true if there exists a path from rat to the cheese
     * 
     * TC : O(N*M) because after blocking a cell , we cannot revisit it . so we visit each cell only once.
     */

    /**
     * GOOGLE
     * Q. RAT IN MAZE - 2
     * Given : start point of rat (ri , rj)
     *         end point of rat (ei , ej)
     *         cells with cheese (A[i][j] == 0)
     *         blocked cells (A[i][j] == 1)
     *         empty cells (A[i][j] == 2)
     * count number of paths from (ri,rj) to (ei,ej) such that the rat can eat all the cheeze in the maze.
     * 
     * count number of cheese and then solve same as previous question while keeping track of count of cheese encountered in the path
     */

    public static void main(String[] args){

    }
}