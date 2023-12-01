//changes made to array inside a function is also reflected in them main function.
//beacause array is not passed by value , it is passed by reference.
//integers are passed by value , hence changes made inside function are not reflected inside main.\












//Q. write a function to rotate the array k times.
// import java.lang.*;
// import java.util.*;

// public class Main {
//     public static void main(String[] args) {
//         Scanner sc  =new Scanner(System.in);

//         int k = sc.nextInt();

//         int[] arr = {1,2,3,4,5,6,7,8,9};

//         System.out.print("original: ");

//         for (int i = 0; i < arr.length; i++) {
//             System.out.print(arr[i]+" ");
//         }

//         System.out.println();
// //maximum number of rotations we can have are n-1. effective value of k is : k%n.
//         k = k%(arr.length);
//         while(k>0){

//             int t = arr[arr.length-1];

//             for (int i = arr.length-2; i >=0; i--) {
//                 arr[i+1] = arr[i];
//             }

//             arr[0] = t;

//             for (int i = 0; i < arr.length; i++) {
//                 System.out.print(arr[i]+" ");
//             }

//             k--;

//             System.out.println();
//         }
//     }
// }

















//Q. write a function to create a dynamic array.
// import java.lang.*;
// import java.util.*;

// public class Main {

//     static int[] insert(int[] arr , int input , int index){

//         if(index<1){
//             arr[index] = input;
//             index*=2;                  //index+=1 causes lot of iterations(n per value). 2*index gives way less iterations(1 per value)
//             return arr;
//         }
//         else if(index>=1){
//             int[] arr2 = new int[index+1];
//             for (int i = 0; i < index; i++) {
//                 arr2[i] = arr[i];
//             }
//             arr2[index] = input;
//             index*=2;
//             return arr2;
//         }

//         index*=2;
//         return arr;
//     }

//     public static void main(String[] args) {
//         int index = 0;
//         Scanner sc  =new Scanner(System.in);
//         int n = sc.nextInt();
//         int[] A = new int[1];
//         for (int i = 0; i < n; i++) {
//             int input = sc.nextInt();
//             A = insert(A , input , index);
//             index++;
//         }
//         for (int i = 0; i < A.length; i++) {
//             System.out.print(A[i]+" ");
//         }
//     }
// }

