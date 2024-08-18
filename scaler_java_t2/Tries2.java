public class Tries2 {

    /**
     * Q. given a 2d matrixx of 0's and 1's. count the number of distinct rows.
     * Ex: 10010
     *     01010
     *     11011
     *     11001
     *     11011
     *     10010
     *     10101
     *     00110 : ans = 6
     */

    /**
     * Q. given an array of integers . find the pair with maximum XOR. (we had earlier solved question in which we had to find pair with minimum XOR (solved using sorting the array)) : TC : O(NlogM) (M -> max value of data-type)
     * Ex: 4,3,2,7 : ans = 4^3 = 7
     */

    /**
     * Q. given an array. find the maximum XOR of any sub-array.
     * Ex: 8,1,2,12,7,6 : ans = 1^2^12 = 15
     * 
     * brute-force : TC:O(n^3) : iterate over all sub-arrays. (there are n(n+1)/2 sub-arrays)
     * sliding-window(keeping length of a sub-array(window) fixed at a time) :  TC : O(n^2)
     * prefix-XOR array : XOR[L-R] = XPs[R]^XPs[L-1] then apply previous solution! : TC : O(NlogM) (M -> max value of data-type)
     */
    
    public static void main(String[] args) {
        
    }
}

/**
 * revise sliding window technique.
 */

/**
 * "prefix-sum" should come to your mind whenever you see "sub-array".
 */