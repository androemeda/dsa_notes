public class prefixMatrix{


    public static int[][] buildPrefixSumMatrix(int[][] A){
        int[][] B = new int[A.length][A[0].length];
        B[0][0] = A[0][0] ;
        B[1][0] = A[1][0] ;
        B[2][0] = A[2][0] ;

        for(int i=0 ; i<A.length ; i++){
            for(int j=1 ; j<A[0].length ; j++){
                B[i][j] = A[i][j]+B[i][j-1] ;
            }
        }

        for(int j=0 ; j<A[0].length ; j++){
            for(int i=1 ; i<A.length ; i++){
                B[i][j] = B[i][j]+B[i-1][j];
            }
        }
        return B;
    }

    public static void main(String[] args){
        int[][] matrix = {{1,2,3},
                          {4,5,6},
                          {7,8,9}} ;
        int[][] ans =  buildPrefixSumMatrix(matrix);

        for(int i=0 ; i<ans.length ; i++){
            for(int j=0; j<ans[0].length ; j++){
                System.out.print(ans[i][j]+"\t");
            }
            System.out.println();
        }
        
    }
}