// //Q.[1,3,4,4,5,8,8,8,9,9,10,10] print first and last index of target element in sorted array. 
//HW. optimize code using information that the array is sorted.


// import java.lang.*;
// import java.util.*;

// public class Main {

//     static void minmax(int[] arr , int target){
//         for (int i = 0; i < arr.length; i++) {
//             if(arr[i]==target){
//                 System.out.println("first index: "+i);
//                 break;
//             }
//         }
//         for (int i = arr.length-1; i >=0 ; i--) {
//             if(arr[i]==target){
//                 System.out.println("last index: "+i);
//                 break;
//             }
//         }
//     }

// //    static void minmax (int[] arr , int target){
// //        for (int i = 0; i < arr.length; i++) {
// //            if((arr[i]!=target && arr[i+1]==target)){
// //                System.out.println((i+1)+" ");
// //            }else if(arr[i]==target && arr[i+1]!=target){
// //                System.out.println(i);
// //                break;
// //            }
// //        }
// //    }
//     public static void main(String[] args) {
//         int[] arr = {1,3,4,4,5,8,8,8,9,10,10,10};
//         Scanner sc = new Scanner(System.in);
//         int target = sc.nextInt();
//         minmax(arr , target);
//     }
// }

















// //Q.return the element which occurs only once. all other elements return twice.
// import java.lang.*;
// import java.util.*;

// public class Main {

//     //worst case iterations--> n*n
//     //no of iterations in 1sec-->10^8.
//     //if our number of iterations are less than 10^8 then we are ok to go.
//     static int single(int[] arr){
//         for (int i = 0; i < arr.length; i++) {
//             //targer --> arr[i]
//             int count =0;
//             //make a function--> "frequency of target element" instead of this for loop.
//             for (int j = 0; j <arr.length ; j++) {
//                 if(arr[i]==arr[j]){
//                     count++;
//                 }
//             }
//             if(count==1){
//                 return arr[i];
//             }
//         }
//         return -1;
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int[] arr = {2,4,5,2,1,5,4,10,10};
//         System.out.println(single(arr));
//     }
// }














// //Q. write a function which takes an array and returns the count of elements which have at least one element greater than them it the array.
// import java.lang.*;
// import java.util.*;

// public class Main {

//     static int frequency(int target , int[] arr){
//         int count = 0;
//         for (int i = 0; i < arr.length; i++) {
//             if(arr[i]==target){
//                 count++;
//             }
//         }
//         return count;
//     }

//     static int max(int[] arr){
//         int max = arr[0];
//         for (int i = 0; i < arr.length-1; i++) {
//             if(arr[i+1]>arr[i]){
//                 max = arr[i+1];
//             }
//         }
//         return max;
//     }
//     static int number(int[] arr){ //2n iterations. //find frequency of largest element.
//         int count = frequency(max(arr) , arr);
//         return (arr.length-count);
//     }


// //    static int number(int[] arr){ //n^2 iterations.
// //        int count = 0;
// //        for (int i = 0; i <arr.length ; i++) {
// //            //a[i]-->target element.
// //            for (int j = 0; j < arr.length; j++) {
// //                if(arr[j]>arr[i]){
// //                    count++;
// //                    break;
// //                }
// //            }
// //        }
// //        return count;
// //    }
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int[] arr = {4,6,1,3,8,9,0,0,0};
//         System.out.println(number(arr));
//     }
// }