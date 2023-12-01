import java.util.*;

class BitM2{

    /**
     * Q. given an array of positive numbers. every element appears 2 times except 2 elements which appear exactly once. 
     *    return the elements in an array which occur once.
     * sorting: TC: O(nlogn) SC:O(logn)
     * hashmap: TC: O(n) SC:O(n)
     * bitM: TC: O(n) SC:O(1)
     * Ex. A: 3,6,4,4,6,8 --> 3,8
     *     A: 4,9,7,9 --> 4,7
     *     A: 1,2 --> 1,2
     */
    public static int[] singleElements(int[] A){
        int aXORb = 0;
        int setXor = 0;
        int unsetXor = 0;
        int setIndex = 0;
        for(int i=0 ; i<A.length ; i++){     //TC: O(n)
            aXORb ^= A[i];
        }
        for(int i=0 ; i<32 ; i++){            // TC: O(logMAX_OF_THAT_DATATYPE)
            if(setUnsetRS(aXORb , i)){
                setIndex = i;
                break;
            }
        }
        for(int i=0 ; i<A.length ; i++){      //TC: O(n)
            if(setUnsetRS(A[i] , setIndex)){
                setXor ^= A[i];
            }else{
                unsetXor ^= A[i];
            }
        }
        int[] ans = {setXor , unsetXor};
        return ans;
    }

    public static boolean setUnsetRS(int n , int i){
        return (((n>>i)&1)==1);
    }

    /**
     * GOOGLE
     * Q. given an array where all elements appear thrice except one element which appears exactly once. find the single 
     * element.
     * constraints : SC should be O(1) and cant make any changes to the array.
     * Ex: 2,2,2,5,7,5,7,11,11,9,11,7,5 --> 9
     */
    public static int solve(int[] A){
        int ans = 0;
        for(int i=0 ; i<32 ; i++){             //TC: O(logMAX_VALUE_OF_DATATYPE)
            int count = 0;                     //count of set bits in ith position of all elements.
            for(int j=0 ; j<A.length ; j++){   //TC: O(n)
                if(setUnsetRS(A[j] , i)){
                    count++;
                }
            }
            if(count%3 != 0){
                //set the ith bit of ans.
                ans |= (1<<i);
            }
        }
        return ans;
    }

    /**
     * GOOGLE
     * HAMMING DISTANCE SUM
     * Q. given an array. for every pair of element in the array , return the sum of difference between bits of every pair of elements.
     * Ex: A: 3,5,6,8
     *     (0,1) --> 2
     *     (0,2) --> 2
     *     (0,3) --> 3
     *     (1,2) --> 2
     *     (1,3) --> 3
     *     (2,3) --> 3
     *     ans = 15.
     * brute force : TC: O(n^2logMAX)
     * will face challenge regarding overflow . will have to take mod properly.
     */
    public static int sumOfDiff(int[] A){

    }

    public static void main(String[] args){
        int[] arr = {3,6,4,4,6,8};
        int[] arr2 = {2,2,2,5,7,5,7,11,11,9,11,7,5};
        // System.out.println(Arrays.toString(singleElements(arr)));
        System.out.println(solve(arr2));
    }
}