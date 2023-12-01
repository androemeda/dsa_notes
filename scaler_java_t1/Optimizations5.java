public class Optimizations5{

    //Q. return sum of all sub-arrays of a given array.
    public static int sumOfAllSubArrays(int[] A){
        int ans = 0;
        int n = A.length;
        for(int i=0 ; i<n ; i++){
            int contribution = (i+1)*(n-i)*A[i];
            ans += contribution;
        }
        return ans;
    }
    /**
     * O(N^3)-->BRUTE FORCE
     * O(N^2)-->USE PREFIX-SUM
     * NUMBER OF SUBARRAYS ARE O(N^2) , SO ITERATING OVER ALL SUBARRS WILL GIVE N^2 TC.
     * SO WE NEED TO ITERATE OVER ELEMENTS TO GET N TC.
     */


    //HW--> given a matrix , find summation of all possible sub-matrices. O(N^2)

    /**
     * Q.given an array of 0's of size n
     * there are Q queries having index and a value.
     * add the value to all the indices greater than or equal to thr given index.
     * 
     * [0,0,0,0,0,0,0,0]
     * Q:5
     * i    v
     * 5    1   [0,0,0,0,0,1,1,1]
     * 6    3   [0,0,0,0,0,1,4,4]
     * 1    5   [0,5,5,5,5,6,9,9]
     * 3    -1  [0,5,5,4,4,5,8,8]
     * 0    1   [1,6,6,5,5,6,9,9]
     * 
     * brute force--> N*Q
     * 
     * 
     * ---GOOGLE VARIATION---
     * in every query we have a start and end index along with the value.
     * add the value to all the elements in the range from start to end.
     * return the final state of the array.
     */
    // public static int[] addToArray(int[] A , int[][] Q){

    // }

    //return row-wise prefix sum matrix
    public static int[][] rowPrefixSum(int[][] A){
        int[][] rowPS = new int[A.length][A[0].length];
        for(int i=0 ; i<A.length ; i++){
            rowPS[i][0] = A[i][0] ;
            for(int j=1 ; j<A[0].length ; j++){
                rowPS[i][j] = A[i][j]+rowPS[i][j-1] ;
            }
        }
        return rowPS;
    }

    //return column prefix sum.
    public static int[][] colPrefixSum(int[][] A){
        int[][] colPS = new int[A.length][A[0].length] ;
        for(int j=0 ; j<A[0].length ; j++){
            colPS[0][j] = A[0][j] ;
        }
        for(int i=1 ; i<A.length ; i++){
            for(int j=0 ; j<A[0].length ; j++){
                colPS[i][j] = A[i][j] + colPS[i-1][j] ;
            }
        }
        return colPS ;
    }

    public static void printMatrix(int[][] A){
        for(int i=0 ; i<A.length ; i++){
            for(int j=0 ; j<A[i].length ; j++){
                System.out.print(A[i][j]+"\t");
            }
            System.out.println();
        }
    }

    //prefixSumMatrix
    public static int[][] buildPrefixSumMatrix(int[][] A){
        int[][] PS = rowPrefixSum(A);
        PS = colPrefixSum(PS) ;
        return PS;
    }

    //Q.implement a function to return sum of a sub-matrix.
    //possible time complexities: QN^2(brute force) , Q+N(build prefix matrix)
    //THIS IS QN^2.
    public static int sumOfSubMatrix(int[][] A , int rowStart , int rowEnd , int colStart , int colEnd){
        int sum=0;
        for(int i=rowStart ; i<=rowEnd ; i++){
            for(int j=colStart ; j<=colEnd ; j++){
                sum += A[i][j] ;
            }
        }
        return sum ;
    }

    public static int sumOfSubMatrix_optimized(int[][] A , int rowStart , int rowEnd , int colStart , int colEnd){
        int sum=0;
        //(i,j)-->(p,q) ==>> SUM = PS[p][q]-PS[i-1][q]-PS[p][j-1]+PS[i-1][j-1] : check for edge cases where i,j,p,q could be zero.
        //SC: O(N^2)
        return sum;

    }

    //given an array , return the maximum subarray sum. possible TC: n^3 , n^2 , n.
    //Ex: A: 2,5,-10,4,8,-1,5,-14,-20,0 --> 16 is maximum possible sum of a subarray.
    // public static int maxSumOfSubArray(int[] A){
    //     int ans = Integer.MIN_VALUE;
//
//    }

    public static void main(String[] args){

        // int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}} ;
        // printMatrix(matrix) ;
        // System.out.println(sumOfSubMatrix(matrix , 0 , 1 , 1 , 2));
        System.out.println(sumOfAllSubArrays(new int[] {1,2,3}));
    }
}