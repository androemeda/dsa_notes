class BitM3{

    /**
     * Q. given an array of positive integers. find the pair with minimum XOR value.
     * Ex: 7,3,11,10,6,2,3
     *     ans = 0 : 3^3
     * Ex: 9,5,3
     *     ans = 6 : 5^3
     * Ex: 5,4,1,2,3
     *     ans = 1 : 2^3 or 5^4
     * 
     * you will get min xor when most significant bit is same.
     * 
     * sort the array and check xor of all consecutive elements.
     * 
     * TC:O(nlogn) SC: depends on the sorting algorithm we are using.
     */
    public static int[] minXor(int[] A){
        return [-1,-1];
    }

    /**
     * GOOGLE
     * Q. given an array of positive numbers. return the max '&' value of any pair i.e. return (A[i]&A[j]) (i!=j)
     * Ex: A = 27,18,20
     *     27&18=18 , 27&20=16 , 18&20=16 : ans=18
     * Ex: A = 26,13,23,28,27,7,25
     */

    /**
     * Q. given an array , print all sub-sequences of the array.
     * Ex: A = 2,3,1
     *     ans = {},{2},{2,3},{2,1},{2,3,1},{3},{3,1},{1}
     */
    public static void main(String[] args){

    }
}


