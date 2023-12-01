import java.util.*;

public class MatrixBlurr{

    static void printMatrix(int[][] A){
        for(int i=0 ; i<A.length ; i++){
            for(int j=0 ; j<A[i].length ; j++){
                System.out.print(A[i][j]+"\t");
            }
            System.out.println();
        }
    }

    static int[][] blurrMatrix(int[][] A , int pixelCount){

        int rowStart=0;
        int rowEnd = pixelCount-1; 

        while(rowEnd < A.length){

            int columnStart=0;
            int columnEnd = pixelCount-1;

            while(columnEnd<A[0].length){

                int sum = 0;
                for(int i= rowStart ; i<=rowEnd ; i++){
                    for(int j=columnStart ; j<=columnEnd ; j++){
                        sum += A[i][j];
                    }
                }
        
                for(int i= rowStart ; i<=rowEnd ; i++){
                    for(int j=columnStart ; j<=columnEnd ; j++){
                        A[i][j] = sum/(pixelCount*pixelCount);
                    }
                }

                columnStart+=pixelCount;
                columnEnd+=pixelCount;
            }

            rowStart+=pixelCount;
            rowEnd+=pixelCount;
        }
        return A;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int columns = sc.nextInt();

        int[][] matrix = new int[rows][columns];

        for(int i=0 ; i<rows ; i++){
            for(int j=0 ; j<columns ; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        printMatrix(matrix);
        System.out.println("\n");
        printMatrix(blurrMatrix(matrix , 2));


    }
}