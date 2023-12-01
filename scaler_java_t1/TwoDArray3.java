import java.lang.*;
import java.util.*;

public class TwoDArray3 {

    //Q. print transpose of a rectangular matrix.
    static void printRectTranspose(int[][] A){
        int[][] ans = new int[A[0].length][A.length];

        for(int i=0 ; i<A[0].length ; i++){
            for(int j=0 ; j<A.length ; j++){
                ans[i][j] = A[j][i];
            }
        }
        for(int i=0 ; i<A[0].length ; i++){
            for(int j=0 ; j<A.length ; j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }

    

    //Q. given starting element , print the diagonal of the matrix.
    static void printDiagonalFromStartingEl(int[][] A , int rowNo , int colNo){
        
        while(rowNo<A.length && colNo<A[0].length){
            System.out.print(A[rowNo][colNo]+" ");
            rowNo++;
            colNo++;
        }
    }

    //Q. print diagonal of a matrix.
    static void printDiagonal(int[][] A){
        for (int i = 0; i < A.length; i++) {
                    System.out.print(A[i][i]+" ");
        }
        System.out.println();
    }

    //Q. print other diagonal
    static void printOtherDiagonal(int[][]  A){
//        for (int i = 0; i < A.length; i++) {
//            System.out.print(A[i][A.length-i-1]+" ");
//        }
//        System.out.println();

        int i=0 , j=A.length-1;
        while(i<=A.length-1 && j>=0){
            System.out.print(A[i][j]+" ");
            i++;
            j--;
        }
        System.out.println();
    }


    //Q. convert a matrix to its transpose. dont create a new matrix.(square matrix given)
    static void printTranspose(int[][] A){
        for (int i = 0; i < A.length; i++) {
            for (int j = i+1; j < A[i].length; j++) {
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
                //System.out.print(A[i][j]+"\t");
            }
            //System.out.println();
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.print(A[i][j]+"\t");
            }
            System.out.println();
        }
    }


    //Q. rotate a matrix by 90 degrees.(take transpose and reverse it).


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);                        //1 2 3
        //printDiagonal(new int[][]{{1,2,3},{4,5,6},{7,8,9}});        //4 5 6
        //printOtherDiagonal(new int[][]{{1,2,3},{4,5,6},{7,8,9}});   //7 8 9
        // printTranspose(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        //printDiagonalFromStartingEl((new int[][]{{1,2,3},{4,5,6},{7,8,9}}) , 2 , 2);
        printRectTranspose(new int[][]{{1,2,3},{4,5,6},{7,8,9},{1,2,3}});
    }
}
