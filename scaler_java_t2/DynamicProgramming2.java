class DynamicProgramming2{

    /**
     * Q. DECODE WAYS
     * 
     * leetcode 91
     */

    /**
     * till now all the questions had only one variable , hence we needed 1D array. these were 1D-DP questions.
     * now we will do 2D-DP.
     */

    /**
     * Q. given a 2d matrix of size n*m. count the number of paths from (0,0) to (n-1,m-1).
     *    from any cell you can either move right or down.
     * 
     * DP[i][j] --> number of paths from (i,j) to (n-1,m-1) --> it is like function definition in recursive calls
     * 
     * iterative approach : start thinking from base case
     *                      if it is last column or last row then answer is 1(base case)
     * fill all cells in last row and last column with 1.
     * then every cells there-after will have value of sum of its adjacent cells on right and below.
     * answer is stored in last cell.
     * can also fill other way round.
     * 
     * permutation-combination approach: any pnc of m-downs and n-rights will work.
     * this approach wont work if any of the cells are blocked.
     */

    /**
     * Q. MIN PATH SUM
     * 
     * minPath(A , i , j) --> min path sum from (i,j) to  (n-1 ,m-1)
     * 
     * minPath(A,i,j) = A[i][j] + min(minPath(A,i+1,j),minPath(A,i,j+1))
     * 
     * follow up question - MAX PATH SUM
     *                      MAX/MIN PATH SUM IN TRIANGLE
     */

    /**
     * Q. LARGEST COMMON SUB-SEQUENCE (LCS)
     * given 2 strings . find the length of largest common sub-sequence between the strings.
     * 
     * Ex: s1 : aggtab
     *     s2 : gxtnayb
     *     ans : 4 (gtab)
     * 
     * Ex: s1 : democrat
     *     s2 : republican
     *     ans : 3 (eca)
     * 
     * Ex: s1 : carthorse
     *     s2 : orchestra
     *     ans : 3
     * 
     * Ex: s1 : abc
     *     s2 : cba
     *     ans : 1
     * 
     * Ex : s1 : abc
     *      s2 : xyz
     *      ans : 0
     * 
     * TC without dp = O(2^nm)
     * TC with dp = O(mn)
     */

    /**
     * Q. EDIT DISTANCE
     * given 2 strings Sa abd Sb . convert Sa to Sb by using any of the following operations.
     * insert / delete / update a character from Sa
     * count minimum number of operations.
     * 
     * Ex: sa : ac
     *     sb : abc
     *     ans : 1 (insert b between a and c)
     * 
     * Ex: sa : horse
     *     sb : ros
     *     ans : 3 (horse --> rorse --> rose --> ros)
     */

    public static void main(String[] args){

    }
}
/**
 * string+dp
 * take 2 pointers , check the characters : if equal make one call
 *                                          if unequal make another call
 */