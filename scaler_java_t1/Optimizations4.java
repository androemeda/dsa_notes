public class Optimizations4{

    //prefix sum
    public static int[] buildPrefixSum(int[] A){
        int[] B = new int[A.length] ;

        B[0] = A[0] ;

        for(int i=1 ; i<A.length ; i++){
            B[i] = B[i-1]+A[i] ;
        }
        return B;
    }



    //Q.given an array , return true if there exists a subarray whose sum equals to zero.
    //ex. A: {4,2,-3,1,6} : true --> 2,-3,1
    //ex. A:{2,0,4,2,1} :true --> 0
    //O(n^3) in brute force. --> iterate over all subarrays(n^2 --> check the sum(n))
    //O(n^2) in prefix sum.
    //O(n) if hash set also used.
    public static boolean checkSumEqual(int[] A){

        int[] B = buildPrefixSum(A);
        HashSet<Integer> set = new HashSet<Integer>();

        for(int i=0 ; i<B.length ; i++){
            if(set.contains(B[i])){
                return true;
            }else{
                set.add(B[i]);
            }
        }
        if(set.contains(0)){
            return true;
        }
        return false;
    }



    public static void main(String[] args){
        checkSumEqual(new int[] {4,-2,3,-1,2});
    }
}