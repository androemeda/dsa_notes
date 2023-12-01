class BitM4{

    /**
     * Q. given an array , find the cumulative OR of OR of all possible sub-arrays.
     * Ex: A = 1,2,3
     *     1 -->1
     *     1,2 --> 3
     *     1,2,3 --> 3
     *     2 --> 2
     *     2,3 --> 3
     *     3 --> 3
     *     ans = 1|3|3|2|3|3 = 3
     * 
     * just take the or of all elements in the array.
     */
    public static int cumulativeOr(int[] A){
        int ans = 0;
        for(int i=0 ; i<A.length ; i++){
            ans |= A[i];
        }
        return ans;
    }

    /**
     * Q. given an array , find the cumulative AND of AND of all possible sub-arrays.
     * 
     * same as 'OR'. just take AND of all elements.
     */

    /**
     * Q. given an array , find the cumulative sum of OR of all possible sub-arrays.
     * (will need contribution technique)
     */

    /**
     * Q. divide 2 numbers without using *,/,% operators. return the quotient. (A/B)
     */
    public static int division(int a , int b){
        int ans = 0;
        long A = a;
        long B = b;
        for(int i=31 ; i>=0 ; i--){
            if((B<<i)<=A){
                ans |= (1<<i);
                A = A - (B<<i) ;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        System.out.println(division(9,2));
    }
}

/**
 * REVISE
 * implement power function which takes 3 inputs a,N,M and returns (a^N)%M.
 */

/**
 * HW
 * find the limit of double data-type by keep adding 1 to it.
 * find out how it is possible to store such a large value in just 64 bits.
 */