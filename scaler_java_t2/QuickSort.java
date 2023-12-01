import java.util.*;
class QuickSort{

    public static int partition(int[] A , int s , int e){
        int lastElement = A[e];
        int j = s;
        for(int i=s ; i<e ; i++){
            if(A[i]<lastElement){
                swap(A, j , i);
                j++;
            }
        }
        swap(A , j , e);
        return j;
    }

    public static void swap(int[] A , int i , int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    /**
     * Q. given an array of size n, rearrange the array such that the last element of the array reaches its correct 
     * position in sorted order and all elements < last element  are on left side of it and all elements > last element 
     * are on rigth side of it. return the index.
     * Ex. 9 8 1 6 5 8 4 7
     *     1 6 5 4 7 8 9 8 (possible answer)
     * TC:O(N)
     * SC:O(1)
     * implement this for a given range in an array with indices s and e.
     */
    public static int reArrange(int[] A){
        int last_element = A[A.length-1];
        int j=0;
        for(int i=0 ; i<A.length ; i++){
            if(A[i]<last_element){
                swap(A , i , j);
                j++;
            }
        }
        // swap(A , j , A.length-1);
        return j;
    }

    /**
     * GOOGLE
     * key to the lock could be fit , loose or tight. there is one is to one matching between all keys and locks . 
     * the locks and keys cannot be differentiated among themselves just by looking at them.
     * just a puzzle , no coding. solve using reArrange() logic.
     * worst case TC: O(n^2) . for this you have to be extremely unlucky.
     * best case TC: O(nlogn)
     */

    /**
     * QUICK SORT
     * worst case TC: n^2 (for sorted arrays)
     * best case TC: nlogn (actually nlogn+n to be exact)
     * average TC: nlogn
     * recursion always comes with some space complexity
     * worst SC: O(n) 
     * best SC: O(logN)
     */
    public static void quickSort(int[] A , int s , int e){
        if(s>=e) return ;
        int p = partition(A , s , e);
        quickSort(A , s , p-1);
        quickSort(A , p+1 , e);
    }

    public static void main(String[] args){
        int[] arr = {9,8,1,6,5,8,4,7};

        // System.out.println(reArrange(arr));
        // System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.toString(arr));
        quickSort(arr , 0 , arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}