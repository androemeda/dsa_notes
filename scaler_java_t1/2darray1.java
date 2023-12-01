import java.util.ArrayList;
import java.util.Scanner;

public class Main {



    //Q.write a function to reverse a matrix.
    public static void reverse(int[][] A){
        for (int i = A.length-1; i >=0 ; i--) {
            for (int j = A[0].length-1; j >=0 ; j--) {
                System.out.print(A[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }




    //Q.write a function to print the index of row having largest sum. also print the sum.
    public static void maxRowIndex(int[][] A){
        int maxSum = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < A[0].length; j++) {
                rowSum += A[i][j];
            }
            if(rowSum>maxSum){
                maxSum=rowSum;
                index = i;
            }
        }
        System.out.println("index of row is: "+index);
        System.out.println("sum of elements is: "+maxSum);
    }



    //Q.write a function to print the sum of all elements.
    public static int sum(int[][] A){
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                sum += A[i][j];
            }
        }
        return sum;
    }



    //Q.write a function to print largest element of the matrix
    public static int maxElement(int[][] A){
        int max = A[0][0];
        int rows = A.length;
        int columns = A[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(A[i][j]>max){
                    max = A[i][j];
                }
            }
        }

        return max;
    }


    //Q. write a fumction to print matrix row by row
    public static void printMatrix(int[][] A){
        int rows = A.length;
        int columns = A[0].length;
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(A[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = 3;
        int columns = 3;
        int[][] matrix = new int[rows][columns];
        System.out.println("enter elements: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        printMatrix(matrix);
        reverse(matrix);
    }
}





/*HW --->  EXPLORE!
open image file
BufferedFile
ImageIO
 */
        