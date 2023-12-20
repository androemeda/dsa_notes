import java.util.Arrays;

public class Sorting3{

    //Given 2 sorted arrays, merge them into single sorted array. TC(O(A+B))
    public static int[] merge2SortedArrays(int[] A , int[] B){
        int[] mergedArray = new int[A.length+B.length];

        int i=0;
        int j=0;
        int k=0;

        while(i<A.length && j<B.length){
            if(A[i]<B[j]){
                mergedArray[k] = A[i];
                i++;
            }else{
                mergedArray[k] = B[j];
                j++;
            }
            k++;
        }

        while(i<A.length){
            mergedArray[k] = A[i] ;
            i++;
            k++;
        }
        while(j<B.length){
            mergedArray[k] = B[j] ;
            j++;
            k++;
        }

        return mergedArray;
    }

    public static void merge2SortedArraysInPlace(int[] A , int s , int m , int e){
        int[] mergedArray = new int[e-s+1];

        int i=s;
        int j=m+1;
        int k=0;
        while(i<=m && j<=e){
            if(A[i]<A[j]){
                mergedArray[k] = A[i];
                i++;
            }else{
                mergedArray[k] = A[j];
                j++;
            }
            k++;
        }

        while(i<=m){
            mergedArray[k] = A[i] ;
            i++;
            k++;
        }
        while(j<=e){
            mergedArray[k] = A[j] ;
            j++;
            k++;
        }

        for(int l=0 ; l<mergedArray.length ; l++){
            A[s+l] = mergedArray[l];
        }
    }

    /**
    * MERGE SORT
     * At every level , n elements are being merged.
     * there are total log_2N levels.
     * TC:O(NlogN)
     * SC: maximum height of the tree. --> O(N) (auxiliary space)
     */
    public static int[] mergeSort(int[] A){

        if(A.length==1) return A;

        int mid = A.length/2;

        int[] start = mergeSort(Arrays.copyOfRange(A , 0 , mid));
        int[] end = mergeSort(Arrays.copyOfRange(A , mid , A.length));

        return merge2SortedArrays(start , end);
    }

    public static void mergeSortInPlace(int[] A , int s , int e){
        if(s==e) return;
        int mid = (s+e)/2;
        mergeSortInPlace(A , s , mid);
        mergeSortInPlace(A , mid+1 , e);
        merge2SortedArraysInPlace(A , s , mid , e);
    }

    public static void main(String[] args){ 
        int[] arr = {5,4,3,2,1,0,-1};
        mergeSortInPlace(arr , 0 , arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
} 
















































































// public class Sorting3{

//     public static void printArray(int[] A){
//         for(int i=0 ; i<A.length ; i++){
//             System.out.print(A[i]+" ");
//         }
//         System.out.println();
//     }

//     public static void mergeSort(int[] A , int s , int e){
//         if(s==e) return;

//         int mid = (s+e)/2;
//         mergeSort(A , s , mid);
//         mergeSort(A , mid+1 , e);
//         // mergeSortedArrays();
//     }

//     /**
//      * given an array and 3 indices l,m,r.
//      * given that subarray from l to m is sorted and that from m+1 to r is also sorted.
//      * sort the subarray from l to r.
//      * Ex: 8,1,3,6,11,2,4,9,7,6 --> l=2 , m=4 , r=7
//      *   : 8,1,2,3,4,6,9,11,7,6 --> sorting from 2 to 7
//      * TC: O(N)
//      * SC: O(N)
//      */
//     public static void solve(int[] A , int l , int m , int r){
//         int[] C = new int[r-l+1] ;
//         int i=l , j=m+1 , k=0 ;
//         while(i<=m && j<=r){
//             if(A[i]<A[j]){
//                 C[k]=A[i];
//                 i++;
//             }else{
//                 C[k]=A[j];
//                 j++;
//             }
//             k++;
//         }
//         while(i<=m){
//             C[k]=A[i];
//             i++;
//             k++;
//         }
//         while(j<=r){
//             C[k]=A[j];
//             j++;
//             k++;
//         }
//         // for(int i=0 ; i<)
//     }
//     public static void main(String[] args){
//         int[] arr = {2,5,8,6,3,1,5,2};
//         printArray(arr);
//         mergeSort(arr , 0 , arr.length-1);
//         printArray(arr);
//     }
// }

// //IMPLEMENT YOUR OWN TIM SORT.