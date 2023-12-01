class BitM1{

    /**
     * Q.write a code to do addition in binary
     */

    /**
     * AMAZON,MS,ADOBE,OYO,OLA
     * Q. given an array where all the numbers appear even number of times, except one number which 
     * appears odd number of times. find the number appearing odd number of times.
     * Ex: A: 2,7,3,6,2,2,3,2,7,6,6,7,7,1,1 : ans=6
     * TC:O(N) SC:O(1)
     * if hashset is used , SC would be O(n).
     */
    public static int oddFrequency(int[] A){
        int ans = 0;
        for(int i=0 ; i<A.length ; i++){
            ans ^= A[i];
        }
        return ans;
    }

    /**
     * Q. given a positive number n and a 
     *    position i. check if the ith position 
     *    bit in n is set or unset. set=1 unset=0. return true if set, else false.
     * Ex: n=21 , i=2 : ans=true 
     * Ex: n=34 , i=3 : ans=false
     */
    public static boolean setUnsetRS(int n , int i){
        return (((n>>i)&1)==1);
    }

    public static boolean setUnsetLS(int n , int i){
        return ((n & (1 << i)) > 0);
    }

    /**
     * Q. given a +ve number , return the number of set bits in it.
     */
    public static int numSetBits(int A) {
        int count = 0;
        while(A>0){
            count += A&1;
            A=A>>1; 
        }
        return count;
    }

    public static void main(String[] args){
        
        // int[] arr = {2,7,3,6,2,2,3,2,7,6,6,7,7,1,1};
        // System.out.println(oddFrequency(arr));

        System.out.println(setUnsetRS(34 , 3));
    }
}

/**
 * TC of converting a number N to binary = logN
 */

    // public static int set(int n , int i){
    //     return n^((int)Math.pow(2,i));
    // }
    // public static int unSet(int n , int i){
    //     int A=1;
    //     A<<=i;
    //     return A^n;
    // }