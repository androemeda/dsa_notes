public class Matrices{

    static void matrixSum(int[][] matrix1 , int[][] matrix2){
        if(matrix1.length==matrix2.length && matrix1[0].length == matrix2[0].length){
            int[][] matrix3 = matrix1;
            for(int i=0 ; i<matrix1.length ; i++){
                for(int j=0 ; j<matrix1[0].length ; j++){
                    matrix3[i][j] = matrix1[i][j]+matrix2[i][j];
                    System.out.print(matrix3[i][j]+"\t");
                }
                System.out.println();
            }
            
        }else{
            throw new RuntimeException("everything is lie! illuminati!");
        }
    }

    static vid matrixPrint(int[][] matrix1 ,int[][] matrix2){
        int[][] matrix3 = new int[matrix1.length][matrix2[0].length];
        for(int = 0 ; i<matrix.length ; i++){
            for(int j=0 ; j<matrix2[0].length ; j++){
                matrix3[i][j] = 
            }
        }
    }


    public static void main(String[] args){
        matrixSum(new int[][] {{1,2,3},{4,5}} ,new int[][] {{1,2,3},{4,5,6}} );
    }
}