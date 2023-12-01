
public class Optimizations2{

    //print array.
    public static void printArray(int[] A){
        for(int i=0 ; i<A.length ; i++){
            System.out.print(A[i]+" ");
        }
        System.out.println();
    }

    /*
    given an array of n elements, return the total count of equilibrium index.
    equillibrium => sum of all elements on left is equal to sum of all elements is right.
    Ex: 0[1,2,3,5,1,5]0 --> 3 is eq index . hence , ans = 1.
    */

    // build PS: O(N) then count eq index : O(N) => overall TC:O(N) . SC:O(N).
    public static int countEquillibriumIndices(int[] A){
        int count = 0;
        //compare summation of all elements fro 0 to i-1 with summation of elements from i+1 to n-1. use prefix sum method.
        return count;
    }

    /*
    given an array of n elements and q queries. for each query, given L and R.
    calculate and print the number of even numbers in given range i.e. [L,R] .
    ex: arr = {4,2,3,5,2,7,6}
        1,2 => 1
        2,6 => 2
    */
    public static void printEvenInRange(int[] A , int[][] Queries){
        //PS[i] => sum of all even elements from 0 to i
        //PS[0]=0 if P[0] is odd , else 1.
        //if A[i]-->even
        //PS[i] = PS[i-1]+1
    }

    //write a function to return the prefix sum array of a given array.
    public static int[] buildPrefixSum_Optimal(int[] A){
        int[] PS = new int[A.length];
        PS[0] = A[0];
        for(int i=1 ; i<A.length ; i++){
            PS[i] = A[i]+PS[i-1];
        }
        return PS;
    }

    /*
    given an array of n elements and Q queries.
    for each query given L and R,
    calculate and print the sum of all elements in the range [L,R]
               0,1,2,3,4,5,6,7
    EX: arr = {2,3,5,1,3,5,6,9}
    Q:3 L,R
    i: [1,5] => 17
    i: [3,4] => 4
    i: [5,5] => 5
    */

    //unoptimized. TC:O(N*Q) . SC:O(1) .
    public static void rangeSumQueries(int[] A , int[][] Queries){
        int t = 0;
        while(t<Queries.length){

            int sum=0;
            int L = Queries[t][0];
            int R = Queries[t][1];

            for(int i=L ; i<=R ; i++){
                sum += A[i] ;
            }
            System.out.println(sum);
            t++;
        }
    }

    //optimized. --> build PS(O(N)) then solve for Q queries. TC:O(N+Q)

    public static void main(String[] args){


        // int[] A = {2,3,5,1,3,5,6,9};
        // int[][] Queries = {{1,5},{3,4},{5,5},{4,6},{0,4}};
        // rangeSumQueries(A , Queries);

        int[] arr = {1,2,3,5,1,5};
        System.out.println(countEquillibriumIndices(arr));


    }
}

//rangeSumQueries--->PrefixSum.