import java.util.*;
class DynamicProgramming1{

    /**
     * Q. nth fibonacci number.
     * without dp : TC:O(2^N) SC:O(N)
     * with dp : TC:O(N) SC:(N)
     * with iterations : TC:O(N) SC:O(1) (this is also dp) (bottom-up dp)
     * 
     * this is top-down dp / memoization
     */
    public static int fib(int n , int[] arr){
        if(arr[n] == -1){
            if(n <= 1){
                arr[n] = n;
            }
            else{
                arr[n] = fib(n-1 , arr) + fib(n-2 , arr);
            }
        }
        return arr[n];
    }

    /**
     * Q. given n stairs. from any ith stair , you can either go to (i+1)th step or (i+2)th step.
     *    count the number of ways of reaching the nth step from the 0th step.
     * Ex: n=0 : ans=0
     * Ex: n=1 : ans=1
     * Ex: n=2 : ans=2
     * Ex: n=3 : ans=3
     * Ex: n=5 : ans=8
     * 
     * leetcode 70
     * 
     * this is same as fibonacci series question
     */

    /**
     * Q.given an array of positive numbers . return the max sum without any adjacent elements being added.
     * 
     * leetcode 198
     */

    public static void main(String[] args){

        int[] arr = new int[10];
        Arrays.fill(arr , -1);
        System.out.println(fib(9 , arr));
    }
}

/**
 * all recursive codes are depth-first-search
 * 
 * all things which use previous information to save time are dp.
 * 
 * prefix-sum is also dp
 * 
 * dp questions could be done using both recursion and iterations.
 * recursive approaches use more space due to stack usage.
 */