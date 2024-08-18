class DynamicProgramming4{

    /**
     * GOOGLE
     * Q. given n wines . each year you can sell either the left most or the right most wine. price of wine increases over time (Pi * y). calculate maximum profit from selling all wines.
     * Ex : 2,4,6,2,5 : ans = 64 (2*1 + 5*2 + 2*3 + 4*4 + 6*5)
     * 
     * in iterative approach you will have to iterate diagonally.
     */
    public static int sellWines(int[] wines , int s , int e , int year , Integer[][] dp){
        if(year == wines.length+1) return 0;
        if(s>e) return 0;
        if(s == e) return wines[s]*year;

        int ans = 0;

        int option1 = 0;
        int option2 = 0;

        if(dp[s][year] != null) option1 = dp[s][year];
        else{ option1 = wines[s]*year + sellWines(wines , s+1 , e , year+1 , dp); dp[s][year] = option1 ;}

        if(dp[e][year] != null) option2 = dp[e][year];
        else{ option2 = wines[e]*year + sellWines(wines , s , e-1 , year+1 , dp); dp[e][year] = option2 ;}

        ans = Math.max(option1 , option2);

        return ans;
    }

    /**
     * Q. 0/1 KnapSack ************************
     *    given n items each with a weight and a value. find the maximum value that can be obtained by picking items such that total weight <= max capacity of sack(k)
     *    every item can be picked at max once.
     *    taking an item partially is not allowed.
     * 
     * Ex: k=50
     *     w[] = 20 , 10 , 30 , 40
     *     v[] = 100, 60 , 120, 150
     *     ans = 220 (100 + 120)
     * 
     * there would be n*(k+1) unique function calls , but a normal recursive function makes 2^n calls ==> there are duplicate calls being made. hence got to use dp.
     * 
     * TC:O(N*K) (psuedo-polynomial TC) --> how can we solve if value of k is very large (matrix cant be created in that case!!).
     * 
     * determine dp dimensions from the number of independant variable and fill values starting from the base case.
     */

    /**
     * Q. COIN CHANGE PROBLEM
     *    given n coins and a sum k, find the number of ways to form the sum k if a coin can be picked at max once.
     * Ex: 7,4,9,6,11,5,13,8 : k=22
     */

    /**
     * Q. 0/Infinite KnapSack
     * given n items each with a weight and a value. find the maximum value that can be obtained by picking items such that total weight <= max capacity of sack(k)
     *    every item can be picked as many times as wanted.
     *    taking an item partially is not allowed.
     */

    /**
     * Q. EQUAL ARRAY PARTITIONING.
     *    given an array , count the number of ways to partition all elements into 2 sets of equal sum.
     * Ex: A = {1,5,3,6,9,2} : ans = 1 : {1,3,9} , {5,6,2}
     * 
     * count number of subsequences with sum as totalSum/2.
     * 
     * 
     * follow up question - partition array in 2 sub-sequences with minimum difference.
     */

    public static void main(String[] args){

        int[] wines = {2,4,6,2,5};
        Integer[][] dp = new Integer[wines.length][wines.length];
        int ans = sellWines(wines , 0 , wines.length-1 , 1 , dp);
        System.out.println(ans);
    }
}