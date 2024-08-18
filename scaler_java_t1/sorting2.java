import java.util.Arrays;

public class sorting2{
    
    public static int getMinIndex(int[] arr , int firstIndex , int lastIndex){
        int minIndex = firstIndex;
        int min = arr[firstIndex];
        for(int i=firstIndex ; i<=lastIndex ; i++){
            if(arr[i]<min){
                min=arr[i];
                minIndex=i;
            }
        }
        return minIndex;
    }

    public static void swap(int[] arr , int index1 , int index2){
        int temp = arr[index1] ;
        arr[index1] = arr[index2] ;
        arr[index2] = temp ;
    }
    
    public static void printArray(int[] arr){
        for(int i=0 ; i<arr.length ; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    //Q.given an unsorted array . find the Kth minimum(k<logN)
    //Ex: 1 , 5 , -1 , 2 , 10 , 3 ---->k=3 , then kth min is 2.
    /**
     * modify bubble sort such that you sort only the first k elements.
     * this will be better than Arrays.sort()[nlongn] , because here k<logn , hence , loops<nlogn
     * same question can be done using selection sort also.
     */
    public static int kthminimum(int[] A , int k){
        int[] arr = A.clone();
        for(int i=0 ; i<k ; i++){              //run loop k times.
            boolean swapped = false;
            for(int j=arr.length-1 ; j>=i+1 ; j--){
                if(arr[j]<arr[j-1]){
                    swap(arr , j , j-1);
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
        return arr[k-1];
    }

    /**
     * SELECTION SORT
     * this is an in-place sorting algorithm as SC is of order 1. SC(1) .
     * TC:O(N^2)---> both best and worst case.
     * stability depends on way of implementation.
     * performs well on small lists.
     * this could also be implemented by putting maximum at the last index.
     */
    public static int[] selectionSort(int[] A){
        int[] arr = A.clone();

        for(int i=0 ; i<arr.length ; i++){
            //swap the smallest element in the remaining array with element at correct index.
            int first = i ;
            int minIndex = getMinIndex(arr , first , arr.length-1);
            swap(arr , first , minIndex);
        }
        return arr;
    }

    /**
     * INSERTION SORT
     * for every index , put that index element at the correct position in the LHS.
     * worst case TC: O(n^2)
     * best case TC: O(n)
     * SC: O(1)
     * number of swaps are reduced as compared to bubble sort.
     * used for smaller values of n.
     * works good when array is partially sorted. hence takes part in hybrid merging algorithms.
     * this will work for a stream of integers where we are getting data continuosly.(most optimal way to do so) 
     */
    public static int[] insertionSort(int[] A){
        int[] arr = A.clone();
        for(int i=0 ; i<A.length-1 ; i++){
            for(int j=i+1 ; j>0 ; j--){
                if(arr[j]<arr[j-1]){
                    swap(arr , j , j-1);
                }else{
                    break;
                }
            }
        }
        return arr;
    }

    /**
     * given 2 sorted arrays A[n] and B[m] return a new array C[n+m] with all elements of A and B being sorted in it.
     * A={3,8,9,12,13}
     * B={2,4,5,11}
     * C={2,3,4,5,8,9,11,12,13}
     * APPROACH 1 --> create new array c --> copy all elements from a and b to c(O(n+m)) --> sort c (O(n+m)log(n+m)) ==> O(nlogn)
     * APPROACH 2 --> copy A to C and then insert all elements of B in sorted order. --> tc: (O(m+n)*n) ==> O(n^2) 
     * APPROACH 3 --> 2 pointer method pointing to the current smallest elements of the 2 arrays. O(m+n) . SC: O(1(considering extra space.))
     */
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

    public static void main(String[] args){

        int[] arr = {5,4,0,-3,3,2,1};
        int[] arr1 = {1,3,7,9};
        int[] arr2 = {-3,1,5};

        // System.out.println(kthminimum(arr , 3));

        // System.out.println(Arrays.toString(selectionSort(arr)));

        // System.out.println(Arrays.toString(insertionSort(arr)));

        System.out.println(Arrays.toString(merge2SortedArrays(arr1 , arr2)));
    }
}


















































































// // for(int i=0 ; i<n ; i++){
// //     min=A[i];
// //     minIndex=i;
// //     for(int j=i+1 ; j<n ; j++){
// //         if(A[j]<min){
// //             min=A[j];
// //             minIndex=j;
// //         }
// //     }
// //     swap(A[i] , A[minIndex]);
// // }
// import java.util.ArrayList;

// public class sorting2{

//     public static void printArray(int[] A){
//         for(int i=0 ; i<A.length ; i++){
//             System.out.print(A[i]+" ");
//         }
//         System.out.println();
//     }

//     public static void printArrayList(ArrayList<Integer> A){
//         for(int i=0 ; i<A.size() ; i++){
//             System.out.print(A.get(i)+" ");
//         }
//         System.out.println();
//     }

//     /*
//        SELECTION SORT
//      * algorithms having constant space complexity are known as in-place sorting algorithms
//        both select sort and bubble sort are in-place
//        select and bubble both can be implemented in stable / non-stable way with the use of '='
//      * best case and worst case TC is O(N^2).
//      * performs well on small arrays.
//     */
//     public static int[] selectionSort(int[] A){
//         return A;
//     }

//     /**
//      * INSERTION SORT
//      * O(n) TC per insertion . overall TC O(n^2) . worst case(all in decreasing order)-->O(n^2) . best case(array is already sorted)-->O(n)
//      * SC(1)
//      * this will work for a stream of integers where we are getting data continuosly.(most optimal way to do so.) 
//      */
//     public static ArrayList<Integer> insertionSort(int[] A , int k){  //k-->number of elements we want to sort 
//         //7,5,10,2,-1,3
//         int n = A.length;
//         ArrayList<Integer> sortedArray = new ArrayList<Integer>();
//         sortedArray.add(A[0]);
//         for(int i=1 ; i<k ; i++){                         //picking elements from A
//             for(int j=sortedArray.size()-1 ; j>=0 ; j--){ //comparing picked element with elements of arrayList.
//                 if(A[i]<sortedArray.get(j)){
//                     sortedArray.add(sortedArray.get(j));
//                     sortedArray.set(j , A[i]);
//                 }else{
//                     sortedArray.add(A[i]);
//                 }
//             }             
//         }
//         return sortedArray;
//     }

//     public static int[] insertionSortSir(int[] A , int k){   //k-->sort first k elements.
//         for(int i=0 ; i<k ; i++){
//             int element = A[i];
//             int j=i-1;
//             while(j>=0 && A[j]>element){
//                 A[j+1]=A[j];
//                 j--;
//             }
//             A[j+1] = element;
//         }
//         return A;
//     }

    // /**
    //  * given 2 sorted arrays A[n] and B[m] return a new array C[n+m] with all elements of A and B being sorted in it.
    //  * A={3,8,9,12,13}
    //  * B={2,4,5,11}
    //  * C={2,3,4,5,8,9,11,12,13}
    //  * APPROACH 1 --> create new array c --> copy all elements from a and b to c(O(n+m)) --> sort c (O(n+m)log(n+m)) ==> O(nlogn)
    //  * APPROACH 2 --> copy A to C and then insert all elements of B in sorted order. --> tc: (O(m+n)*n) ==> O(n^2) 
    //  * APPROACH 3 --> 2 pointer method pointing to the current smallest elements of the 2 arrays. O(m+n) . SC: O(1(considering extra space.))
    //  */
//     public static int[] mergeSort(int[] A , int[] B){
//         int[] C = new int[A.length+B.length];
//         int i=0;//points on A
//         int j=0;//points on B
//         int k=0;//points at new current index to keep the element in C
//         while(i<A.length && j<B.length){
//             if(A[i]<B[j]){
//                 C[k]=A[i];
//                 i++;
//             }else{
//                 C[k]=B[j];
//                 j++;
//             }
//             k++;
//         }
//         if(i==A.length){
//             while(j<B.length){
//                 C[k] = B[j];
//                 j++;
//                 k++;
//             }
//         }else{
//             while(i<A.length){
//                 C[k] = A[i];
//                 i++;
//                 k++;
//             }
//         }
//         return C;
//     }

//     public static void main(String[] args){

//         int[] arr = {7,5,10,2,-1,3};
//         printArrayList(insertionSort(arr , 3));


//         int[] arr1 = {1,3,6,8,11};
//         int[] arr2 = {2,4,6,10,12,15,23,25};


        
//         // printArray(insertionSortSir(arr , 1));
//         // printArray(insertionSortSir(arr , 2));
//         // printArray(insertionSortSir(arr , 3));
//         // printArray(insertionSortSir(arr , 4));
//         // printArray(insertionSortSir(arr , 5));
//         // printArray(insertionSortSir(arr , 6));

//         // printArray(mergeSort(arr1 , arr2));
//     }
// }



// /**
//  * selection sort
//  * insertion sort
//  */